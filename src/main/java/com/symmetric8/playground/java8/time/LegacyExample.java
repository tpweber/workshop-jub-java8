package com.symmetric8.playground.java8.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Relation between <code>java.time.*</code> and the old-way with <code>Date</code> and <code>Calendar</code>.
 */
public class LegacyExample {
  public static void main(final String[] args) {
    final Date now = new Date();
    final Instant nowAsInstant = now.toInstant();

    final ZoneId myZone = ZoneId.systemDefault();
    final LocalDateTime localDateTime = LocalDateTime.ofInstant(nowAsInstant, myZone);

    final ZoneId zoneCalifornia = ZoneId.of("America/Los_Angeles");
    final ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(nowAsInstant, zoneCalifornia);

    System.out.println("LocalDateTime: " + localDateTime);
    System.out.println("ZonedDateTime: " + zonedDateTime);

    final GregorianCalendar nowAsCalendar = new GregorianCalendar();
    final ZonedDateTime nowAszonedDateTime = nowAsCalendar.toZonedDateTime();

    final Instant instant = nowAszonedDateTime.toInstant();
    System.out.println("Instant by GregorianCalendar: " + instant);

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
    System.out.println("Instant by Calendar: " + calendar.toInstant());
  }
}