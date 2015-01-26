package com.symmetric8.playground.java8.stream.create;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream .
 */
public class PrimitivesStreamExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("123", "4567", "8910", "111213");
    final Stream<String> values = names.stream().
        mapToInt(String::length).
        mapToDouble(x -> x * .75).
        mapToObj(val -> "Wert: " + val);
    values.forEach(System.out::println);
  }
}