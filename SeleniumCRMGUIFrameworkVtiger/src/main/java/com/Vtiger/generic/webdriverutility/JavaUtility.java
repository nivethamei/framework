package com.Vtiger.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int  getRandomNumber() {
		Random r=new Random();
		int random = r.nextInt(3000);
		return random;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dateobj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
       return date;
	}
	
	public String getRequiredDate(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String dates = sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH,days);
		String date = sim.format(cal.getTime());
		return date;
	}

	
	public static String toGetSystemDateAndTime()
	{
		Date d=new Date();
		String date[]=d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":","-");
		String year = date[5];
		
		String finaldate = day+" "+month+" "+date1+" "+time+" "+year;
		return finaldate;
		
	}

}
