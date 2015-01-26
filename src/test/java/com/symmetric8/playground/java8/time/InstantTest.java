package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for <code>java.time.Instant</code>.
 */
public class InstantTest {
  @Test
  public void testCreation() {
    Instant instant1 = Instant.EPOCH;
    assertEquals(instant1, Instant.ofEpochMilli(0L));
    assertEquals(instant1, Instant.ofEpochSecond(0L));
    assertEquals(instant1, Instant.ofEpochSecond(0L, 0L));
    LocalDateTime date1 = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0, 0, 0);
    LocalDateTime date2 = LocalDateTime.ofInstant(instant1, ZoneId.of("UTC"));
    assertEquals(date1, date2);
    final Clock fixedClock = Clock.fixed(instant1, ZoneId.systemDefault());
    Instant instant2 = Instant.now(fixedClock);
    LocalDateTime date3 = LocalDateTime.now(fixedClock);
    assertEquals(date3, LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()));
  }

  @Test
  public void testParse() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 10, 20, 30, 0);
    LocalDateTime date2 = LocalDateTime.ofInstant(instant1, ZoneId.of("UTC"));
    assertEquals(date1, date2);
  }

  @Test
  public void testCalc() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    Instant instantPlus10s = instant1.plusSeconds(10);
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 10, 20, 40, 0);
    LocalDateTime date2 = LocalDateTime.ofInstant(instantPlus10s, ZoneId.of("UTC"));
    assertEquals(date1, date2);
    Instant instantPlus1d30s = instant1.plus(1, ChronoUnit.DAYS).plusSeconds(30);
    assertEquals(instantPlus1d30s, Instant.parse("2014-12-25T10:21:00.00Z"));
    Instant instantMinus2d20m30s = instant1.minus(2, ChronoUnit.DAYS).minus(20, ChronoUnit.MINUTES).minusSeconds(30);
    assertEquals(instantMinus2d20m30s, Instant.parse("2014-12-22T10:00:00.00Z"));
  }

  @Test
  public void testUntil() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    assertEquals(30, instant1.until(Instant.parse("2014-12-24T10:21:00.00Z"), ChronoUnit.SECONDS));
    assertEquals(30000, instant1.until(Instant.parse("2014-12-24T10:21:00.00Z"), ChronoUnit.MILLIS));
    assertEquals(30000000000L, instant1.until(Instant.parse("2014-12-24T10:21:00.00Z"), ChronoUnit.NANOS));
    assertEquals(-30, instant1.until(Instant.parse("2014-12-24T10:20:00.00Z"), ChronoUnit.SECONDS));
    assertEquals(0, instant1.until(Instant.parse("2014-12-24T10:21:29.00Z"), ChronoUnit.MINUTES));
    assertEquals(59, instant1.until(Instant.parse("2014-12-24T10:21:29.00Z"), ChronoUnit.SECONDS));
    assertEquals(1, instant1.until(Instant.parse("2014-12-24T10:21:31.00Z"), ChronoUnit.MINUTES));
    assertEquals(61, instant1.until(Instant.parse("2014-12-24T10:21:31.00Z"), ChronoUnit.SECONDS));
  }

  @Test
  public void testQuery() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    assertNull(instant1.query(TemporalQueries.chronology()));
    assertNull(instant1.query(TemporalQueries.localDate()));
    assertNull(instant1.query(TemporalQueries.localTime()));
    assertNull(instant1.query(TemporalQueries.zone()));
    TemporalUnit queriedUnit = instant1.query(TemporalQueries.precision());
    assertEquals(queriedUnit, ChronoUnit.NANOS);
  }

  @Test
  public void testComparison() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    Instant instant2 = Instant.parse("2014-12-25T10:20:30.00Z");
    assertTrue(instant1.isBefore(instant2));
    assertTrue(instant2.isAfter(instant1));
    assertTrue(instant2.isBefore(Instant.ofEpochSecond(instant2.getEpochSecond() + 1)));
    assertTrue(instant2.isBefore(instant2.plusSeconds(1)));
    assertTrue(instant2.isAfter(instant2.minusSeconds(1)));
  }
}
