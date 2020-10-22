package com.cts.truyum.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
      public LocalDateTime convertToDate(String date) {
    	  DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	  LocalDateTime dat=LocalDateTime.parse(date, formatter);
    	  return dat;
      }
}
