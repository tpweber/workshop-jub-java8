package com.symmetric8.playground.java8.stream.terminal;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * convert streams in arrays.
 */
public class StreamToArrayExample {
  public static void main(final String[] args) {
    final SplittableRandom random = new SplittableRandom();
    final Supplier<Double> randomSupplier = () -> random.nextDouble() * 100;

    final Object[] randomNumbers = Stream.generate(randomSupplier).limit(8).toArray();
    System.out.println(Arrays.toString(randomNumbers));
    System.out.println("Element type: " + randomNumbers[0].getClass());

    final long[] longRandoms = Stream.generate(randomSupplier).limit(8).mapToLong(Double::longValue).toArray();
    System.out.println(Arrays.toString(longRandoms));

    final long[] longRandoms2 = random.longs().parallel().limit(8).toArray();
    System.out.println(Arrays.toString(longRandoms2));
  }
}