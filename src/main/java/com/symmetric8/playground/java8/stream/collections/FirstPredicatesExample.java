package com.symmetric8.playground.java8.stream.collections;

import com.symmetric8.playground.java8.stream.Person;

import java.util.function.Predicate;

/**
 * Easy predicates.
 */
public class FirstPredicatesExample {
  public static void main(final String[] args) {
    final Predicate<String> isNull = str -> str == null;
    final Predicate<String> isEmpty = String::isEmpty;
    final Predicate<Person> isAdult = person -> person.getAge() >= 18;

    System.out.println("isNull():     " + isNull.test(""));
    System.out.println("isEmpty():    " + isEmpty.test(""));
    System.out.println("isEmpty(jambit): " + isEmpty.test("jambit"));
    System.out.println("isAdult(Jambitee):   " + isAdult.test(new Person("Jambitee", 33)));
  }
}