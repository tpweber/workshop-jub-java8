package com.symmetric8.playground.java8.stream.intermediate;

import com.symmetric8.playground.java8.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * filtering streams.
 */
public class FilterExample {
    public static void main(final String[] args) {
        final List<Person> persons = new ArrayList<>();

        persons.add(new Person("Boris", 46));
        persons.add(new Person("Barbara", 40));
        persons.add(new Person("Yannis", 5));

        final Stream<Person> adults = new ArrayList<>(persons).stream().filter(Person::isAdult);
        adults.forEach(System.out::println);
        System.out.println("");

        new ArrayList<>(persons).stream().filter(Person::isAdult).forEach(System.out::println);
    }
}