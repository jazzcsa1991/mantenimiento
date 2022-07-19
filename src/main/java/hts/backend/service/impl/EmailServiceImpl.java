package hts.backend.service.impl;

import hts.backend.model.dto.ReporteDatosHospitalDTO;
import hts.backend.model.dto.PresupuestoConsultaDTO;
import hts.backend.model.dto.PresupuestoPaquetesDTO;
import hts.backend.model.dto.PresupuestoPrestacionesDTO;
import hts.backend.service.EmailService;
import hts.backend.model.dto.AdmPrestacionesPaquetesDTO;

import hts.backend.utils.Fechas;
import hts.backend.utils.PropertiesFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

@Service("emailService")
@Transactional
public class EmailServiceImpl implements EmailService {


	private Message getMessage() throws MessagingException {
		Properties props = new Properties();
		Properties propiedad = PropertiesFile.getFilepropiedad();

		props.put("mail.smtp.host", String.valueOf(propiedad.getProperty("mail.smtp.host")));
		props.put("mail.smtp.socketFactory.port", String.valueOf(propiedad.getProperty("mail.smtp.socketFactory.port")));
		props.put("mail.smtp.socketFactory.class", String.valueOf(propiedad.getProperty("mail.smtp.socketFactory.class")));
		props.put("mail.smtp.auth", String.valueOf(propiedad.getProperty("mail.smtp.auth")));
		props.put("mail.smtp.port", String.valueOf(propiedad.getProperty("mail.smtp.port")));

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(String.valueOf(propiedad.getProperty("mail.auth.username")), String.valueOf(propiedad.getProperty("mail.auth.password")));
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(String.valueOf(propiedad.getProperty("mail.fromAddress"))));

		return message;
	}


	@Override
	public boolean send() {
		try {
			Message message = getMessage();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("juan.castaeda06@gmail.com"));
			message.setSubject("Mensaje de prueba - GUS");
			message.setContent("Mensaje de prueba.", "text/html; charset=UTF-8");

			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean sendPasswordRecovery(String destinatario, String clave, String nombre) {
		Properties propiedad = PropertiesFile.getFilepropiedad();
		String publicAddress = String.valueOf(propiedad.getProperty("sys.publicAddress.AdminFrontend"));

		try {
			Message message = getMessage();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Recuperación de contraseña - GUS");
			message.setContent("" +
							"Hola, " + nombre + "." +
							"<br>" +
							"Se recibió una solicitud de recuperación de contraseña." +
							"<br><br>" +
							"Ingrese a la siguiente ruta (o copie y pegue en su navegador) para restablecer la contraseña de su cuenta." +
							"<br>" +
							"<a target=\"_blank\" href=\"" + publicAddress + "/login/#/reset=" + clave + "\">" + publicAddress + "/login/#/reset=" + clave + "</a>" +
							"<br>" +
							"<br>" +
							"<hr>" +
							"<small>Nota: La clave de recuperación tiene una vigencia de 1 hora. Si usted no solicitó la recuperación de contraseña, haga caso omiso del presente mensaje.</small>" +
							"<br>" +
							"<small>Mensaje enviado de forma automática desde una cuenta no supervisada. Por favor no lo conteste.</small>"
					, "text/html; charset=UTF-8");

			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean sendPasswordRecoveryConfirm(String destinatario, Date fecha) {
		try {
			Message message = getMessage();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Restablecimiento de contraseña - GUS");
			message.setContent("" +
							"Hola." +
							"<br>" +
							"<br>" +
							"Le confirmamos que cambió la contraseña de acceso a su cuenta GUS: " + Fechas.formato("YYYY-MM-dd '@' HH:mm:ss", fecha) +
							"<br>" +
							"<br>" +
							"<hr>" +
							"<small>Si usted no realizó el cambio, contacte de inmediato al administrador del sistema.</small>" +
							"<br>" +
							"<small>Mensaje enviado de forma automática desde una cuenta no supervisada. Por favor no lo conteste.</small>"
					, "text/html; charset=UTF-8");

			Transport.send(message);

			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean enviarPresupuesto(ReporteDatosHospitalDTO hospital, String paciente, String usuario, String tipoEvento, PresupuestoConsultaDTO mapa, List<String> correos, Integer presupuestoId) {
		try {
			Locale locale = new Locale("es", "MX");
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
			Double totalGlobalPaquetes = 0.0;
			Double totalGlobalPrestaciones = 0.0;
			String msj = "" +
					"<div style=\"font-family: sans-serif; text-align: center;\"> " +
					"<h1 style=\"font-size: 25px; color: #357bb7; margin-bottom: 0;\">" + hospital.getNombre() + "</h1> " +
					"<p style=\"font-size: 12px; margin-bottom: 25px; margin-top: 10px;\"> " +
					hospital.getCalle() + " #" + hospital.getNumeroExterior() + hospital.getNumeroExteriorLetra() + " - " + hospital.getNumeroInterior() + hospital.getNumeroInteriorLetra() + ", " + hospital.getAsentamiento() +
					"<br> " +
					hospital.getMunicipio() + ", " + hospital.getEstado() + ", " + hospital.getPais() + ". CP " + hospital.getCodigoPostal() +
					"<br> " +
					"<br> " +
					"<b>Licencia Sanitaria:</b> " + hospital.getLicenciaSanitaria() +
					"<br> " +
					"<b>Teléfono:</b> " + hospital.getTelefono() +
					"</p> " +
					"<b style=\"border-top: 2px solid #357bb7; padding-top: 10px; padding-left: 30px; padding-right: 30px; color: navy;\">Presupuesto " + tipoEvento + "</b> " +
					"<br> " +
					"<br> " +
					"<i style=\"font-size: 14px;\"><b>Fecha:</b> " + Fechas.formato("YYYY-MM-dd '@' HH:mm:ss", new Date()) + "</i> " +
					"<br> " +
					"<i style=\"font-size: 14px;\"><b>Paciente:</b> " + paciente + "</i> " +
					"<br> " +
					"<i style=\"font-size: 14px;\"><b>Elaboración:</b> " + usuario + "</i> " +
					"</div> ";
			if (mapa.getPaquetes().size() > 0) {
				msj = msj + "<h2 style=\"font-size: 18px; font-family: sans-serif; color: navy;\">Paquetes</h2> ";
				for (PresupuestoPaquetesDTO paquetesDTO : mapa.getPaquetes()) {

					msj = msj + "<table style=\"width:100%; border: 2px solid black; border-collapse: collapse; font-family: sans-serif; font-size: 14px;\"> ";

					msj = msj + "<thead> " +
							"<tr> " +
							"<th colspan=\"2\" style=\"text-align: left; padding: 5px 10px; border-bottom: 1px solid black; font-weight: normal;\"><b>Paquete:</b> " + paquetesDTO.getNombrePaquete() + "</th> " +
							"<th colspan=\"2\" style=\"text-align: right; padding:5px 10px; border-bottom: 1px solid black; font-weight: normal;\"><b>Cantidad:</b> " + paquetesDTO.getCantidad() + "</th> " +
							"</tr> " +
							"<tr style=\"background: #CDCDCD;\"> " +
							"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Prestación</th> " +
							"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Tipo</th> " +
							"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Cantidad incluida</th> " +
							"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Cantidad total</th> " +
							"</tr> " +
							"</thead> " +
							"<tbody> ";
					if (paquetesDTO.getPrestaciones().size() > 0) {
						for (AdmPrestacionesPaquetesDTO prestaciones : paquetesDTO.getPrestaciones()) {
							msj = msj + "<tr style=\"border-bottom: 1px dashed #CDCDCD;\"> " +
									"<td style=\"padding: 5px;\"> " + prestaciones.getPrestacion() + "</td> " +
									"<td style=\"padding: 5px;\"> " + prestaciones.getNombreP1() + "</td> " +
									"<td style=\"padding: 5px;text-align: center;\"> " + prestaciones.getCantidad() + "</td> " +
									"<td style=\"padding: 5px;text-align: center;\"> " + prestaciones.getCantidadTotal() + "</td> " +
									"</tr> ";
						}
					}
					msj = msj + "</tbody> " +
							"<tfoot> " +
							"<tr> " +
							"<th colspan=\"2\" style=\"padding: 10px 0; border-top: 1px solid black; font-weight: normal;\"><b>Precio unitario:</b> " + currencyFormatter.format(paquetesDTO.getPrecioIndividualPaquete()) + "</th> " +
							"<th style=\"text-align: right; padding: 10px 0; border-top: 1px solid black;\">Total:</th> " +
							"<th style=\"padding: 10px 0; border-top: 1px solid black; font-weight: normal;\"> " + currencyFormatter.format(paquetesDTO.getPrecioGlobalPaquete()) + "</th> " +
							"</tr> " +
							"</tfoot> " +
							"</table> " +
							"<br>";


					totalGlobalPaquetes = totalGlobalPaquetes + paquetesDTO.getPrecioGlobalPaquete();
				}
			}
			if (mapa.getPrestaciones().size() > 0) {
				msj = msj + "<hr> " +
						"<h2 style=\"font-size: 18px; font-family: sans-serif; color: navy;\">Prestaciones</h2> " +
						"<table style=\"width:100%; border: 2px solid black; border-collapse: collapse; font-family: sans-serif; font-size: 14px;\"> " +
						"<thead> " +
						"<tr style=\"background: #CDCDCD;\"> " +
						"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Prestación</th> " +
						"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Tipo</th> " +
						"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Cantidad</th> " +
						"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Precio unitario</th> " +
						"<th style=\"text-align: center; border-bottom: 1px solid black; padding-top: 5px; padding-bottom: 5px;\">Subtotal</th> " +
						"</tr> " +
						"</thead> " +
						"<tbody> ";

				for (PresupuestoPrestacionesDTO prestacionesDTO : mapa.getPrestaciones()) {
					msj = msj +
							"<tr style=\"border-bottom: 1px dashed #CDCDCD;\"> " +
							"<td style=\"padding: 5px;\"> " + prestacionesDTO.getPrestacion() + "</td> " +
							"<td style=\"padding: 5px;\"> " + prestacionesDTO.getTipoPrestacion() + "</td> " +
							"<td style=\"padding: 5px;\"> " + prestacionesDTO.getCantidad() + "</td> " +
							"<td style=\"padding: 5px;text-align: center;\"> " + currencyFormatter.format(prestacionesDTO.getPrecioUnitario()) + "</td> " +
							"<td style=\"padding: 5px;text-align: center;\"> " + currencyFormatter.format(prestacionesDTO.getPrecioTotal()) + "</td> " +
							"</tr> ";
					totalGlobalPrestaciones = totalGlobalPrestaciones + prestacionesDTO.getPrecioTotal();
				}

				msj = msj + "</tbody> " +
						"<tfoot> " +
						"<tr> " +
						"<th colspan=\"4\" style=\"text-align: right; padding: 10px 0; border-top: 1px solid black; font-weight: normal;\"><b>Total:</b></th> " +
						"<th style=\"padding: 10px 0; border-top: 1px solid black; font-weight: normal;\"> " + currencyFormatter.format(totalGlobalPrestaciones) + "</th> " +
						"</tr> " +
						"</tfoot> " +
						"</table> " +
						"<br> " +
						"<hr> " +
						"<br> ";
			}
			Double total = totalGlobalPrestaciones + totalGlobalPaquetes;
			msj = msj +
					"<table style=\"width:100%; border: 2px solid black; border-collapse: collapse; font-family: sans-serif; font-size: 16px;\"> " +
					"<tbody> " +
					"<td style=\"text-align: right; padding: 10px 10px; border-top: 1px solid black; font-weight: normal;\"><b>Gran Total:</b></td> " +
					"<td style=\"padding: 10px 10px; border-top: 1px solid black; font-weight: normal;\"> " + currencyFormatter.format(total) + "</td> " +
					"</tbody> " +
					"</table> " +
					"<br> " +
					"<p style=\"font-family: sans-serif; font-size: 13px; color: #357bb7;\"> " +
					"Los precios mostrados no incluyen los impuestos aplicables y están sujetos a cambio sin previo aviso. " +
					"</p>" +
					"<br> ";

			for (String correo : correos) {

				String msjPer = "<p style=\"font-family: sans-serif; font-size: 11px; color: #444;\"> " +
						"Recibe este mensaje debido a que solicitó el envío de un presupuesto a la dirección de correo electrónico: <b>" + correo + "</b>. En caso de desconocer la información o el destinatario, por favor haga caso omiso y elimine el mensaje. " +
						"<br> " +
						"<br> " +
						"Servicio automático de envío de presupuestos. Esta dirección de correo electrónico no es monitoreada, por favor no responda este mensaje. " +
						"</p>";
				Message message = getMessage();
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
				message.setSubject("Presupuesto #" + presupuestoId + " - " + hospital.getNombreCorto());
				message.setContent(msj + msjPer, "text/html; charset=UTF-8");

				Transport.send(message);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}






























