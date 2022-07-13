package hts.backend.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import hts.backend.dao.PacienteDAO;
import hts.backend.entity.PacPaciente;
import hts.backend.model.EstatusResponse;
import hts.backend.model.RespuestaGenerica;
import hts.backend.model.dto.PacienteDTO;
import hts.backend.model.dto.PacienteDuplicadoDatosDTO;
import hts.backend.service.QRService;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@Service
public class QRServiceImpl implements QRService {
	
	@Resource
    private PacienteDAO pacienteDAO;
	
    private final static String REG_DESCONOCIDO = "Desconocido";
    private final static String REG_CORTO = "Corto";
    private final static String REG_COMPLETO = "Completo";
    private int OK = EstatusResponse.OK.getEstatus();
    private int ERR = EstatusResponse.ERROR.getEstatus();
    private String msjOK = "Servicio ejecutado correctamente";

	@Override
	public RespuestaGenerica generarQRPaciente(int idPaciente, String token) {
	    PacPaciente paciente = pacienteDAO.get(PacPaciente.class, idPaciente);
	
	    String urls = "http://qa-mdb.gus-sih.com/pacienteLog/";
	    StringBuilder stringBuilder = new StringBuilder();
	    ByteArrayOutputStream stream;
	    int idEvento = 2940;
	    String encodedString1 = Base64.getEncoder().encodeToString(Integer.toString(idPaciente).getBytes());
	    String encodedString2 = Base64.getEncoder().encodeToString(Integer.toString(idEvento).getBytes());
	    //String encodedString3 = Base64.getEncoder().encodeToString(token.getBytes());
	
	    if (paciente != null) {
	        try {
	            stringBuilder.append(urls);
	            stringBuilder.append('?');
	            stringBuilder.append("idPaciente=" + encodedString1);
	            stringBuilder.append('&');
	            stringBuilder.append("idEvento=" + encodedString2);
	            //	stringBuilder.append('&');
	            //	stringBuilder.append("Token=" + encodedString3);
	        } catch (Exception e) {
	            stringBuilder.append("error");
	            e.getMessage();
	        }
	
	        stream = QRCode.from(stringBuilder.toString()).to(ImageType.PNG).withSize(250, 250).stream();
	    } else {
	        stream = QRCode.from("NO_ENCONTRADO").to(ImageType.PNG).withSize(500, 500).stream();
	    }
	
	    String test = Base64.getEncoder().encodeToString(stream.toByteArray());
	
	    return new RespuestaGenerica(OK, msjOK, "qr", test);
	}

	@Override
	public RespuestaGenerica imprimirQRPaciente(int idPaciente) {
	    PacPaciente paciente = pacienteDAO.get(PacPaciente.class, idPaciente);
		
	    String urls = "http://qa-mdb.gus-sih.com/pacienteLog/";
	    StringBuilder stringBuilder = new StringBuilder();
	    ByteArrayOutputStream stream;
	    int idEvento = 2940;
	    String encodedString1 = Base64.getEncoder().encodeToString(Integer.toString(idPaciente).getBytes());
	    String encodedString2 = Base64.getEncoder().encodeToString(Integer.toString(idEvento).getBytes());
	
	    if (paciente != null) {
	        try {
	            stringBuilder.append(urls);
	            stringBuilder.append('?');
	            stringBuilder.append("idPaciente=" + encodedString1);
	            stringBuilder.append('&');
	            stringBuilder.append("idEvento=" + encodedString2);
	        } catch (Exception e) {
	            stringBuilder.append("error");
	            e.getMessage();
	        }
	
	        stream = QRCode.from(stringBuilder.toString()).to(ImageType.PNG).withSize(250, 250).stream();
	    } else {
	        stream = QRCode.from("NO_ENCONTRADO").to(ImageType.PNG).withSize(500, 500).stream();
	    }
	
	    String test = Base64.getEncoder().encodeToString(stream.toByteArray());
	    
	    Document document = new Document();
	    
	    File tmp2 = null;
	    File tmp = null;
	    try {
		  tmp = writeFile(File.createTempFile("TMP", ".png"), test);
		  tmp2 = File.createTempFile("TMP2", ".pdf");
	    	
	      FileOutputStream fos = new FileOutputStream(tmp2.getPath());
	      PdfWriter writer = PdfWriter.getInstance(document, fos);
	      writer.open();
	      document.open();
	      document.add(Image.getInstance(tmp.getPath()));
	      document.close();
	      writer.close();
	    }
	    catch (Exception e) {
	      tmp2.delete();
	      tmp.delete();
	      e.printStackTrace();
	    }
	    
	    
	    return new RespuestaGenerica(OK, msjOK, "qr", this.encodeFileToBase64(tmp2));
	}
	
	public static File writeFile(final File file, final String base) {
        byte[] decodedString = Base64.getDecoder().decode(base);
        return writeFile(file, decodedString);
    }
	
	public static File writeFile(final File file, final byte[] contenido) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(contenido);
            fos.close();
            
            return file;
        } catch (Exception e) {
        	return null;
        }
    }
	
	private static String encodeFileToBase64(File file) {
	    try {
	        byte[] fileContent = Files.readAllBytes(file.toPath());
	        return Base64.getEncoder().encodeToString(fileContent);
	    } catch (IOException e) {
	        throw new IllegalStateException("could not read file " + file, e);
	    }
	}

}
