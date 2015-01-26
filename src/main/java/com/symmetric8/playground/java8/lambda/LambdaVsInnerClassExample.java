package com.symmetric8.playground.java8.lambda;

/**
 * Difference between lambdas und inner classes.
 */
public class LambdaVsInnerClassExample {
  private String outerAttribute = "accessFromOutside";

  public static void main(final String[] args) {
    new LambdaVsInnerClassExample().executeMethodAndLambda();
  }

  private void executeMethodAndLambda() {
    int effectivelyFinal = 4711;

    final Runnable asNormalMethod = new Runnable() {
      @Override
      public String toString() {
        return definitionOfAnotherMethodIsPossible();
      }

      @Override
      public void run() {
        System.out.println(this);
        System.out.println("effectivelyFinal = " + effectivelyFinal);
        System.out.println("outerAttribute = " + LambdaVsInnerClassExample.this.outerAttribute);
      }

      public String definitionOfAnotherMethodIsPossible() {
        return "Anonymous Runnable: can define another method.";
      }


    };

    final Runnable asLambda = () ->
    {
      System.out.println(this);
      System.out.println("effectivelyFinal = " + effectivelyFinal);
      System.out.println("outerAttribute = " + this.outerAttribute);
    };

    asNormalMethod.run();
    asLambda.run();
  }
}