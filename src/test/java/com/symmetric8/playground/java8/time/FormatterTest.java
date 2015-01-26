package com.symmetric8.playground.java8.time;

import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the different formatting methods of package <code>java.time</code>
 */
public class FormatterTest {
  @Test
  public void testLocalDateTimeFormat() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    assertEquals("2014-12-24T18:36:54", date1.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    assertEquals("24.12.2014 18:36:54", date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    assertEquals("24.12.2014 06:36:54 PM", date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss a")));
  }

  @Test(expected = DateTimeException.class)
  public void testLocalDateTimeFormatWithLocalized() {
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    assertEquals("2014-12-24T18:36:54", date1.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
  }

  @Test
  public void testDateTimeFormatterBuilder() {
    DateTimeFormatterBuilder fBuilder = new DateTimeFormatterBuilder();
    final DateTimeFormatter formatterEmpty = fBuilder.toFormatter();
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    assertEquals("", date1.format(formatterEmpty));
    final DateTimeFormatter formatterMedium = fBuilder.appendLocalized(FormatStyle.MEDIUM, FormatStyle.MEDIUM).toFormatter(Locale.GERMANY);
    assertEquals("24.12.2014 18:36:54", date1.format(formatterMedium));
    final DateTimeFormatter formatterShortAppended = fBuilder.appendLocalized(FormatStyle.SHORT, FormatStyle.SHORT).toFormatter(Locale.GERMANY);
    assertEquals("24.12.2014 18:36:5424.12.14 18:36", date1.format(formatterShortAppended));
    final DateTimeFormatter formatterShortFresh = new DateTimeFormatterBuilder().appendLocalized(FormatStyle.SHORT, FormatStyle.SHORT).toFormatter(Locale.GERMANY);
    assertEquals("24.12.14 18:36", date1.format(formatterShortFresh));
    final DateTimeFormatter formatterShortFreshUS = new DateTimeFormatterBuilder().appendLocalized(FormatStyle.SHORT, FormatStyle.SHORT).toFormatter(Locale.US);
    assertEquals("12/24/14 6:36 PM", date1.format(formatterShortFreshUS));
    final DateTimeFormatter formatterPattern = new DateTimeFormatterBuilder().appendPattern("u_M_d HH_mm_ss").toFormatter(Locale.GERMAN);
    assertEquals("2014_12_24 18_36_54", date1.format(formatterPattern));
  }

  @Test(expected = DateTimeException.class)
  public void testDateTimeFormatterBuilderLong() {
    DateTimeFormatterBuilder fBuilder = new DateTimeFormatterBuilder();
    LocalDateTime date1 = LocalDateTime.of(2014, Month.DECEMBER, 24, 18, 36, 54);
    final DateTimeFormatter formatterLong = fBuilder.appendLocalized(FormatStyle.LONG, FormatStyle.LONG).toFormatter();
    assertEquals("expected DateTimeException", date1.format(formatterLong));
  }
}
