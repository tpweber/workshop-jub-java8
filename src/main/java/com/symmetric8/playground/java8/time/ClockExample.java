package com.symmetric8.playground.java8.time;

import java.time.Clock;

/**
 * <code>Clock</code>.
 */
public class ClockExample {
  public static void main(final String[] args) {
    final Clock clock = Clock.systemUTC();
    System.out.println(clock);
    printClockMillis(clock);

    final Clock clock2 = Clock.systemDefaultZone();
    System.out.println(clock2);
    printClockMillis(clock2);
  }

  private static void printClockMillis(final Clock clock) {
    final long currentTime = clock.millis();
    System.out.println(currentTime);
  }
}