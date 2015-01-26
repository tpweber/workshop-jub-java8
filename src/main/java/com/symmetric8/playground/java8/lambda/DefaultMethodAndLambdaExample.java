package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Defaultmethods sort() and forEach()
 */
public class DefaultMethodAndLambdaExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("1234", "1234567", "123", "12345678", "12");

    names.sort((str1, str2) -> Integer.compare(str1.length(), str2.length()));
    names.forEach(it -> {
      System.out.print(it.length() + ", ");
    });
    System.out.println(".");

    final Comparator<String> comparator = (str1, str2) -> Integer.compare(str1.length(), str2.length());
    names.sort(comparator.reversed());
    final Consumer<String> printer = it -> System.out.print(it.length() + "; ");
    names.forEach(printer);
    System.out.println(".");
    names.sort(Comparator.naturalOrder());
    names.forEach(printer);
  }
}