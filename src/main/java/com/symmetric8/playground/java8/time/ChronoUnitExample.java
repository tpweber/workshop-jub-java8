package com.symmetric8.playground.java8.time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <code>ChronoUnit</code>
 */
public class ChronoUnitExample {
  public static void main(final String[] args) {
    final Instant departureTime = Instant.now();
    System.out.println("departure now:    " + departureTime);

    final Instant arrivalTime = departureTime.plus(5, ChronoUnit.HOURS);
    System.out.println("arrival now + 5h: " + arrivalTime);

    final long inBetweenHours = ChronoUnit.HOURS.between(departureTime,
        arrivalTime);
    final long inBetweenMinutes = ChronoUnit.MINUTES.between(departureTime,
        arrivalTime);
    System.out.println("inBetweenHours:   " + inBetweenHours);
    System.out.println("inBetweenMinutes: " + inBetweenMinutes);
  }
}