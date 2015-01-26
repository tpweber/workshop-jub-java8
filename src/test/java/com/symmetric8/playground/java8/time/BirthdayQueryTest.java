package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for <code>BirthdayQuery</code>.
 */
public class BirthdayQueryTest {
  @Test
  public void testCreation() {
    MonthDay monthDay1 = MonthDay.of(Month.DECEMBER, 24);
    BirthdayQuery query = new BirthdayQuery(monthDay1);
    assertEquals(monthDay1, query.getBirthday());
  }

  @Test
  public void testQuery() {
    MonthDay monthDay = MonthDay.of(Month.DECEMBER, 24);
    BirthdayQuery query = new BirthdayQuery(monthDay);
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 11, 11, 11);
    assertTrue(date1.query(query));
    assertTrue(query.queryFrom(date1));
    LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 25);
    assertFalse(date2.query(query));
    ZoneId zoneId = ZoneId.of("Europe/Berlin");
    ZonedDateTime date3 = ZonedDateTime.of(
        LocalDate.of(2014, Month.DECEMBER, 24), LocalTime.of(22, 44, 11), zoneId);
    assertTrue(date3.query(query));
  }

  @Test
  public void testQueryWithoutSupported() {
    MonthDay monthDay = MonthDay.of(Month.DECEMBER, 24);
    BirthdayQuery query = new BirthdayQuery(monthDay);
    LocalTime time1 = LocalTime.of(11, 11);
    assertFalse(time1.query(query));
    assertFalse(query.queryFrom(time1));
  }

}
