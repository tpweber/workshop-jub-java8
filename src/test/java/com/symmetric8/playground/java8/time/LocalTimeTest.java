package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class <code>java.time.LocalTime</code>.
 */
public class LocalTimeTest {
  @Test
  public void testLocalTimeCreationOf() {
    LocalTime time1 = LocalTime.of(10, 13);
    assertEquals(10, time1.getHour());
    assertEquals(13, time1.getMinute());
    assertEquals(0, time1.getSecond());
    assertEquals(0, time1.getNano());
    LocalTime time2 = LocalTime.of(14, 16, 18);
    assertEquals(14, time2.getHour());
    assertEquals(16, time2.getMinute());
    assertEquals(18, time2.getSecond());
    assertEquals(0, time2.getNano());
    LocalTime time3 = LocalTime.of(23, 59, 59, 999999999);
    assertEquals(23, time3.getHour());
    assertEquals(59, time3.getMinute());
    assertEquals(59, time3.getSecond());
    assertEquals(999999999, time3.getNano());
    LocalTime time4 = LocalTime.of(0, 0, 0, 0);
    assertEquals(0, time4.getHour());
    assertEquals(0, time4.getMinute());
    assertEquals(0, time4.getSecond());
    assertEquals(0, time4.getNano());
    LocalTime time5 = LocalTime.ofSecondOfDay(36780);
    assertEquals(10, time5.getHour());
    assertEquals(13, time5.getMinute());
    assertEquals(0, time5.getSecond());
    assertEquals(0, time5.getNano());
    assertEquals(36780, time5.toSecondOfDay());
  }

  @Test
  public void testLocalTimeCreationParse() {
    LocalTime time1 = LocalTime.parse("10:13");
    assertEquals(10, time1.getHour());
    assertEquals(13, time1.getMinute());
    assertEquals(0, time1.getSecond());
    assertEquals(0, time1.getNano());
    LocalTime time2 = LocalTime.parse("14:16:18");
    assertEquals(14, time2.getHour());
    assertEquals(16, time2.getMinute());
    assertEquals(18, time2.getSecond());
    assertEquals(0, time2.getNano());
    LocalTime time3 = LocalTime.parse("14|16|18", DateTimeFormatter.ofPattern("HH|mm|ss"));
    assertEquals(14, time3.getHour());
    assertEquals(16, time3.getMinute());
    assertEquals(18, time3.getSecond());
    assertEquals(0, time3.getNano());
    LocalTime time4 =  LocalTime.parse("14:16:18", DateTimeFormatter.ISO_LOCAL_TIME);
    assertEquals(time3, time4);
  }

}
