package com.symmetric8.playground.java8.stream.intermediate;

import com.symmetric8.playground.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * extraction of attributes as an intermediate operation.
 */
public class AttributeExtractionExample {
  public static void main(final String[] args) {
    final List<Person> persons = new ArrayList<>();
    persons.add(new Person("Boris", 46));
    persons.add(new Person("Barbara", 40));
    persons.add(new Person("Yannis", 5));

    final Stream<Person> adults = persons.stream().filter(Person::isAdult);
    final Stream<String> namesStream = adults.map(person -> person.getName());

    final Stream<Integer> agesStream = persons.stream().map(Person::getAge).filter(age -> age >= 18);

    namesStream.forEach(System.out::println);
    agesStream.forEach(System.out::println);
  }
}