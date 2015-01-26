package com.symmetric8.playground.java8.stream.terminal;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * reduce().
 */
public class ReduceExample {
  public static void main(final String[] args) {
    final Stream<String> names = Stream.of("Mike", "Tom", "Peter", "Chris");
    final Stream<Integer> integers = Stream.of(1, 2, 3, 4, 5);
    final Stream<Integer> empty = Stream.of();

    final Optional<String> stringConcat = names.reduce((s1, s2) -> s1 + ", " + s2);
    final Optional<Integer> multiplication = integers.reduce((s1, s2) -> s1 * s2);
    final Optional<Integer> addition = empty.reduce((s1, s2) -> s1 + s2);

    System.out.println("stringConcat: " + stringConcat);
    System.out.println("multiplication: " + multiplication);
    System.out.println("addition: " + addition);
  }
}