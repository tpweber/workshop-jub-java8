package com.symmetric8.playground.java8.stream.external_internal_iteration;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * external iterations
 */
public class ExternalIterationExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("Andi", "Mike", "Ralph", "Stefan");

    final Iterator<String> it = names.iterator();
    while (it.hasNext()) {
      final String name = it.next();
      System.out.println(name);
    }

    for (int i = 0; i < names.size(); i++) {
      System.out.println(names.get(i));
    }

    for (final String name : names) {
      System.out.println(name);
    }
  }
}