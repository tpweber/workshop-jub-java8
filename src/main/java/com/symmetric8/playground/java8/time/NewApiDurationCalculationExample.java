package com.symmetric8.playground.java8.time;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Calculations the new way...
 */
public class NewApiDurationCalculationExample {
  public static void main(String[] args) throws ParseException {
    final String startTimeAsString = "10:10:10";
    final String endTimeAsString = "11:20:30";

    final LocalTime startTime = LocalTime.parse(startTimeAsString);
    final LocalTime endTime = LocalTime.parse(endTimeAsString);

    final Duration duration = Duration.between(startTime, endTime);
    final long durationInSecs = duration.getSeconds();

    System.out.println("duration = " + duration + " in secs = " + durationInSecs);

    final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    final LocalTime durationAsLocalTime = LocalTime.ofSecondOfDay(durationInSecs);
    System.out.println("durationInHHmmss = " + dateFormat.format(durationAsLocalTime));
  }
}