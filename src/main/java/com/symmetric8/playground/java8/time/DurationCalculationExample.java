package com.symmetric8.playground.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <code>Duration</code>.
 */
public class DurationCalculationExample {
  public static void main(final String[] args) {
    final Instant christmas2014 = Instant.parse("2014-12-24T00:00:00Z");
    final Instant silvester2014 = Instant.parse("2014-12-31T00:00:00Z");
    final Instant jdk8Release = Instant.parse("2014-03-18T00:00:00Z");

    System.out.println(Duration.between(christmas2014, silvester2014));
    System.out.println(Duration.between(silvester2014, jdk8Release));

    final Instant calcSilvester_1 = christmas2014.plus(Duration.ofDays(7));
    final Instant calcSilvester_2 = christmas2014.plus(7, ChronoUnit.DAYS);

    System.out.println(calcSilvester_1);
    System.out.println(calcSilvester_2);

    // Duration ofWeeks(long) oder ofMonths(long) -> throws java.time.temporal.UnsupportedTemporalTypeException
    final Instant calcSilvester_3 = silvester2014.plus(1, ChronoUnit.WEEKS);
    System.out.println(calcSilvester_3);

    final Instant calcJdk8Release = silvester2014.plus(3, ChronoUnit.MONTHS).plus(Duration.ofDays(18));
    System.out.println(calcJdk8Release);
  }
}