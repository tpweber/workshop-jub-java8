package com.symmetric8.playground.java8.base64;

import java.util.Base64;

/**
 * <code>Base64</code>
 */
public class Base64Example {
  public static void main(final String[] args) {
    final byte[] bytes = "This is the Base64 test text!".getBytes();

    final String encoded = Base64.getEncoder().encodeToString(bytes);
    System.out.println("Base64 encoded = " + encoded);

    final byte[] decoded = Base64.getDecoder().decode(encoded);
    System.out.println("Base64 decoded = " + new String(decoded));

    final String encodedMime = Base64.getMimeEncoder().encodeToString(bytes);
    System.out.println("Base64 encodedMime = " + encodedMime);

    final byte[] decodedMime = Base64.getMimeDecoder().decode(encodedMime);
    System.out.println("Base64 decodedMime = " + new String(decodedMime));

    final String encodedUrl = Base64.getUrlEncoder().encodeToString(bytes);
    System.out.println("Base64 encodedUrl = " + encodedUrl);

    final byte[] decodedUrl = Base64.getUrlDecoder().decode(encodedUrl);
    System.out.println("Base64 decodedUrl = " + new String(decodedUrl));

    final String stringWithSpecialChars = "This is the urlsafe Base64 test text with legal characters like öäüß and ĩ!";
    final byte[] bytes2 = stringWithSpecialChars.getBytes();

    final String encodedUrl2 = Base64.getUrlEncoder().encodeToString(bytes2);
    System.out.println("Base64 encodedUrl = " + encodedUrl2);

    final byte[] decodedUrl2 = Base64.getUrlDecoder().decode(encodedUrl2);
    System.out.println("Base64 decodedUrl = " + new String(decodedUrl2));

    try {
      Base64.getUrlDecoder().decode(stringWithSpecialChars);
    } catch (IllegalArgumentException iae) {
      System.out.println("Base64 methods called with illegal chars throw an IllegalArgumentException -> " + iae.getLocalizedMessage());
    }

    try {
      Base64.getEncoder().encodeToString(null);
    } catch (NullPointerException npe) {
      System.out.println("Base64 methods called with null throw a NPE -> " + npe.getLocalizedMessage());
    }
  }
}