package com.alexfu.sqlitequerybuilder.api;

import com.alexfu.sqlitequerybuilder.builder.*;
import com.alexfu.sqlitequerybuilder.builder.delete.DeleteBuilder;
import com.alexfu.sqlitequerybuilder.builder.insert.InsertBuilder;

public class SQLiteQueryBuilder {

  public static InsertBuilder insert() {
    return new InsertBuilder();
  }

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

  public static DeleteBuilder delete() {
    return new DeleteBuilder();
  }
}
