package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Lambdas and method references
 */
public class MethodReferenceExample2 {
  public static void main(final String[] args) {
    final List<Integer> iNames = Arrays.asList(1234, 1234567, 123, 12345678, 12, 12345, 123456);

    List<String> names = convertList(iNames, i -> Integer.toString(i));

    names.sort(MethodReferenceExample::stringLengthCompare);

    names.forEach(MethodReferenceExample2::commaSeparatedPrint);
  }

  public static Consumer<String> commaSeparatedPrint() {
    return it -> {
      System.out.print(it.length() + ", ");
    };
  }

  public static void commaSeparatedPrint(final String str) {
    System.out.print(str.length() + ", ");
  }

  public static <T, U> List<U> convertList(final List<T> from, final Function<T, U> func) {
    return from.stream().map(func).collect(Collectors.toList());
  }
}