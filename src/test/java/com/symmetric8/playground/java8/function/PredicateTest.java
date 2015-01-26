package com.symmetric8.playground.java8.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Tests predicates from the package <code>java.util.function</code>.
 */
public class PredicateTest {

  static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
    return numbers.stream().filter(predicate).collect(Collectors.toList());
  }

  static Predicate<Integer> isDivisibleBy(int divisor) {
    return p -> 0 == p % divisor;
  }


   // http://howtodoinjava.com/2014/04/04/how-to-use-predicate-in-java-8/
  @Test
  public void testSimplePredicate() {
    Predicate<Integer> is8DivisibleBy4 = isDivisibleBy(4);
    assertTrue(is8DivisibleBy4.test(8));
    Predicate<Integer> is8DivisibleBy5 = isDivisibleBy(5);
    assertFalse(is8DivisibleBy5.test(8));
    final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    List<Integer> resultDivisibleBy2 = filterNumbers(list, isDivisibleBy(2));
    assertNotNull(resultDivisibleBy2);
    assertEquals(5, resultDivisibleBy2.size());
    assertEquals(Arrays.asList(2,4,6,8,10), resultDivisibleBy2);
    List<Integer> resultDivisibleBy3 = filterNumbers(list, isDivisibleBy(3));
    assertNotNull(resultDivisibleBy3);
    assertEquals(3, resultDivisibleBy3.size());
    assertEquals(Arrays.asList(3,6,9), resultDivisibleBy3);
  }


}
