package com.symmetric8.playground.java8.stream.collections;

import com.symmetric8.playground.java8.stream.Person;
import com.symmetric8.playground.java8.stream.Sex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * complex predicates.
 */
public class ComplexPredicatesExample {
  public static void main(final String[] args) {
    final List<Person> persons = createDemoData();

    final Predicate<Person> isAdult = person -> person.getAge() >= 18;
    final Predicate<Person> isMale = person -> person.getGender() == Sex.MALE;

    final Predicate<Person> isYoung = isAdult.negate();
    final Predicate<Person> isFemale = isMale.negate();

    final Predicate<Person> boys = isMale.and(isYoung);
    final Predicate<Person> women = isFemale.and(isAdult);

    final Predicate<Person> onlyMens = boys.or(isFemale);

    System.out.println(removeAll(persons, onlyMens));

    System.out.println(removeAll(persons, women.negate()));

    System.out.println(persons);
  }

  private static List<Person> createDemoData() {
    final List<Person> persons = new ArrayList<>();
    persons.add(new Person("Michael", 43));
    persons.add(new Person("Barbara", 41, Sex.FEMALE));
    persons.add(new Person("Lili", 34, Sex.FEMALE));
    persons.add(new Person("Mona Lisa", 17, Sex.FEMALE));
    persons.add(new Person("Tom", 8));
    persons.add(new Person("Björn", 7));
    persons.add(new Person("Stefan", 26));
    return persons;
  }

  private static <E> List<E> removeAll(final List<E> list,
                                    final Predicate<? super E> condition) {
    final List<E> copy = new ArrayList<>(list);
    copy.removeIf(condition);
    return copy;
  }
}