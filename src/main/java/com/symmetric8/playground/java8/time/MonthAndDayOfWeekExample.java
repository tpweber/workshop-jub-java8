package com.symmetric8.playground.java8.time;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * <code>Month</code> and <code>DayOfWeek</code>.
 */
public class MonthAndDayOfWeekExample {
  public static void main(final String[] args) {
    final DayOfWeek sunday = DayOfWeek.SUNDAY;
    final Month february = Month.FEBRUARY;

    System.out.println(sunday.plus(5));
    System.out.println(february.plus(10));
  }
}