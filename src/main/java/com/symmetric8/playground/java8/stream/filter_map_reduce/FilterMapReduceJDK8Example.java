package com.symmetric8.playground.java8.stream.filter_map_reduce;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * a kind of filter-map-reduce, the Java8 way
 */
public class FilterMapReduceJDK8Example {
    public static void main(String[] args) {
        final List<Person> persons = Arrays.asList(new Person("Stefan", LocalDate.of(1971, Month.MAY, 12)),
                new Person("Micha", LocalDate.of(1971, Month.FEBRUARY, 7)),
                new Person("Andi", LocalDate.of(1968, Month.JULY, 17)),
                new Person("Dani", LocalDate.of(1970, Month.JULY, 19)),
                new Person("Merten", LocalDate.of(1975, Month.JUNE, 14)));



        final String bornInJuly = persons.stream()
                .filter(person -> person.birthday.getMonth() == Month.JULY)
                .map(person -> person.name).collect(Collectors.joining(", "));

        System.out.println(bornInJuly);
        System.out.println("");


        final Predicate<Person> predicate = person -> person.birthday.getMonth() == Month.JULY;
        final Function<Person, String> function = person -> person.name;
        final Collector<CharSequence, ?, String> collector = Collectors.joining(", ");
        final String bornInJuly2 = persons.stream()
                .filter(predicate)
                .map(function).collect(collector);

        System.out.println(bornInJuly2);
    }
}