package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class <code>java.time.LocalDateTime</code>.
 */
public class LocalDateTimeTest {
  @Test
  public void testLocalDateTimeCreation() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    assertEquals(2014, date1.getYear());
    assertEquals(Month.DECEMBER, date1.getMonth());
    assertEquals(12, date1.getMonthValue());
    assertEquals(24, date1.getDayOfMonth());
    assertEquals(358, date1.getDayOfYear());
    assertEquals(DayOfWeek.WEDNESDAY, date1.getDayOfWeek());
    assertEquals(18, date1.getHour());
    assertEquals(36, date1.getMinute());
    assertEquals(54, date1.getSecond());
    assertEquals(0, date1.getNano());
    assertEquals(IsoChronology.INSTANCE, date1.getChronology());
    LocalDate localDate = LocalDate.of(2014, Month.DECEMBER, 24);
    LocalTime localTime = LocalTime.of(18, 36, 54);
    LocalDateTime date2 = LocalDateTime.of(localDate, localTime);
    assertEquals(date1, date2);
  }

  @Test
  public void testConversions() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    LocalDate localDate = LocalDate.of(2014, Month.DECEMBER, 24);
    LocalTime localTime = LocalTime.of(18, 36, 54);
    assertEquals(localDate, date1.toLocalDate());
    assertEquals(localTime, date1.toLocalTime());
  }

  @Test
  public void testArithmeticOperations() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    assertEquals(LocalDateTime.of(2012, Month.DECEMBER, 24, 18, 36, 54), date1.minusYears(2));
    assertEquals(LocalDateTime.of(2018, Month.DECEMBER, 24, 18, 36, 54), date1.plusYears(4));
    assertEquals(LocalDateTime.of(2014, Month.SEPTEMBER, 24, 18, 36, 54), date1.minusMonths(3));
    assertEquals(LocalDateTime.of(2015, Month.DECEMBER, 24, 18, 36, 54), date1.plusMonths(12));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 3, 18, 36, 54), date1.minusWeeks(3));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 31, 18, 36, 54), date1.plusWeeks(1));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 23, 18, 36, 54), date1.minusDays(1));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 25, 18, 36, 54), date1.plusDays(1));
    assertEquals(date1, date1.plusDays(2).minusDays(3).plusDays(1));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 16, 36, 54), date1.minusHours(2));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 22, 36, 54), date1.plusHours(4));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 25, 14, 36, 54), date1.plusHours(20));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 19, 8, 54), date1.plusMinutes(32));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 0, 54), date1.minusMinutes(36));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 37, 1), date1.plusSeconds(7));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 35, 59), date1.minusSeconds(55));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 37, 1), date1.plusSeconds(7));
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 0, 0), date1.plusSeconds(6).minusMinutes(37));
  }

  @Test
  public void testLocalDateTimeParse() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 22, 44, 11);
    LocalDateTime date2 = LocalDateTime.parse("2014-12-24T22:44:11");
    assertEquals(date1, date2);
    LocalDateTime date3 = LocalDateTime.parse("2014-12-24T22:44:11", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    assertEquals(date1, date3);
    LocalDateTime date4 = LocalDateTime.parse("24.12.2014 22:44:11", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    assertEquals(date1, date4);
  }
}
