package com.symmetric8.playground.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * Tests for simple lambda expressions.
 */
public class LambdaTest {
  @Test
  public void testListForEach() {
    final List<Integer> list = Arrays.asList(1,2,3,4);
    final AtomicInteger sum = new AtomicInteger(0);
    list.forEach((i) -> sum.addAndGet(i));
    assertEquals(10, sum.get());
  }



}
