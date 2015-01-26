package com.symmetric8.playground.java8.stream.filter_map_reduce;

import com.symmetric8.playground.java8.stream.Sex;

import java.time.LocalDate;

/**
 * person.
 */
public class Person {
  final String name;

  final LocalDate birthday;

  private final Sex gender;

  private String favoriteColor = null;

  public Person(String name, LocalDate birthday) {
    this(name, birthday, Sex.MALE);
  }

  public Person(final String name, final LocalDate birthday, final Sex gender) {
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
  }

  public String getFavoriteColor() {
    return favoriteColor;
  }

  public void setFavoriteColor(final String favoriteColor) {
    this.favoriteColor = favoriteColor;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public Sex getGender() {
    return gender;
  }

  @Override
  public String toString() {
    return "Person [name = " + name + " / birthday = " + birthday + " / favoriteColor = " + favoriteColor + "]";
  }
}
