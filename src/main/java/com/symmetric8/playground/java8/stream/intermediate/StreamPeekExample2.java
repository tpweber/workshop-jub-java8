package com.symmetric8.playground.java8.stream.intermediate;

import com.symmetric8.playground.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * peek().
 */
public class StreamPeekExample2 {
  public static void main(final String[] args) {
    final List<Person> persons = createDemoData();

    System.out.println("Protokollierung jedes einzelnen Schritts");
    final Stream<Person> stream = new ArrayList<>(persons).stream();

    final Stream<String> allMikesPeeked = stream.peek(System.out::println).filter(Person::isAdult)
        .peek(System.out::println).map(Person::getName).peek(System.out::println)
        .filter(name -> name.startsWith("Mi")).peek(System.out::println).map(String::toUpperCase);

    System.out.println("Peeked Filter for 'Mi':");
    allMikesPeeked.forEach(System.out::println);

    final Stream<Person> stream2 = new ArrayList<>(persons).stream();
    final Stream<String> allMikes = stream2.filter(Person::isAdult)
            .map(Person::getName).filter(name -> name.startsWith("Mi")).map(String::toUpperCase);

    System.out.println("Filter for 'Mi':");
    allMikes.forEach(System.out::println);
  }

  private static List<Person> createDemoData() {
    final List<Person> persons = new ArrayList<>();
    persons.add(new Person("Michael", 43));
    persons.add(new Person("Max", 5));
    persons.add(new Person("Merten", 38));
    persons.add(new Person("Moritz", 7));
    persons.add(new Person("Micha", 42));
    return persons;
  }
}
