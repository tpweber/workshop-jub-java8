package com.symmetric8.playground.java8.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Calculations the old-fashioned way...
 */
public class OldApiDurationCalculationExample {
  public static void main(final String[] args) throws ParseException {
    final String startTimeAsString = "10:10:10";
    final String endTimeAsString = "11:20:30";

    final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    final Date startTimee = dateFormat.parse(startTimeAsString);
    final Date endTime = dateFormat.parse(endTimeAsString);

    final long durationInMs = endTime.getTime() - startTimee.getTime();
    System.out.println("duration in seconds = " + TimeUnit.MILLISECONDS.toSeconds(durationInMs));

    final String duration1 = dateFormat.format(new Date(durationInMs));
    System.out.println("duration 1 = " + duration1);

    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    final String duration2 = dateFormat.format(new Date(durationInMs));
    System.out.println("duration2 = " + duration2);
  }
}