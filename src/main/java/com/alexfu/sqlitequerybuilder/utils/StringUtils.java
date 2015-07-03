package com.alexfu.sqlitequerybuilder.utils;

public class StringUtils {
  public static String join(CharSequence delimiter, String... array) {
    return join(delimiter, (Object[]) array);
  }

  public static String join(CharSequence delimiter, Object... array) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0, size = array.length; i < size; i++) {
      if (i > 0) {
        sb.append(delimiter);
      }
      sb.append(array[i]);
    }
    return sb.toString();
  }
}
