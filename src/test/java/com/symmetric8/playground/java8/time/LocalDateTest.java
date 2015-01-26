package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static org.junit.Assert.*;

/**
 * Tests the class <code>java.time.LocalDate</code>.
 */
public class LocalDateTest {
  @Test
  public void testLocalDateCreation() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    assertEquals(2014, date1.getYear());
    assertEquals(Month.DECEMBER, date1.getMonth());
    assertEquals(12, date1.getMonthValue());
    assertEquals(24, date1.getDayOfMonth());
    assertEquals(358, date1.getDayOfYear());
    assertEquals(DayOfWeek.WEDNESDAY, date1.getDayOfWeek());
    assertFalse(date1.isLeapYear());
    assertEquals(IsoChronology.INSTANCE, date1.getChronology());
  }

  @Test
  public void testLocalDateUntil() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    Period period1 = date1.until(LocalDate.of(2014, Month.DECEMBER, 24));
    assertTrue(period1.isZero());
    Period period2 = date1.until(LocalDate.of(2015, Month.DECEMBER, 24));
    assertFalse(period2.isNegative());
    assertEquals(1, period2.getYears());
    assertEquals(0, period2.getMonths());
    assertEquals(0, period2.getDays());
    Period period3 = date1.until(LocalDate.of(2014, Month.DECEMBER, 1));
    assertTrue(period3.isNegative());
    assertEquals(0, period3.getYears());
    assertEquals(0, period3.getMonths());
    assertEquals(-23, period3.getDays());
    Period period4 = date1.until(LocalDate.of(2015, Month.JANUARY, 28));
    assertFalse(period4.isNegative());
    assertEquals(0, period4.getYears());
    assertEquals(1, period4.getMonths());
    assertEquals(4, period4.getDays());
  }

  @Test
  public void testLocalDateParse() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    LocalDate date2 = LocalDate.parse("2014-12-24");
    assertEquals(date1, date2);
    LocalDate date3 = LocalDate.parse("2014-12-24", DateTimeFormatter.ISO_LOCAL_DATE);
    assertEquals(date1, date3);
    LocalDate date4 = LocalDate.parse("24.12.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    assertEquals(date1, date4);
    LocalDate date5 = LocalDate.parse("24.12.2014 14:00", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    assertEquals(date1, date5);
  }

  @Test
  public void testLocalDateComparison() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 25);
    assertTrue(date1.isBefore(date2));
    assertTrue(date2.isAfter(date1));
    assertTrue(date1.isEqual(LocalDate.of(2014, Month.DECEMBER, 24)));
    assertEquals(-1, date1.compareTo(date2));
    assertEquals(1, date2.compareTo(date1));
    assertEquals(-2, date1.compareTo(LocalDate.of(2014, Month.DECEMBER, 26)));
    assertEquals(3, LocalDate.of(2014, Month.DECEMBER, 27).compareTo(date1));
  }

  @Test
  public void testLocalDateLeapYear() {
    LocalDate date1 = LocalDate.of(2014, Month.FEBRUARY, 24);
    assertFalse(date1.isLeapYear());
    assertEquals(365, date1.lengthOfYear());
    assertEquals(28, date1.lengthOfMonth());
    LocalDate date2 = LocalDate.of(2016, Month.FEBRUARY, 24);
    assertTrue(date2.isLeapYear());
    assertEquals(366, date2.lengthOfYear());
    assertEquals(29, date2.lengthOfMonth());
  }

  @Test
  public void testLocalDateAdjust() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    long epochDay1 = date1.toEpochDay();
    assertEquals(16428, epochDay1);
    Temporal temporal1 = date1.adjustInto(LocalDateTime.now());
    assertNotNull(temporal1);
    assertTrue(temporal1 instanceof LocalDateTime);
    LocalDateTime localDateTime1 = (LocalDateTime) temporal1;
    assertEquals(2014, localDateTime1.getYear());
    assertEquals(Month.DECEMBER, localDateTime1.getMonth());
    assertEquals(24, localDateTime1.getDayOfMonth());
  }

  @Test
  public void testLocalIsSupported() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    assertTrue(date1.isSupported(ChronoField.ERA));
    assertTrue(date1.isSupported(ChronoField.YEAR));
    assertTrue(date1.isSupported(ChronoField.YEAR_OF_ERA));
    assertTrue(date1.isSupported(ChronoField.MONTH_OF_YEAR));
    assertTrue(date1.isSupported(ChronoField.DAY_OF_MONTH));
    assertTrue(date1.isSupported(ChronoField.PROLEPTIC_MONTH));
    assertTrue(date1.isSupported(ChronoField.DAY_OF_YEAR));
    assertTrue(date1.isSupported(ChronoField.DAY_OF_WEEK));
    assertTrue(date1.isSupported(ChronoField.EPOCH_DAY));
    assertTrue(date1.isSupported(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    assertTrue(date1.isSupported(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    assertTrue(date1.isSupported(ChronoField.ALIGNED_WEEK_OF_MONTH));
    assertTrue(date1.isSupported(ChronoField.ALIGNED_WEEK_OF_YEAR));
    assertFalse(date1.isSupported(ChronoField.AMPM_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.CLOCK_HOUR_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.CLOCK_HOUR_OF_AMPM));
    assertFalse(date1.isSupported(ChronoField.INSTANT_SECONDS));
    assertFalse(date1.isSupported(ChronoField.HOUR_OF_AMPM));
    assertFalse(date1.isSupported(ChronoField.HOUR_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.MICRO_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.MICRO_OF_SECOND));
    assertFalse(date1.isSupported(ChronoField.MILLI_OF_SECOND));
    assertFalse(date1.isSupported(ChronoField.MILLI_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.MINUTE_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.MINUTE_OF_HOUR));
    assertFalse(date1.isSupported(ChronoField.NANO_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.NANO_OF_SECOND));
    assertFalse(date1.isSupported(ChronoField.OFFSET_SECONDS));
    assertFalse(date1.isSupported(ChronoField.SECOND_OF_DAY));
    assertFalse(date1.isSupported(ChronoField.SECOND_OF_MINUTE));

    assertTrue(date1.isSupported(ChronoUnit.CENTURIES));
    assertTrue(date1.isSupported(ChronoUnit.DAYS));
    assertTrue(date1.isSupported(ChronoUnit.DECADES));
    assertTrue(date1.isSupported(ChronoUnit.ERAS));
    assertTrue(date1.isSupported(ChronoUnit.MILLENNIA));
    assertTrue(date1.isSupported(ChronoUnit.MONTHS));
    assertTrue(date1.isSupported(ChronoUnit.WEEKS));
    assertTrue(date1.isSupported(ChronoUnit.YEARS));
    assertFalse(date1.isSupported(ChronoUnit.FOREVER));
    assertFalse(date1.isSupported(ChronoUnit.HALF_DAYS));
    assertFalse(date1.isSupported(ChronoUnit.HOURS));
    assertFalse(date1.isSupported(ChronoUnit.MICROS));
    assertFalse(date1.isSupported(ChronoUnit.MILLIS));
    assertFalse(date1.isSupported(ChronoUnit.MINUTES));
    assertFalse(date1.isSupported(ChronoUnit.NANOS));
    assertFalse(date1.isSupported(ChronoUnit.SECONDS));
  }
}
