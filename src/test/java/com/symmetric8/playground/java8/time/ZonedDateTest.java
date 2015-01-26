package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.zone.ZoneRules;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Tests for
 */
public class ZonedDateTest {
  @Test
  public void testCreation() {
    ZoneId zoneIdUTC = ZoneId.of("UTC");
    LocalDateTime lDateTime1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    ZonedDateTime zDate1 = ZonedDateTime.of(lDateTime1, zoneIdUTC);
    assertEquals(lDateTime1, zDate1.toLocalDateTime());
    LocalDate lDate1 = LocalDate.from(lDateTime1);
    LocalTime lTime1 = LocalTime.from(lDateTime1);
    ZoneId zoneIdEuropeBerlin = ZoneId.of("Europe/Berlin");
    final ZoneRules zoneIdEuropeBerlinRules = zoneIdEuropeBerlin.getRules();
    assertNotNull(zoneIdEuropeBerlinRules);
    ZonedDateTime zDate2 = ZonedDateTime.of(lDate1, lTime1, zoneIdEuropeBerlin);
    assertEquals(lDate1, zDate1.toLocalDate());
    assertEquals(lTime1, zDate2.toLocalTime());
  }
  @Test
  public void testToOffsetDateTime() {
    ZoneId zoneIdEuropeBerlin = ZoneId.of("Europe/Berlin");
    LocalDateTime lDateTime1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    ZonedDateTime zDate1 = ZonedDateTime.of(lDateTime1, zoneIdEuropeBerlin);
    final ZoneOffset offset = zDate1.getOffset();
    assertNotNull(offset);
    final OffsetDateTime oDate1 = zDate1.toOffsetDateTime();
    assertEquals(offset, oDate1.getOffset());
    OffsetDateTime oDate2 = OffsetDateTime.of(lDateTime1, offset);
    assertEquals(oDate1, oDate2);
  }

  @Test
  public void testWithZoneSameLocal() {
    ZoneId zoneIdEuropeBerlin = ZoneId.of("Europe/Berlin");
    LocalDateTime lDateTime1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    ZonedDateTime zDate1 = ZonedDateTime.of(lDateTime1, zoneIdEuropeBerlin);
    assertEquals(24, zDate1.getDayOfMonth());
    assertEquals(18, zDate1.getHour());
    ZoneId zoneIdAustraliaPerth = ZoneId.of("Australia/Perth");
    final ZonedDateTime zDate2 = zDate1.withZoneSameLocal(zoneIdAustraliaPerth);
    assertEquals(zoneIdAustraliaPerth, zDate2.getZone());
    assertEquals(lDateTime1, zDate2.toLocalDateTime());
    assertEquals(24, zDate2.getDayOfMonth());
    assertEquals(18, zDate2.getHour());
    ZoneId zoneIdAmericaLA = ZoneId.of("America/Los_Angeles");
    final ZonedDateTime zDate3 = zDate1.withZoneSameLocal(zoneIdAmericaLA);
    assertEquals(zoneIdAmericaLA, zDate3.getZone());
    assertEquals(lDateTime1, zDate3.toLocalDateTime());
    assertEquals(24, zDate3.getDayOfMonth());
    assertEquals(18, zDate3.getHour());
  }

  @Test
  public void testWithZoneSameInstant() {
    ZoneId zoneIdEuropeBerlin = ZoneId.of("Europe/Berlin");
    LocalDateTime lDateTime1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    ZonedDateTime zDate1 = ZonedDateTime.of(lDateTime1, zoneIdEuropeBerlin);
    assertEquals(24, zDate1.getDayOfMonth());
    assertEquals(18, zDate1.getHour());
    ZoneId zoneIdAustraliaPerth = ZoneId.of("Australia/Perth");
    final ZonedDateTime zDate2 = zDate1.withZoneSameInstant(zoneIdAustraliaPerth);
    assertEquals(zoneIdAustraliaPerth, zDate2.getZone());
    assertNotEquals(lDateTime1, zDate2.toLocalDateTime());
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 25, 1, 36, 54), zDate2.toLocalDateTime());
    assertEquals(25, zDate2.getDayOfMonth());
    assertEquals(1, zDate2.getHour());
    ZoneId zoneIdAmericaLA = ZoneId.of("America/Los_Angeles");
    final ZonedDateTime zDate3 = zDate1.withZoneSameInstant(zoneIdAmericaLA);
    assertEquals(zoneIdAmericaLA, zDate3.getZone());
    assertNotEquals(lDateTime1, zDate3.toLocalDateTime());
    assertEquals(LocalDateTime.of(2014, Month.DECEMBER, 24, 9, 36, 54), zDate3.toLocalDateTime());
    assertEquals(24, zDate3.getDayOfMonth());
    assertEquals(9, zDate3.getHour());
  }
}
