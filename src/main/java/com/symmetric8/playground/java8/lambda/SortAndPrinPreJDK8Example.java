package com.symmetric8.playground.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting pre-Java8.
 */
public class SortAndPrinPreJDK8Example {
    public static void main(final String[] args) {
        final List<String> names = Arrays.asList("1234", "1234567", "123", "12345678", "12");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(final String str1, final String str2) {
                return Integer.compare(str1.length(), str2.length());
            }
        });
        for (String name : names) {
            System.out.print(name.length() + ", ");
        }
    }
}
