package com.alexfu.sqlitequerybuilder.utils;

public class StringUtils {
  public static String join(CharSequence delimiter, String... array) {
    return join(delimiter, (Object[]) array);
  }

  public static String join(CharSequence delimiter, Object... array) {
    StringBuilder sb = new StringBuilder();
    boolean firstTime = true;
    for (Object object : array) {
      if (firstTime) {
        firstTime = false;
      } else {
        sb.append(delimiter);
      }
      sb.append(object);
    }
    return sb.toString();
  }
}
