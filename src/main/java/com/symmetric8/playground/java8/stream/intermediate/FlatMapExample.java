package com.symmetric8.playground.java8.stream.intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * map() -- extraction of words.
 */
public class FlatMapExample {
  public static void main(final String[] args) throws IOException {
    final Path exampleFile = Paths.get("src/main/resources/txt/example.txt");

    final List<String> contents = Files.readAllLines(exampleFile);

    final Stream<String> words = contents.stream().flatMap(line -> Stream.of(line.split(" ")));

    final Predicate<String> isShortWord = word -> word.length() <= 3;
    final Predicate<String> notIsShortWord = isShortWord.negate();

    final List<String> ignoreableWords = Arrays.asList("this", "these", "them", "the");
    final Predicate<String> isIgnorableWord = word -> {
      return ignoreableWords.contains(word.toLowerCase());
    };
    final Predicate<String> isSignificantWord = isIgnorableWord.negate();

    final Stream<String> filteredContents = words.map(String::trim)
        .filter(notIsShortWord)
        .filter(isSignificantWord);

    filteredContents.forEach(it -> System.out.print(it + ", "));
  }
}