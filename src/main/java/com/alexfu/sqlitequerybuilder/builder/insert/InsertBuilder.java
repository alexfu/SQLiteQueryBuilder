package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;

import static com.alexfu.sqlitequerybuilder.utils.Preconditions.checkArgument;

public class InsertBuilder extends SegmentBuilder {
  public InsertIntoBuilder into(String table) {
    checkArgument(table != null, "Table name cannot be null");
    return new InsertIntoBuilder(this, table);
  }

  @Override
  public String build() {
    return "INSERT INTO";
  }
}
