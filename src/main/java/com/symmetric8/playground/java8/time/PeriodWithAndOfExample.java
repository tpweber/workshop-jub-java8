package com.symmetric8.playground.java8.time;

import java.time.Period;

/**
 * <code>Period</code>.
 */
public class PeriodWithAndOfExample {
  public static void main(final String[] args) {
    final Period oneYear_sixMonths_ThreeDays = Period.ofYears(1).withMonths(6).
        withDays(3);

    final Period twoMonths_OneWeek_ThreeDays = Period.ofMonths(2).ofWeeks(1).
        ofDays(3);

    final Period twoMonths_TenDays = Period.ofMonths(2).withDays(10);
    final Period sevenWeeks = Period.ofWeeks(7);
    final Period threeDays = Period.ofDays(3);

    System.out.println("1 year 6 months, 3 days:  " + oneYear_sixMonths_ThreeDays);
    System.out.println("Surprise just 3 days: " + twoMonths_OneWeek_ThreeDays);
    System.out.println("2 months 10 days: " + twoMonths_TenDays);
    System.out.println("sevenWeeks: " + sevenWeeks);
    System.out.println("threeDays: " + threeDays);
  }
}          