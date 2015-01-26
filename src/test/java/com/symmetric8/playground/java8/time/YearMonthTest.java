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
public class YearMonthTest {
  @Test
  public void testCreation() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    YearMonth yearMonth2 = YearMonth.of(2014, Month.DECEMBER);
    assertEquals(2014, yearMonth1.getYear());
    assertEquals(12, yearMonth1.getMonthValue());
    assertEquals(yearMonth1, yearMonth2);
    YearMonth yearMonth3 = YearMonth.from(LocalDate.of(2014, 12, 31));
    assertEquals(yearMonth1, yearMonth3);
  }

  @Test
  public void testParse() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    YearMonth yearMonth2 = YearMonth.parse("2014-12");
    assertEquals(yearMonth1, yearMonth2);
    YearMonth yearMonth3 = YearMonth.parse("12.2014", DateTimeFormatter.ofPattern("MM.yyyy"));
    assertEquals(yearMonth1, yearMonth3);
    YearMonth yearMonth4 = YearMonth.parse("24.12.2014 10:20:30", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    assertEquals(yearMonth1, yearMonth4);
  }

  @Test
  public void testLengthOfMonthOrYear() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    assertEquals(31, yearMonth1.lengthOfMonth());
    assertEquals(365, yearMonth1.lengthOfYear());
    YearMonth yearMonth2 = YearMonth.of(2016, 2);
    assertEquals(29, yearMonth2.lengthOfMonth());
    assertEquals(366, yearMonth2.lengthOfYear());
  }

  @Test
  public void testCreateLocalDate() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    LocalDate localDate1 = yearMonth1.atDay(24);
    assertEquals(LocalDate.of(2014, 12, 24), localDate1);
    LocalDate localDate2 = yearMonth1.atEndOfMonth();
    assertEquals(LocalDate.of(2014, 12, 31), localDate2);
  }

  @Test
  public void testCompare() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    YearMonth yearMonth2 = YearMonth.of(2015, 1);
    assertTrue(yearMonth1.isBefore(yearMonth2));
    assertTrue(yearMonth2.isAfter(yearMonth1));
    assertEquals(-1, yearMonth1.compareTo(yearMonth2));
    assertEquals(1, yearMonth2.compareTo(yearMonth1));
    assertEquals(2, yearMonth1.compareTo(YearMonth.of(2012, 11)));
    assertEquals(0, yearMonth1.compareTo(YearMonth.of(2014, 12)));
  }

  @Test
  public void testQuery() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    Chronology queriedChronology = yearMonth1.query(TemporalQueries.chronology());
    assertEquals(queriedChronology, IsoChronology.INSTANCE);
    LocalDate queriedLocalDate = yearMonth1.query(TemporalQueries.localDate());
    assertNull(queriedLocalDate);
    LocalTime queriedLocalTime = yearMonth1.query(TemporalQueries.localTime());
    assertNull(queriedLocalTime);
    ZoneId queriedZoneId = yearMonth1.query(TemporalQueries.zone());
    assertNull(queriedZoneId);
    TemporalUnit queriedUnit = yearMonth1.query(TemporalQueries.precision());
    assertEquals(ChronoUnit.MONTHS, queriedUnit);
  }

  @Test
  public void testCalculations() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    assertEquals(YearMonth.of(2015, 1), yearMonth1.plusMonths(1));
    assertEquals(YearMonth.of(2013, 12), yearMonth1.minusYears(1));
    assertEquals(YearMonth.of(2013, 10), yearMonth1.minusYears(1).minusMonths(2));
    assertEquals(YearMonth.of(2015, 2), yearMonth1.plusMonths(4).minusMonths(3).plusMonths(1));
    assertEquals(YearMonth.of(2015, 1), yearMonth1.plus(1, ChronoUnit.MONTHS));
  }

  @Test(expected = UnsupportedTemporalTypeException.class)
  public void testInvalidCalculations() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    assertEquals(YearMonth.of(2015, 1), yearMonth1.plus(31, ChronoUnit.DAYS));
  }

  @Test
  public void testWith() {
    YearMonth yearMonth1 = YearMonth.of(2014, 12);
    assertEquals(YearMonth.of(2014, Month.NOVEMBER), yearMonth1.withMonth(Month.NOVEMBER.getValue()));
    assertEquals(YearMonth.of(2016, Month.DECEMBER), yearMonth1.withYear(2016));
    assertEquals(YearMonth.of(2016, Month.FEBRUARY), yearMonth1.withYear(2016).with(ChronoField.MONTH_OF_YEAR, 2L));
  }
}
