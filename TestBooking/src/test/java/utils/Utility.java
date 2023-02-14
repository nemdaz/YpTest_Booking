package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	public static String dateChangeFormat(String date, String oldFormat, String newFormat) {
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

	public static List<Double> numbersFromString(String strInput) {
		Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
		Matcher matcher = regex.matcher(strInput);
		List<Double> numbers = new ArrayList<Double>();
		while (matcher.find()) {
			//System.out.println(matcher.group(1));
			numbers.add(Double.parseDouble(matcher.group(1)));	
		}
		return numbers;
	}
	
	public static Double numberFromString(String strDouble) {
		return numbersFromString(strDouble).get(0);
	}
}
