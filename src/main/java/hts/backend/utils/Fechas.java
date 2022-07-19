package hts.backend.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {

	public static Date fechahoy()
	{
		   Calendar cal = Calendar.getInstance();
		   return cal.getTime();
	}

	public static String formato(String formato,Date fecha)
	{
		 DateFormat formatter = new SimpleDateFormat(formato);

	     return formatter.format(fecha);
	}

	/**
	 * Metodo regresa año, mes y dias, entre la fecha actual y la fecha solicitada
	 * @author Rodrigo Davalos
	 * @param fechaCompararDate
	 * @return int[]
	 */
	public static int[] getPeriodoConFechaActual(Date fechaCompararDate)
	{
		/*Date fechaComparar = new GregorianCalendar(1980, 2, 7).getTime();*/

		LocalDate fechaCompararLocalDate = fechaCompararDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate currentdate = LocalDate.now();

		Period period = Period.between(fechaCompararLocalDate, currentdate);

		return new int[]{period.getYears(),period.getMonths(),period.getDays()};
	}

}
