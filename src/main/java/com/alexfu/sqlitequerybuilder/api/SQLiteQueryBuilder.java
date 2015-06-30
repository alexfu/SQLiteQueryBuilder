package com.alexfu.sqlitequerybuilder.api;

import com.alexfu.sqlitequerybuilder.builder.*;

public class SQLiteQueryBuilder {
  public static SelectBuilder select(String... fields) {
    return new SelectFieldBuilder(fields);
  }

  public static SelectBuilder select(SelectType type) {
    return new SelectTypeBuilder(type);
  }

  public static CreateBuilder create() {
    return new CreateBuilder();
  }
  
  public static DropSegmentBuilder drop() {
  	return new DropSegmentBuilder();
  }
}
