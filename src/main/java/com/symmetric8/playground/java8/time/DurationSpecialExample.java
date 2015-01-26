package com.symmetric8.playground.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <code>Duration</code>
 */
public class DurationSpecialExample {
  public static void main(final String[] args) {
    final Instant christmas2015 = Instant.parse("2015-12-24T00:00:00Z");
    final Instant silvester2015 = Instant.parse("2015-12-31T00:00:00Z");
    final Instant eastern2016 = Instant.parse("2016-03-27T00:00:00Z");

    System.out.println("Christmas -> Silvester:     " +
        Duration.between(christmas2015, silvester2015));
    System.out.println("Silvester -> Eastern: " +
        Duration.between(silvester2015, eastern2016));

    final Instant calcSilvester_1 = christmas2015.plus(Duration.ofDays(7));
    final Instant calcSilvester_2 = christmas2015.plus(7, ChronoUnit.DAYS);

    System.out.println(calcSilvester_1);
    System.out.println(calcSilvester_2);
  }
}