package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectType implements SegmentBuilder {

  private enum Type {
    DISTINCT, ALL
  }

  private Type type;
  private String[] fields;

  private SelectType(Type type, String...fields) {
    this.type = type;
    this.fields = fields;
  }

  public static SelectType DISTINCT(String... fields) {
    return new SelectType(Type.DISTINCT, fields);
  }

  public static SelectType ALL(String... fields) {
    return new SelectType(Type.ALL, fields);
  }

  @Override
  public String build() {
    return ArrayUtils.join(" ", type, ArrayUtils.join(",", fields));
  }
}
