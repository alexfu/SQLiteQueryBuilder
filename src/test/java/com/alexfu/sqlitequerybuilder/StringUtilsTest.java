package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {
  @Test
  public void joinsStringsWithCommaDelimeter() {
    String[] strings = {"One", "Two", "Three", "Four", "Five"};

    String expected = "One,Two,Three,Four,Five";
    String result = StringUtils.join(",", strings);
    assertEquals(expected, result);
  }
}
