package com.symmetric8.playground.java8.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.*;

/**
 * collectors
 */
public class CollectorsSpecialExample {
  public static void main(final String[] args) {
    final List<String> names = Arrays.asList("Stefan", "Ralph", "Andi", "Mike", "Florian", "Michael", "Sebastian");

    final String joined = names.stream().sorted().collect(joining(", "));

    final Map<Integer, List<String>> grouped = names.stream().collect(groupingBy(String::length));
    final Map<Integer, Long> counting = names.stream().collect(groupingBy(String::length, counting()));

    final Map<Boolean, List<String>> partition = names.stream().filter(str -> str.contains("i"))
        .collect(partitioningBy(str -> str.length() > 4));

    System.out.println(joined);
    System.out.println(grouped);
    System.out.println(counting);
    System.out.println(partition);

    final double[] dValues = {};
    final OptionalDouble average = Arrays.stream(dValues).average();
    System.out.println(average);

    final int[] iValues = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(Arrays.stream(iValues).average());
    System.out.println(Arrays.stream(iValues).min());
    System.out.println(Arrays.stream(iValues).max());
  }
}
