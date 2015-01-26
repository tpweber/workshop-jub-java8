package com.symmetric8.playground.java8.stream.terminal;

import java.util.Arrays;
import java.util.List;

/**
 * forEach and parallel
 */
public class WrongParallelForEachExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("Stefan", "Ralph", "Andi", "Mike");

    names.parallelStream().sorted().forEach(System.out::print);
    System.out.println("");
    names.stream().sorted().forEach(System.out::print);
  }
}