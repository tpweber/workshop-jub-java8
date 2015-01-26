package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambdas as method references
 */
public class MethodReferenceExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("1234", "1234567", "123", "12345678");

    names.sort(stringLengthCompare());
    names.forEach(it -> System.out.print(it.length() + ", "));
    System.out.println("\n");

    names.sort(MethodReferenceExample::stringLengthCompare);
    names.forEach(it -> System.out.print(it.length() + ", "));
  }

  private static Comparator<String> stringLengthCompare() {
    return (str1, str2) -> Integer.compare(str1.length(), str2.length());
  }

  public static int stringLengthCompare(final String str1, final String str2) {
    return Integer.compare(str1.length(), str2.length());
  }
}