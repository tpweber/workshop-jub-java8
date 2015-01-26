package com.symmetric8.playground.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * <code>LocalDate</code>, <code>LocalTime</code> and <code>LocalDateTime</code>.
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2014 by Michael Inden
 */
public class LocalDateAndTimeExample {
  public static void main(final String[] args) {
    final LocalDate birthday1 = LocalDate.of(1968, Month.APRIL, 27);
    final LocalDate birthday2 = birthday1.plusDays(1).
        plusMonths(9).plusYears(4);
    final LocalDate lastDayInFebruary = birthday1.with(TemporalAdjusters.
        lastDayOfMonth());

    System.out.println("birthday1: " + birthday1);
    System.out.println("birthday2: " + birthday2);
    System.out.println("lastDayInFebruary: " + lastDayInFebruary);
    System.out.println("Age in :" + Period.between(birthday1, LocalDate.now()));

    final LocalTime atNine = LocalTime.of(9, 00, 00);
    final LocalTime nineFifteen = atNine.plusMinutes(15);
    final LocalTime breakfastTime = nineFifteen.minusHours(2);

    System.out.println("atTen: " + atNine);
    System.out.println("tenFifteen: " + nineFifteen);
    System.out.println("breakfastTime: " + breakfastTime);
    System.out.println("duration of course  " + Duration.between(atNine, LocalTime.now()));

    final LocalDate ldBirthday3 = LocalDate.parse("27.04.1968", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    LocalTime ltBirthday3 = LocalTime.of(11, 00, 00);
    final LocalDateTime birthday3 = LocalDateTime.of(ldBirthday3, ltBirthday3);
    System.out.println("birthday3: " + birthday3);
    System.out.printf("birthday3:  %s.%s.%s\n", birthday3.getDayOfMonth(),
        birthday3.getMonthValue(),
        birthday3.getYear());

    System.out.println("Age in years:" + Period.between(birthday1, LocalDate.now()).getYears());
    System.out.println("Age in months:" + ChronoUnit.MONTHS.between(birthday3, LocalDateTime.now()));
    System.out.println("Age in weeks:" + ChronoUnit.WEEKS.between(birthday3, LocalDateTime.now()));
    System.out.println("Age in days:" + ChronoUnit.DAYS.between(birthday3, LocalDateTime.now()));
    System.out.println("Age in hours:" + Duration.between(birthday3, LocalDateTime.now()).toHours());
    System.out.println("Age in minutes:" + Duration.between(birthday3, LocalDateTime.now()).toMinutes());
    System.out.println("Age in seconds:" + Duration.between(birthday3, LocalDateTime.now()).getSeconds());
  }
}