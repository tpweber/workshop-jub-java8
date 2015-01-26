package com.symmetric8.playground.java8.time;

import java.time.*;

/**
 * <code>Year</code> and <code>YearMonth </code>.
 */
public class YearAndMoreExample {
  public static void main(final String[] args) {
    final YearMonth yearMonth = YearMonth.of(2015, 2);
    final YearMonth february2015 = YearMonth.of(2015, Month.FEBRUARY);

    final int dayOfBirthday = 27;
    final MonthDay monthDay1 = MonthDay.of(4, dayOfBirthday);
    final MonthDay monthDay2 = MonthDay.of(Month.APRIL, dayOfBirthday);
    final LocalDate date = LocalDate.of(2015, Month.APRIL, dayOfBirthday);
    final MonthDay monthDay3 = MonthDay.from(date);

    // Year
    final Year year2015 = Year.of(2015);
    final Year year2016 = Year.of(2016);

    System.out.println("YearMonth: " + february2015);
    System.out.println("yearMonth equals february2015?: " + yearMonth.equals(february2015));
    System.out.println("MonthDay:  " + monthDay2);
    System.out.println("monthDay1 equals monthDay2 equals monthDay3 ?: " + monthDay1.equals(monthDay2) + ":" + monthDay2.equals(monthDay3));
    System.out.println("Year 2015: " + year2015 + " - isLeap? " + year2015.isLeap());
    System.out.println("Year 2016: " + year2016 + " - isLeap? " + year2016.isLeap());
  }
}