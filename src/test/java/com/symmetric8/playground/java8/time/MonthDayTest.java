package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

import static org.junit.Assert.*;

/**
 * Tests for <code>java.time.YearMonth</code>
 */
public class MonthDayTest {
  @Test
  public void testCreation() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    MonthDay monthDay2 = MonthDay.of(Month.DECEMBER, 24);
    assertEquals(12, monthDay1.getMonthValue());
    assertEquals(Month.DECEMBER, monthDay1.getMonth());
    assertEquals(24, monthDay1.getDayOfMonth());
    assertEquals(monthDay1, monthDay2);
    MonthDay monthDay3 = MonthDay.from(LocalDate.of(2014, 12, 24));
    assertEquals(monthDay1, monthDay3);
  }

  @Test(expected = DateTimeException.class)
  public void testInvalidCreationMonth() {
     MonthDay.of(13, 24);
  }

  @Test(expected = DateTimeException.class)
  public void testInvalidCreationDay() {
    MonthDay.of(12, 44);
  }

  @Test
  public void testParse() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    MonthDay monthDay2 = MonthDay.parse("--12-24");
    assertEquals(monthDay1, monthDay2);
    MonthDay monthDay3 = MonthDay.parse("12.24", DateTimeFormatter.ofPattern("MM.dd"));
    assertEquals(monthDay1, monthDay3);
    MonthDay monthDay4 = MonthDay.parse("24.12.2014 10:20:30", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    assertEquals(monthDay1, monthDay4);
  }

  @Test
  public void testCreateLocalDate() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    LocalDate localDate1 = monthDay1.atYear(2014);
    assertEquals(LocalDate.of(2014, 12, 24), localDate1);
  }

  @Test
  public void testCompare() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    MonthDay monthDay2 = MonthDay.of(12, 25);
    assertTrue(monthDay1.isBefore(monthDay2));
    assertTrue(monthDay2.isAfter(monthDay1));
    assertEquals(-1, monthDay1.compareTo(monthDay2));
    assertEquals(1, monthDay2.compareTo(monthDay1));
    assertEquals(2, monthDay1.compareTo(MonthDay.of(12, 22)));
    assertEquals(0, monthDay1.compareTo(MonthDay.of(12, 24)));
  }

  @Test
  public void testQuery() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    Chronology queriedChronology = monthDay1.query(TemporalQueries.chronology());
    assertEquals(queriedChronology, IsoChronology.INSTANCE);
    LocalDate queriedLocalDate = monthDay1.query(TemporalQueries.localDate());
    assertNull(queriedLocalDate);
    LocalTime queriedLocalTime = monthDay1.query(TemporalQueries.localTime());
    assertNull(queriedLocalTime);
    ZoneId queriedZoneId = monthDay1.query(TemporalQueries.zone());
    assertNull(queriedZoneId);
    TemporalUnit queriedUnit = monthDay1.query(TemporalQueries.precision());
    assertNull(queriedUnit);
  }

  @Test
  public void testWith() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    assertEquals(MonthDay.of(Month.NOVEMBER, 24), monthDay1.withMonth(Month.NOVEMBER.getValue()));
    assertEquals(MonthDay.of(Month.OCTOBER, 24), monthDay1.with(Month.OCTOBER));
    assertEquals(MonthDay.of(Month.DECEMBER, 1), monthDay1.withDayOfMonth(1));
    assertEquals(MonthDay.of(Month.APRIL, 27), monthDay1.withDayOfMonth(27).withMonth(4));
  }

  @Test
  public void testIsValidYear() {
    MonthDay monthDay1 = MonthDay.of(12, 24);
    assertTrue(monthDay1.isValidYear(2014));
    assertTrue(monthDay1.isValidYear(2016));
    assertTrue(MonthDay.of(2, 29).isValidYear(2016));
    assertFalse(MonthDay.of(2, 29).isValidYear(2014));
  }
}
