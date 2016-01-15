package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;

public class InsertBuilder extends SegmentBuilder {
  public InsertIntoBuilder into(String table) {
    return new InsertIntoBuilder(this, table);
  }

  @Override
  public String build() {
    return "INSERT INTO";
  }
}
