package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

/**
 * Tests
 */
public class PeriodAndDurationTest {
  @Test
  public void testDuration() {
    Instant instant1 = Instant.parse("2014-12-24T10:20:30.00Z");
    Instant instant2 = Instant.parse("2014-12-24T10:20:40.00Z");
    assertEquals(Duration.ofSeconds(0L), Duration.between(instant1, instant1));
    assertEquals(Duration.ofSeconds(10L), Duration.between(instant1, instant2));
    assertEquals(Duration.ofSeconds(-10L), Duration.between(instant2, instant1));
    Instant instant3 = Instant.parse("2014-12-25T11:21:31.01Z");
    assertEquals(Duration.ofDays(1).plusHours(1).plusMinutes(1).plusSeconds(1).plusMillis(10L), Duration.between(instant1, instant3));
    assertEquals(90061010L, Duration.between(instant1, instant3).toMillis());
  }

  @Test
  public void testPeriod() {
    LocalDateTime date1 = LocalDateTime.parse("2014-12-24T10:20:30");
    LocalDateTime date2 = LocalDateTime.parse("2014-12-25T10:20:40");
    assertEquals(Period.ofDays(0), Period.between(date1.toLocalDate(), date1.toLocalDate()));
    assertEquals(Period.ofDays(1), Period.between(date1.toLocalDate(), date2.toLocalDate()));
    LocalDateTime date3 = LocalDateTime.parse("2015-11-25T11:21:31");
    assertEquals(Period.ofMonths(11).plusDays(1), Period.between(date1.toLocalDate(), date3.toLocalDate()));
    LocalDateTime date4 = LocalDateTime.parse("2016-12-25T11:21:31");
    assertEquals(Period.ofMonths(24).plusDays(1).normalized(), Period.between(date1.toLocalDate(), date4.toLocalDate()));
    assertEquals(Period.ofMonths(24).plusDays(1).toTotalMonths(), Period.between(date1.toLocalDate(), date4.toLocalDate()).toTotalMonths());
  }

  @Test
  public void testChronoUnit() {
    LocalDateTime date1 = LocalDateTime.parse("2014-12-24T10:20:30");
    LocalDateTime date2 = LocalDateTime.parse("2014-12-25T10:20:40");
    assertEquals(0L, ChronoUnit.DAYS.between(date1.toLocalDate(), date1.toLocalDate()));
    assertEquals(1L, ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate()));
    LocalDateTime date3 = LocalDateTime.parse("2015-11-25T11:21:31");
    assertEquals(336L, ChronoUnit.DAYS.between(date1.toLocalDate(), date3.toLocalDate()));
    assertEquals(11L, ChronoUnit.MONTHS.between(date1.toLocalDate(), date3.toLocalDate()));
    LocalDateTime date4 = LocalDateTime.parse("2016-12-25T11:21:31");
    assertEquals(732L, ChronoUnit.DAYS.between(date1.toLocalDate(), date4.toLocalDate()));
  }
}
