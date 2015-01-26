package com.symmetric8.playground.java8.stream;

/**
 * simple representation of a person.
 */
public class Person {
  private final String name;

  private final int age;

  private final Sex gender;

  private String favoriteColor = null;

  public Person(final String name, final int age) {
    this(name, age, Sex.MALE);
  }

  public Person(final String name, final int age, final Sex gender) {
    this(name, age, gender, null);
  }

  public String getFavoriteColor() {
    return favoriteColor;
  }

  public void setFavoriteColor(final String favoriteColor) {
    this.favoriteColor = favoriteColor;
  }

  public Person(final String name, final int age, final Sex gender, final String favoriteColor) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.favoriteColor = favoriteColor;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Sex getGender() {
    return gender;
  }

  public boolean isAdult() {
    return age >= 18;
  }

  @Override
  public String toString() {
    return "Person [name = " + name + ", age = " + age + ", favoriteColor = " + favoriteColor + "]";
  }
}