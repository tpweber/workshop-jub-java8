package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Test for <code>PaymentDateAdjuster</code>.
 */
public class PaymentDateAdjusterTest {
  @Test
  public void testLocalDateTimeOnFriday() {
    LocalDateTime dateOnFriday = LocalDateTime.of(2015, Month.JANUARY, 2, 22, 44, 11);
    assertEquals(DayOfWeek.FRIDAY, dateOnFriday.getDayOfWeek());
    LocalDateTime calculatedPaymentDate = dateOnFriday.with(new PaymentDateAdjuster());
    assertNotNull(calculatedPaymentDate);
    assertEquals(DayOfWeek.FRIDAY, calculatedPaymentDate.getDayOfWeek());
    assertEquals(LocalDateTime.of(2015, Month.JANUARY, 16, 22, 44, 11), calculatedPaymentDate);
  }

  @Test
  public void testZonedDateTimeOnSaturday() {
    ZoneId zoneId = ZoneId.of("Europe/Berlin");
    ZonedDateTime dateOnSaturday = ZonedDateTime.of(
        LocalDate.of(2015, Month.JANUARY, 3), LocalTime.of(22, 44, 11), zoneId);
    assertEquals(DayOfWeek.SATURDAY, dateOnSaturday.getDayOfWeek());
    ZonedDateTime calculatedPaymentDate = dateOnSaturday.with(new PaymentDateAdjuster());
    assertNotNull(calculatedPaymentDate);
    assertEquals(DayOfWeek.MONDAY, calculatedPaymentDate.getDayOfWeek());
    ZonedDateTime expected = ZonedDateTime.of(
        LocalDate.of(2015, Month.JANUARY, 19), LocalTime.of(22, 44, 11), zoneId);
    assertEquals(expected, calculatedPaymentDate);
  }

  @Test
  public void testLocalDateOnMonday() {
    LocalDate dateOnMonday = LocalDate.of(2015, Month.JANUARY, 5);
    assertEquals(DayOfWeek.MONDAY, dateOnMonday.getDayOfWeek());
    LocalDate calculatedPaymentDate = dateOnMonday.with(new PaymentDateAdjuster());
    assertNotNull(calculatedPaymentDate);
    assertEquals(DayOfWeek.MONDAY, calculatedPaymentDate.getDayOfWeek());
    assertEquals(LocalDate.of(2015, Month.JANUARY, 19), calculatedPaymentDate);
  }
}
