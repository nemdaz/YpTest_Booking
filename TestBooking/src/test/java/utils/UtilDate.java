package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UtilDate {

	public static String changeFormat(String date, String oldFormat, String newFormat) {
		String newDate = date;
		
		SimpleDateFormat oFormat = new SimpleDateFormat(oldFormat, new Locale("es"));
		SimpleDateFormat nFormat = new SimpleDateFormat(newFormat, new Locale("es"));
		
		try {
			Date oDate = oFormat.parse(date);
			newDate = nFormat.format(oDate);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("No se puede formatear la fecha.");
		}
		
		return newDate;
	}
}
