package com.symmetric8.playground.java8.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * <code>ZonedDateTime</code> .
 */
public class ZonedDateTimeExample {
  public static void main(final String[] args) {
    final ZoneId zoneUTC = ZoneId.of("UTC");
    final ZonedDateTime nowUTC = ZonedDateTime.now(zoneUTC);

    final ZonedDateTime nowButChangedTime = nowUTC.withHour(11).withMinute(22);

    final ZonedDateTime dateAndTime = nowButChangedTime.withYear(2014).
        withMonth(12).
        withDayOfMonth(25);

    final ZonedDateTime dateAndTime2 = nowButChangedTime.withYear(2014).
        withMonth(Month.DECEMBER.getValue()).
        withDayOfMonth(25);


    final ZoneId zoneCalifornia = ZoneId.of("America/Los_Angeles");
    final ZonedDateTime dateAndTime3 = nowButChangedTime.withZoneSameLocal(zoneCalifornia);
    final ZonedDateTime dateAndTime4 = nowButChangedTime.withZoneSameInstant(zoneCalifornia);

    System.out.println("now UTC: " + nowUTC);
    System.out.println("now default: " + nowUTC.withZoneSameInstant(ZoneId.systemDefault()));
    System.out.println("-> 11:22: " + nowButChangedTime);
    System.out.println("-> 25.12.2014: " + dateAndTime);
    System.out.println("-> 25.12.2014: " + dateAndTime2);
    System.out.println("-> LA same local: " + dateAndTime3);
    System.out.println("-> LA same instant: " + dateAndTime4); // CET - 9 hours

    final ZoneId zoneBerlin = ZoneId.of("Europe/Berlin");
    final LocalDate dateDepartBerlin = LocalDate.now().plusDays(1);
    final LocalTime timeDepartBerlin = LocalTime.of(11, 0);
    final ZonedDateTime departBerlin = ZonedDateTime.of(dateDepartBerlin, timeDepartBerlin, zoneBerlin);
    final ZonedDateTime arrivalLA = departBerlin.plus(12, ChronoUnit.HOURS).plusMinutes(15).withZoneSameInstant(zoneCalifornia);
    System.out.println("berlin depart -> " + departBerlin);
    System.out.println("los angeles arrival -> " + arrivalLA);

  }
}