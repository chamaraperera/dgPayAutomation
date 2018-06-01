package Plus65.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatFunctions {
	
	public String getTodayDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		//System.out.println("Today: " + today);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(today));
		String formattedDateToday = new SimpleDateFormat("d/M/yyyy").format(today);
		return formattedDateToday;
	}

	public String getTomorrowDateFormat1() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// add one day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();
		// print out tomorrow's date
		//System.out.println("Tomorrow: " + tomorrow);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(tomorrow));
		String formattedDateTomorrow = new SimpleDateFormat("d/M/yyyy").format(tomorrow);
		return formattedDateTomorrow;
	}
	
	public String getTomorrowDateFormat2() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// add one day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();
		// print out tomorrow's date
		//System.out.println("Tomorrow: " + tomorrow);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(tomorrow));
		String formattedDateTomorrow = new SimpleDateFormat("yyyy-mm-dd").format(tomorrow);
		return formattedDateTomorrow;
	}

	public String getDayAfterTomorrowDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// add two days to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		// now get "tomorrow"
		Date dayAfterTomorrow = calendar.getTime();
		// print out tomorrow's date
		//System.out.println("Day After Tomorrow: " + dayAfterTomorrow);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(dayAfterTomorrow));
		String formattedDateDayAfterTomorrow = new SimpleDateFormat("d/M/yyyy").format(dayAfterTomorrow);
		return formattedDateDayAfterTomorrow;
	}
	

}
