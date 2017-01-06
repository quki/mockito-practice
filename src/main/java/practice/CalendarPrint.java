package practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarPrint {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 8, 31);
		String pattern = "yyyy.MM.dd";
		String theDay = toString(calendar, pattern);
		System.out.println(theDay);
	}
	private static String toString(Calendar calendar, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(calendar.getTime());
	}
}
