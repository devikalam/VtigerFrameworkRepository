package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	
public String getSystemDate(){
			Date dateObj=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
			return date;
		}
			
public String getDaysLater(int days) {

		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	    sim.format(dateobj);   
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String dateRequires = sim.format(cal.getTime());
		System.out.println(dateRequires);
		return dateRequires;
	}

		
//	public String getrequiredSystemDate(int days) {
//	
//SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
//		
//		Calendar cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, days);
//		String requiredDate = sim.format(cal.getTime());
//		return requiredDate;
//		
//}
		}
		
		
	


