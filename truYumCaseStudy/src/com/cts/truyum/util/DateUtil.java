package com.cts.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
      public static Date convertToDate(String date) throws ParseException {
    	  
    	  return new SimpleDateFormat("dd/MM/yyyy").parse(date);
      }
}
