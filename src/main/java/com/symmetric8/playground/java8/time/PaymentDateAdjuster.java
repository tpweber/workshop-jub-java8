package com.symmetric8.playground.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.TemporalAdjusters.next;

/**
 * This temporal adjuster calculates the payment date.
 * The payment is due after 2 weeks.If this calculated date is
 * on a weekend, then the next monday is used.
 */
public class PaymentDateAdjuster implements TemporalAdjuster {
  @Override
  public Temporal adjustInto(final Temporal pTemporal) {
    final LocalDate tDate = calcValidPaymentDate(pTemporal);
    return pTemporal.with(tDate);
  }

  private LocalDate calcValidPaymentDate(final Temporal pTemporal) {
    final LocalDate tDate = LocalDate.from(pTemporal).plusWeeks(2);
    return (isOnWeekend(tDate)) ? tDate.with(next(DayOfWeek.MONDAY)) : tDate;
  }

  private boolean isOnWeekend(final LocalDate date) {
    final DayOfWeek dayOfWeek = date.getDayOfWeek();
    return DayOfWeek.SATURDAY.equals(dayOfWeek) || DayOfWeek.SUNDAY.equals(dayOfWeek);
  }
}
