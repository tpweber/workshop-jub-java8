package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Use of Methodreferences.
 */
public class FirstMethodReferenceExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("1234", "1234567", "123", "12345678");

    names.forEach(it -> System.out.println(it));

    names.forEach(System.out::println);
  }
}