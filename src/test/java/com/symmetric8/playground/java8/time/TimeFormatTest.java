package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Tests the formatting capabilities of the new <code>java.time</code> package.
 */
public class TimeFormatTest {
  @Test
  public void testLocalDateDisplayName() {
    LocalDate date1 = LocalDate.of(2014, Month.DECEMBER, 24);
    final Month month1 = date1.getMonth();
    assertEquals(Month.DECEMBER, month1);
    assertEquals("Dezember", month1.getDisplayName(TextStyle.FULL, Locale.GERMAN));
    assertEquals("December", month1.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    assertEquals("12", month1.getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMAN));
    assertEquals("12", month1.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
    assertEquals("Dez", month1.getDisplayName(TextStyle.SHORT, Locale.GERMAN));
    assertEquals("Dec", month1.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    assertEquals("Dez", month1.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.GERMAN));
    assertEquals("12", month1.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH));
    assertEquals("D", month1.getDisplayName(TextStyle.NARROW, Locale.GERMAN));
    assertEquals("D", month1.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
    final DayOfWeek dayOfWeek1 = date1.getDayOfWeek();
    assertEquals(DayOfWeek.WEDNESDAY, dayOfWeek1);
    assertEquals("Mittwoch", dayOfWeek1.getDisplayName(TextStyle.FULL, Locale.GERMAN));
    assertEquals("Wednesday", dayOfWeek1.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    assertEquals("Mittwoch", dayOfWeek1.getDisplayName(TextStyle.FULL_STANDALONE, Locale.GERMAN));
    assertEquals("Wednesday", dayOfWeek1.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
    assertEquals("Mi", dayOfWeek1.getDisplayName(TextStyle.SHORT, Locale.GERMAN));
    assertEquals("Wed", dayOfWeek1.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    assertEquals("Mi", dayOfWeek1.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.GERMAN));
    assertEquals("Wed", dayOfWeek1.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.ENGLISH));
    assertEquals("M", dayOfWeek1.getDisplayName(TextStyle.NARROW, Locale.GERMAN));
    assertEquals("W", dayOfWeek1.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
  }

  @Test
  public void testDayDisplayNamesGerman() {
    testDayOfWeekDisplayNamesFull(DayOfWeek.MONDAY, "Montag", "Montag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.MONDAY, "Mo", "Mo", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.MONDAY, "M", "1", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.TUESDAY, "Dienstag", "Dienstag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.TUESDAY, "Di", "Di", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.TUESDAY, "D", "2", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.WEDNESDAY, "Mittwoch", "Mittwoch", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.WEDNESDAY, "Mi", "Mi", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.WEDNESDAY, "M", "3", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.THURSDAY, "Donnerstag", "Donnerstag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.THURSDAY, "Do", "Do", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.THURSDAY, "D", "4", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.FRIDAY, "Freitag", "Freitag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.FRIDAY, "Fr", "Fr", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.FRIDAY, "F", "5", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.SATURDAY, "Samstag", "Samstag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.SATURDAY, "Sa", "Sa", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.SATURDAY, "S", "6", Locale.GERMAN);

    testDayOfWeekDisplayNamesFull(DayOfWeek.SUNDAY, "Sonntag", "Sonntag", Locale.GERMAN);
    testDayOfWeekDisplayNamesShort(DayOfWeek.SUNDAY, "So", "So", Locale.GERMAN);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.SUNDAY, "S", "7", Locale.GERMAN);
  }

  @Test
  public void testDayDisplayNamesEnglish() {
    testDayOfWeekDisplayNamesFull(DayOfWeek.MONDAY, "Monday", "Monday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.MONDAY, "Mon", "Mon", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.MONDAY, "M", "1", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.TUESDAY, "Tuesday", "Tuesday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.TUESDAY, "Tue", "Tue", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.TUESDAY, "T", "2", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.WEDNESDAY, "Wednesday", "Wednesday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.WEDNESDAY, "Wed", "Wed", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.WEDNESDAY, "W", "3", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.THURSDAY, "Thursday", "Thursday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.THURSDAY, "Thu", "Thu", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.THURSDAY, "T", "4", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.FRIDAY, "Friday", "Friday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.FRIDAY, "Fri", "Fri", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.FRIDAY, "F", "5", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.SATURDAY, "Saturday", "Saturday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.SATURDAY, "Sat", "Sat", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.SATURDAY, "S", "6", Locale.ENGLISH);

    testDayOfWeekDisplayNamesFull(DayOfWeek.SUNDAY, "Sunday", "Sunday", Locale.ENGLISH);
    testDayOfWeekDisplayNamesShort(DayOfWeek.SUNDAY, "Sun", "Sun", Locale.ENGLISH);
    testDayOfWeekDisplayNamesNarrow(DayOfWeek.SUNDAY, "S", "7", Locale.ENGLISH);
  }

  @Test
  public void testMonthDisplayNamesGerman() {
    testMonthDisplayNamesFull(Month.JANUARY, "Januar", "1", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.JANUARY, "Jan", "Jan", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.JANUARY, "J", "1", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.FEBRUARY, "Februar", "2", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.FEBRUARY, "Feb", "Feb", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.FEBRUARY, "F", "2", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.MARCH, "März", "3", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.MARCH, "Mär", "Mrz", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.MARCH, "M", "3", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.APRIL, "April", "4", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.APRIL, "Apr", "Apr", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.APRIL, "A", "4", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.MAY, "Mai", "5", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.MAY, "Mai", "Mai", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.MAY, "M", "5", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.JUNE, "Juni", "6", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.JUNE, "Jun", "Jun", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.JUNE, "J", "6", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.JULY, "Juli", "7", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.JULY, "Jul", "Jul", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.JULY, "J", "7", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.AUGUST, "August", "8", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.AUGUST, "Aug", "Aug", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.AUGUST, "A", "8", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.SEPTEMBER, "September", "9", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.SEPTEMBER, "Sep", "Sep", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.SEPTEMBER, "S", "9", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.OCTOBER, "Oktober", "10", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.OCTOBER, "Okt", "Okt", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.OCTOBER, "O", "10", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.NOVEMBER, "November", "11", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.NOVEMBER, "Nov", "Nov", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.NOVEMBER, "N", "11", Locale.GERMAN);

    testMonthDisplayNamesFull(Month.DECEMBER, "Dezember", "12", Locale.GERMAN);
    testMonthDisplayNamesShort(Month.DECEMBER, "Dez", "Dez", Locale.GERMAN);
    testMonthDisplayNamesNarrow(Month.DECEMBER, "D", "12", Locale.GERMAN);
  }

  @Test
  public void testMonthDisplayNamesEnglish() {
    testMonthDisplayNamesFull(Month.JANUARY, "January", "1", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.JANUARY, "Jan", "1", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.JANUARY, "J", "1", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.FEBRUARY, "February", "2", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.FEBRUARY, "Feb", "2", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.FEBRUARY, "F", "2", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.MARCH, "March", "3", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.MARCH, "Mar", "3", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.MARCH, "M", "3", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.APRIL, "April", "4", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.APRIL, "Apr", "4", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.APRIL, "A", "4", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.MAY, "May", "5", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.MAY, "May", "5", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.MAY, "M", "5", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.JUNE, "June", "6", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.JUNE, "Jun", "6", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.JUNE, "J", "6", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.JULY, "July", "7", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.JULY, "Jul", "7", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.JULY, "J", "7", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.AUGUST, "August", "8", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.AUGUST, "Aug", "8", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.AUGUST, "A", "8", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.SEPTEMBER, "September", "9", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.SEPTEMBER, "Sep", "9", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.SEPTEMBER, "S", "9", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.OCTOBER, "October", "10", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.OCTOBER, "Oct", "10", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.OCTOBER, "O", "10", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.NOVEMBER, "November", "11", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.NOVEMBER, "Nov", "11", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.NOVEMBER, "N", "11", Locale.ENGLISH);

    testMonthDisplayNamesFull(Month.DECEMBER, "December", "12", Locale.ENGLISH);
    testMonthDisplayNamesShort(Month.DECEMBER, "Dec", "12", Locale.ENGLISH);
    testMonthDisplayNamesNarrow(Month.DECEMBER, "D", "12", Locale.ENGLISH);
  }

  private void testDayOfWeekDisplayNamesFull(final DayOfWeek day, final String full, final String fullStandalone, final Locale locale) {
    assertEquals(full, day.getDisplayName(TextStyle.FULL, locale));
    assertEquals(fullStandalone, day.getDisplayName(TextStyle.FULL_STANDALONE, locale));
  }

  private void testDayOfWeekDisplayNamesShort(final DayOfWeek day, final String pShort, final String shortStandalone, final Locale locale) {
    assertEquals(pShort, day.getDisplayName(TextStyle.SHORT, locale));
    assertEquals(shortStandalone, day.getDisplayName(TextStyle.SHORT_STANDALONE, locale));
  }

  private void testDayOfWeekDisplayNamesNarrow(final DayOfWeek day, final String narrow, final String narrowStandalone, final Locale locale) {
    assertEquals(narrow, day.getDisplayName(TextStyle.NARROW, locale));
    assertEquals(narrowStandalone, day.getDisplayName(TextStyle.NARROW_STANDALONE, locale));
  }

  private void testMonthDisplayNamesFull(final Month month, final String full, final String fullStandalone, final Locale locale) {
    assertEquals(full, month.getDisplayName(TextStyle.FULL, locale));
    assertEquals(fullStandalone, month.getDisplayName(TextStyle.FULL_STANDALONE, locale));
  }

  private void testMonthDisplayNamesShort(final Month month, final String pShort, final String shortStandalone, final Locale locale) {
    assertEquals(pShort, month.getDisplayName(TextStyle.SHORT, locale));
    assertEquals(shortStandalone, month.getDisplayName(TextStyle.SHORT_STANDALONE, locale));
  }

  private void testMonthDisplayNamesNarrow(final Month month, final String narrow, final String narrowStandalone, final Locale locale) {
    assertEquals(narrow, month.getDisplayName(TextStyle.NARROW, locale));
    assertEquals(narrowStandalone, month.getDisplayName(TextStyle.NARROW_STANDALONE, locale));
  }
}
