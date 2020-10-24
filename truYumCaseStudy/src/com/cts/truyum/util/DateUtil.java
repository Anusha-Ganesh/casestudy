package com.cts.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
      public static Date convertToDate(String date) {
    	  Date parseDate=new Date();
    	  SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
    	  
    		  try {
				parseDate=format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		  
	        return parseDate;
    	  
    	  
      }
}
