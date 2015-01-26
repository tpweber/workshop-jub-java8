package com.symmetric8.playground.java8.stream.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * flatMap()
 */
public class FlatMapAndGroupingExample {
  public static void main(final String[] args) throws IOException {
    final Path exampleFile = Paths.get("src/main/resources/txt/example.txt");

    final List<String> contents = Files.readAllLines(exampleFile);

    final Stream<String> words = contents.stream().flatMap(line -> Stream.of(line.split(" ")));

    final Predicate<String> isShortWord = word -> word.length() <= 3;
    final Predicate<String> notIsShortWord = isShortWord.negate();

    final List<String> ignoreableWords = Arrays.asList("this", "these", "them");
    final Predicate<String> isIgnorableWord = word -> {
      return ignoreableWords.contains(word.toLowerCase());
    };
    final Predicate<String> isSignificantWord = isIgnorableWord.negate();

    final Stream<String> filteredContents = words.map(String::trim).filter(notIsShortWord)
        .filter(isSignificantWord);

    final Function<String, String> removePunctationMarks = str -> {
      if (str.endsWith(".") || str.endsWith(":") || str.endsWith("!")) {
        return str.substring(0, str.length() - 1);
      }
      return str;
    };

    final Stream<String> mapped = filteredContents.map(removePunctationMarks);

    Function<String, String> classifier = Function.identity(); // str -> str;
    Map<String, Long> grouped = mapped.collect(groupingBy(classifier, counting()));

    Map<String, Long> sorted = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    sorted.putAll(grouped);

    System.out.println(sorted);
  }
}