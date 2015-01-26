package com.symmetric8.playground.java8.time;

import java.util.Calendar;
import java.util.Date;

/**
 * <code>Date</code> was difficult to construct.
 */
public class DateConstructionProblemsExample {
  public static void main(final String[] args) {
    final int year = 2015;
    final int month = 0; // january is defined as 0, not as 1.
    final int day = 27;

    System.out.println(new Date(year, month, day));
    System.out.println(new Date(year - 1900, month - 1, day));

    Calendar cal1 = Calendar.getInstance();
    cal1.set(year, month, day);
    Date dateByCal = cal1.getTime();
    System.out.println(dateByCal); // with time part
    cal1.set(year, month, day, 0, 0, 0);
    Date dateByCal2 = cal1.getTime();
    System.out.println(dateByCal2);
    Calendar cal2 = Calendar.getInstance();
    cal2.set(year, month, day, 0, 0, 0);
    Date dateByCal3 = cal2.getTime();
    System.out.println(dateByCal3);
    System.out.println("Equals? : " + dateByCal2.equals(dateByCal3));
    cal1.set(year, month, day, 0, 0, 0);
    cal1.set(Calendar.MILLISECOND, 0);
    dateByCal2 = cal1.getTime();
    cal2.set(year, month, day, 0, 0, 0);
    cal2.set(Calendar.MILLISECOND, 0);
    dateByCal3 = cal2.getTime();
    System.out.println("Equals? : " + dateByCal2.equals(dateByCal3));
  }
}