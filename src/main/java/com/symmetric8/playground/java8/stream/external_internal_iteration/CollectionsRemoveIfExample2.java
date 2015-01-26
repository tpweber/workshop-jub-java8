package com.symmetric8.playground.java8.stream.external_internal_iteration;

import java.util.ArrayList;
import java.util.List;

/**
 * removeIf.
 */
public class CollectionsRemoveIfExample2 {
  public static void main(final String[] args) {
    final List<String> names = createDemoNames();

    names.removeIf(str -> str.trim().isEmpty());

    System.out.println(names);
  }

  private static List<String> createDemoNames() {
    final List<String> names = new ArrayList<>();
    names.add("Max");
    names.add("");
    names.add("Andy");
    names.add("Michael");
    names.add("   ");
    names.add("Stefan");
    return names;
  }
}