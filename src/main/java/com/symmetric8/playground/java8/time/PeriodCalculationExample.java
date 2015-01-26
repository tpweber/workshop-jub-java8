package com.symmetric8.playground.java8.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * <code>Period</code>.
 */
public class PeriodCalculationExample {
  public static void main(final String[] args) {
    final LocalDateTime start = LocalDateTime.of(2015, 1, 27, 10, 11);

    final Period thirtyOneDays = Period.ofDays(31);
    System.out.println("27.1.2015 + 31 Tage: " + start.plus(thirtyOneDays));

    final Period oneMonth = Period.ofMonths(1);
    System.out.println("27.1.2015 + 1 Monat: " + start.plus(oneMonth));

    final LocalTime now = LocalTime.now();
    System.out.println("now: " + now);

    final LocalTime fiveMinutesLater = now.plus(5, ChronoUnit.MINUTES);
    System.out.println("now + 5 min: " + fiveMinutesLater);

    final LocalTime sevenHoursLater = now.plusHours(7);
    System.out.println("now + 7 hours: " + sevenHoursLater);
  }
}