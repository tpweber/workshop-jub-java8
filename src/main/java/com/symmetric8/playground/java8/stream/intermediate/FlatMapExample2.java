package com.symmetric8.playground.java8.stream.intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * map() -- extraction of words.
 */
public class FlatMapExample2 {
  public static void main(final String[] args) throws IOException {
    final Path exampleFile = Paths.get("src/main/resources/txt/example.txt");

    final List<String> contents = Files.readAllLines(exampleFile);

    final Function<String, Stream<? extends String>> splitter = line -> Stream.of(line.split(" "));
    final Stream<String> words = contents.stream().flatMap(splitter);

    final List<String> ignoreableWords = Arrays.asList("this", "these", "those", "the");
    final Predicate<String> isIgnorableWord = word -> ignoreableWords.contains(word.trim().toLowerCase());

    final Predicate<String> isSignificantWord = isIgnorableWord.negate();

    final Predicate<String> isShortWord = word -> word.length() <= 3;
    final Predicate<String> notIsShortWord = isShortWord.negate();

    final Stream<String> filteredContents = words.filter(notIsShortWord).filter(isSignificantWord);

    filteredContents.forEach(it -> System.out.print(it + ", "));

    final Function<String, String> removeSatzzeichen = str -> {
      if (str.endsWith(".") || str.endsWith(":") || str.endsWith("!")) {
        return str.substring(0, str.length() - 1);
      } else {
        return str;
      }
    };

    final Stream<String> mapped = filteredContents.map(removeSatzzeichen);
    final Stream<String> sorted = mapped.distinct().sorted(Collator.getInstance(Locale.GERMAN));

    sorted.forEach(it -> System.out.print(it + ", "));
  }
}