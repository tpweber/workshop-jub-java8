package com.symmetric8.playground.java8.stream.external_internal_iteration;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * internal iterations.
 */
public class InternalIterationExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("Andi", "Mike", "Ralph", "Stefan");

    names.forEach((String name) -> {
      System.out.println(name);
    });
    names.forEach(name -> System.out.println(name));
    names.forEach(System.out::println);
    Consumer<String> action = name -> System.out.println(name);
    names.forEach(action);
  }
}