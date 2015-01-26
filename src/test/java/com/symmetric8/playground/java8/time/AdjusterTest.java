package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.TemporalAdjusters.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests for adjuster from <code>java.time</code>.
 */
public class AdjusterTest {
  @Test
  public void testWithFirst() {
    LocalDateTime timePoint = LocalDateTime.parse("2015-01-06T12:24:36");
    LocalDateTime withFirstDayOfMonth = timePoint.with(firstDayOfMonth());
    assertEquals(LocalDateTime.parse("2015-01-01T12:24:36"), withFirstDayOfMonth);
    LocalDateTime withFirstDayOfNextMonth = timePoint.with(firstDayOfNextMonth());
    assertEquals(LocalDateTime.parse("2015-02-01T12:24:36"), withFirstDayOfNextMonth);
    LocalDateTime withFirstDayOfYear = timePoint.with(firstDayOfYear());
    assertEquals(LocalDateTime.parse("2015-01-01T12:24:36"), withFirstDayOfYear);
    LocalDateTime withFirstDayOfNextYear = timePoint.with(firstDayOfNextYear());
    assertEquals(LocalDateTime.parse("2016-01-01T12:24:36"), withFirstDayOfNextYear);
    LocalDateTime withDayOfWeekMonday = timePoint.with(firstInMonth(DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-05T12:24:36"), withDayOfWeekMonday);
    LocalDateTime withDayOfWeekFriday = timePoint.with(firstInMonth(DayOfWeek.FRIDAY)).withYear(2018);
    assertEquals(LocalDateTime.parse("2018-01-02T12:24:36"), withDayOfWeekFriday);
  }

  @Test
  public void testWithLast() {
    LocalDateTime timePoint1 = LocalDateTime.parse("2015-01-06T12:24:36");
    LocalDateTime withLastDayOfMonth1 = timePoint1.with(lastDayOfMonth());
    assertEquals(LocalDateTime.parse("2015-01-31T12:24:36"), withLastDayOfMonth1);
    LocalDateTime timePoint2 = LocalDateTime.parse("2016-02-06T12:24:36");
    LocalDateTime withLastDayOfMonth2 = timePoint2.with(lastDayOfMonth());
    assertEquals(LocalDateTime.parse("2016-02-29T12:24:36"), withLastDayOfMonth2);
    LocalDateTime timePoint3 = LocalDateTime.parse("2017-02-28T12:24:36");
    LocalDateTime withLastDayOfMonth3 = timePoint3.with(lastDayOfMonth());
    assertEquals(LocalDateTime.parse("2017-02-28T12:24:36"), withLastDayOfMonth3);
    LocalDateTime withLastDayOfYear = timePoint1.with(lastDayOfYear());
    assertEquals(LocalDateTime.parse("2015-12-31T12:24:36"), withLastDayOfYear);
    LocalDateTime withLastDayInMonthMonday = timePoint1.with(lastInMonth(DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-26T12:24:36"), withLastDayInMonthMonday);
    LocalDateTime withLastDayInMonthSaturday = timePoint1.with(lastInMonth(DayOfWeek.SATURDAY));
    assertEquals(LocalDateTime.parse("2015-01-31T12:24:36"), withLastDayInMonthSaturday);
  }

  @Test
  public void testWithNext() {
    LocalDateTime timePoint1 = LocalDateTime.parse("2015-01-06T12:24:36");
    LocalDateTime withNextDayOfWeekMonday = timePoint1.with(next(DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-12T12:24:36"), withNextDayOfWeekMonday);
    LocalDateTime withNextDayOfWeekFriday = timePoint1.with(next(DayOfWeek.FRIDAY));
    assertEquals(LocalDateTime.parse("2015-01-09T12:24:36"), withNextDayOfWeekFriday);
    LocalDateTime withNextDayOfWeekTuesday = timePoint1.with(next(DayOfWeek.TUESDAY));
    assertEquals(LocalDateTime.parse("2015-01-13T12:24:36"), withNextDayOfWeekTuesday);
    LocalDateTime withNextOrSameDayOfWeekTuesday = timePoint1.with(nextOrSame(DayOfWeek.TUESDAY));
    assertEquals(LocalDateTime.parse("2015-01-06T12:24:36"), withNextOrSameDayOfWeekTuesday);
    LocalDateTime withNextOrSameDayOfWeekFriday = timePoint1.with(nextOrSame(DayOfWeek.FRIDAY));
    assertEquals(withNextDayOfWeekFriday, withNextOrSameDayOfWeekFriday);
  }

  @Test
   public void testWithPrevious() {
    LocalDateTime timePoint1 = LocalDateTime.parse("2015-01-06T12:24:36");
    LocalDateTime withPreviousDayOfWeekMonday = timePoint1.with(previous(DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-05T12:24:36"), withPreviousDayOfWeekMonday);
    LocalDateTime withPreviousDayOfWeekFriday = timePoint1.with(previous(DayOfWeek.FRIDAY));
    assertEquals(LocalDateTime.parse("2015-01-02T12:24:36"), withPreviousDayOfWeekFriday);
    LocalDateTime withPreviousDayOfWeekTuesday = timePoint1.with(previous(DayOfWeek.TUESDAY));
    assertEquals(LocalDateTime.parse("2014-12-30T12:24:36"), withPreviousDayOfWeekTuesday);
    LocalDateTime withPreviousOrSameDayOfWeekTuesday = timePoint1.with(previousOrSame(DayOfWeek.TUESDAY));
    assertEquals(LocalDateTime.parse("2015-01-06T12:24:36"), withPreviousOrSameDayOfWeekTuesday);
    LocalDateTime withPreviousOrSameDayOfWeekFriday = timePoint1.with(previousOrSame(DayOfWeek.FRIDAY));
    assertEquals(withPreviousDayOfWeekFriday, withPreviousOrSameDayOfWeekFriday);
  }

  @Test
  public void testWithDayOfWeekInMonth() {
    LocalDateTime timePoint1 = LocalDateTime.parse("2015-01-06T12:24:36");
    LocalDateTime withDayOfWeekMonday0 = timePoint1.with(dayOfWeekInMonth(0, DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2014-12-29T12:24:36"), withDayOfWeekMonday0);
    LocalDateTime withDayOfWeekMonday1 = timePoint1.with(dayOfWeekInMonth(1, DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-05T12:24:36"), withDayOfWeekMonday1);
    LocalDateTime withDayOfWeekMonday5 = timePoint1.with(dayOfWeekInMonth(5, DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-02-02T12:24:36"), withDayOfWeekMonday5);
    LocalDateTime withDayOfWeekMonday10 = timePoint1.with(dayOfWeekInMonth(10, DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-03-09T12:24:36"), withDayOfWeekMonday10);
    LocalDateTime withDayOfWeekMondayMinus1 = timePoint1.with(dayOfWeekInMonth(-1, DayOfWeek.MONDAY));
    assertEquals(LocalDateTime.parse("2015-01-26T12:24:36"), withDayOfWeekMondayMinus1);
    LocalDateTime withDayOfWeekMondayMinus5 = timePoint1.with(dayOfWeekInMonth(-5, DayOfWeek.MONDAY));
    assertEquals(withDayOfWeekMonday0, withDayOfWeekMondayMinus5);
  }

  @Test
  public void testOfDateAdjuster() {
    LocalDateTime timePoint1 = LocalDateTime.parse("2015-01-06T12:24:36");
    TemporalAdjuster plusOneWeek = TemporalAdjusters.ofDateAdjuster(date -> date.plusWeeks(1));
    LocalDateTime withPlusOneWeek1 = timePoint1.with(plusOneWeek);
    assertEquals(LocalDateTime.parse("2015-01-13T12:24:36"), withPlusOneWeek1);
    TemporalAdjuster minusOneWeek = TemporalAdjusters.ofDateAdjuster(date -> date.minusWeeks(1));
    LocalDateTime withMinusOneWeek1 = timePoint1.with(minusOneWeek);
    assertEquals(LocalDateTime.parse("2014-12-30T12:24:36"), withMinusOneWeek1);
    TemporalAdjuster neutral = TemporalAdjusters.ofDateAdjuster(date -> date);
    LocalDateTime withNeutral = timePoint1.with(neutral);
    assertEquals(timePoint1, withNeutral);
  }
}
