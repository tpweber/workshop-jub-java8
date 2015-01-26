package com.symmetric8.playground.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * <code>Optional</code>.
 */
public class FirstOptionalExample {
  public static void main(final String[] args) {
    final OptionalInt optionalFromValue = OptionalInt.of(4711);
    final Optional<String> optionalFromNullableValue = Optional.ofNullable("4712");
    final Optional<Double> optionalFromNull = Optional.ofNullable(null);
    final Optional<Double> optionalEmpty = Optional.empty();
    printOptional(optionalFromValue, "from value");
    printOptional(optionalFromNullableValue, "from nullable value");
    printOptional(optionalFromNull, "from null");
    printOptional(optionalEmpty, "from empty");
    System.out.println("from value: " + optionalFromValue + " - get: " + optionalFromValue.getAsInt());
    System.out.println("from nullable value: " + optionalFromNullableValue + " - get: " + optionalFromNullableValue.get());
    try {
      optionalEmpty.get();
    } catch (NoSuchElementException nsee) {
      System.out.println("get() from empty throws NoSuchElementException -> " + nsee.getLocalizedMessage());
    }
  }

  private static void printOptional(final Optional optional, final String prefix) {
    System.out.println(prefix + ": " + optional + " - isPresent: " + optional.isPresent());
  }

  private static void printOptional(final OptionalInt optional, final String prefix) {
    System.out.println(prefix + ": " + optional + " - isPresent: " + optional.isPresent());
  }
}