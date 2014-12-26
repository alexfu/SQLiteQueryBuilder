package com.alexfu.sqlitequerybuilder.utils;

public class SQLUtils {
  private SQLUtils() {}

  public static String wrap(String string) {
    return "`" + string + "`";
  }
}
