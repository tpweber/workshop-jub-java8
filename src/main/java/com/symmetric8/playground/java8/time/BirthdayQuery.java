package com.symmetric8.playground.java8.time;

import java.time.MonthDay;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Objects;

/**
 * This <code>TemporalQuery</code> checks whether the passed-in date is on the same day and month
 * as the <code>MonthDay</code>, given at construction.
 */
public final class BirthdayQuery implements TemporalQuery<Boolean> {

  private final MonthDay mBirthday;

  public BirthdayQuery(final MonthDay birthday) {
    mBirthday = birthday;
  }

  MonthDay getBirthday() {
    return mBirthday;
  }

  @Override
  public Boolean queryFrom(final TemporalAccessor temporal) {
    return canQuery(temporal) ? doQuery(temporal) : Boolean.FALSE;
  }

  private Boolean doQuery(final TemporalAccessor temporal) {
    int month = temporal.get(ChronoField.MONTH_OF_YEAR);
    int day = temporal.get(ChronoField.DAY_OF_MONTH);
    return month == mBirthday.getMonthValue() && day == mBirthday.getDayOfMonth();
  }

  private boolean canQuery(final TemporalAccessor temporal) {
    return Objects.nonNull(temporal) && temporal.isSupported(ChronoField.MONTH_OF_YEAR) && temporal.isSupported(ChronoField.DAY_OF_MONTH);
  }
}
