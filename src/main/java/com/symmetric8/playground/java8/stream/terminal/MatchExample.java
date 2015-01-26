package com.symmetric8.playground.java8.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * matching.
 */
public class MatchExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("Thorsten", "Tom", "Micha", "Stefan");

    final Predicate<String> startWithT = str -> str.toUpperCase().startsWith("T");

    final boolean allStartWithT = names.stream().allMatch(startWithT);
    final boolean anyStartWithT = names.stream().anyMatch(startWithT);
    final boolean noneStartWithT = names.stream().noneMatch(startWithT);

    System.out.println("allStartWithT:  " + allStartWithT);
    System.out.println("anyStartWithT:  " + anyStartWithT);
    System.out.println("noneStartWithT: " + noneStartWithT);
  }
}