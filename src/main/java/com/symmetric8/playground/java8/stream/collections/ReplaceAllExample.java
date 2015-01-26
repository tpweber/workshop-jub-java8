package com.symmetric8.playground.java8.stream.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * List.replaceAll()
 */
public class ReplaceAllExample {
  public static void main(final String[] args) {
    final List<String> names = createDemoNames();

    final UnaryOperator<String> mapNullToEmpty = str -> str == null ? "" : str;
    names.replaceAll(mapNullToEmpty);

    names.replaceAll(String::trim);

    names.removeIf(String::isEmpty);

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