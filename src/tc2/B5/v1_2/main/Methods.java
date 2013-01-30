package tc2.B5.v1_2.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Methods {


	public static String  convert_millsec_to_digit_label(long millSeconds) {
		/*----------------------------
		 * Steps
		 * 1. Prepare variables
		 * 2. Build a string
		 * 3. Return
			----------------------------*/
		/*----------------------------
		 * 1. Prepare variables
			----------------------------*/
		int sec_time = (int)(millSeconds / 1000);
		
		int seconds = sec_time % 60;
		
		int minutes = sec_time / 60;
		
		int hours = sec_time / (60 * 60);
		
		if (minutes > 59) {
			
			minutes = 59;
			
		}//if (minutes == condition)
		
//		int digit_seconds = sec_time % 60;
		
		/*----------------------------
		 * 2. Build a string
			----------------------------*/
		StringBuilder sb = new StringBuilder();
		
		if (String.valueOf(hours).length() < 2) {
			
			sb.append("0");
			
		}//if (String.valueOf(hours).length() < 2)
		
		sb.append(String.valueOf(hours));
		sb.append(":");

		if (String.valueOf(minutes).length() < 2) {
			
			sb.append("0");
			
		}//if (String.valueOf(minutes).length() < 2)
		
		sb.append(String.valueOf(minutes));
		sb.append(":");

		if (String.valueOf(seconds).length() < 2) {
			
			sb.append("0");
			
		}//if (String.valueOf(seconds).length() < 2)

		sb.append(String.valueOf(seconds));
		
		/*----------------------------
		 * 3. Return
			----------------------------*/
		return sb.toString();
		
	}//public static void  convert_millsec_to_digit_label()

	public static String get_time_Label(long millSec) {
		
		 SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy ");
		 
		return sdf1.format(new Date(millSec));
		
	}//public static String get_time_Label(long millSec)

	public static long get_millsec_now() {
		
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime().getTime();
		
	}//public static long get_millsec_now()

}
