package com.alexfu.sqlitequerybuilder.api;

import com.alexfu.sqlitequerybuilder.builder.*;

public class SQLiteQueryBuilder {
  public static SelectBuilder select(String... fields) {
    return new SelectFieldBuilder(fields);
  }

  public static SelectBuilder select(SelectType type) {
    return new SelectTypeBuilder(type);
  }

  public static CreateTableSegmentBuilder create() {
    return new CreateTableSegmentBuilder();
  }
  
  public static DropSegmentBuilder drop() {
    return new DropSegmentBuilder();
  }
}
