package com.symmetric8.playground.java8.stream.terminal;

import com.symmetric8.playground.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * some calcs.
 */
public class CalculationExample {
  public static void main(final String[] args) {
    final List<Person> persons = new ArrayList<>();
    persons.add(new Person("Ten", 10));
    persons.add(new Person("Twenty", 20));
    persons.add(new Person("Thrirty", 30));
    persons.add(new Person("Forty", 40));

    final long count = persons.stream().filter(person -> person.getName().startsWith("T")).count();
    System.out.println("count: " + count);

    final int sum = persons.stream().filter(person -> person.getName().startsWith("T")).mapToInt(Person::getAge)
        .sum();
    System.out.println("sum: " + sum);

    final OptionalDouble avg = persons.stream().filter(person -> person.getName().startsWith("X"))
        .mapToInt(Person::getAge).average();
    System.out.println("avg: " + avg);
  }
}