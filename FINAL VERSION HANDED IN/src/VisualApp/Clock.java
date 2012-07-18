package VisualApp;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Class Clock
 * In here we are getting time from system that is displayed into the 
 * MapWindowsJFrame
 *@author Michal Musialik 
 */

public class Clock {



	public String CurrentTime() {
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm:ss");
		return simpleDate.format(calender.getTime());

	}

}
