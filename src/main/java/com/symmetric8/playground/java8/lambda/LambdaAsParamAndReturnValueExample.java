package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambdas as parameter and as return value.
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2014 by Michael Inden
 */
public class LambdaAsParamAndReturnValueExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("1234", "1234567", "123", "12345678");

    Collections.sort(names, (str1, str2) -> Integer.compare(str1.length(), str2.length()));

    names.sort(compareByLength());
  }

  public static Comparator<String> compareByLength() {
    return (str1, str2) -> Integer.compare(str1.length(), str2.length());
  }
}