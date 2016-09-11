package com.alexfu.sqlitequerybuilder.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils {
  private static DateFormat ISO8601;

  public static DateFormat iso8601() {
    if (ISO8601 == null) {
      ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
    }
    return ISO8601;
  }
}
