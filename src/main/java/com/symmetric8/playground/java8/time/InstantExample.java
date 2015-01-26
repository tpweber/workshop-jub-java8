package com.symmetric8.playground.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <code>Instant</code>
 */
public class InstantExample {
  public static void main(final String[] args) {
    final Instant departureTime = Instant.now();
    final Instant expectedArrivalTime = departureTime.plus(5, ChronoUnit.HOURS);

    // delay of 15 minutes
    final Instant realArrival = expectedArrivalTime.plus(15, ChronoUnit.MINUTES);
    final Instant realArrival2 = expectedArrivalTime.plus(Duration.ofMinutes(15));
    final Instant neededArrival = realArrival2.minus(Duration.ofMinutes(6));

    System.out.println(departureTime);
    System.out.println(expectedArrivalTime);
    System.out.println(realArrival);
    System.out.println(realArrival2);
    System.out.println(neededArrival);
  }
}