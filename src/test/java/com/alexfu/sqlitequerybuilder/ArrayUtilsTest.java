package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayUtilsTest {
  @Test
  public void joinsStringsWithCommaDelimeter() {
    String[] strings = {"One", "Two", "Three", "Four", "Five"};

    String expected = "One,Two,Three,Four,Five";
    String result = ArrayUtils.join(strings, ",");
    assertEquals(expected, result);
  }
}
