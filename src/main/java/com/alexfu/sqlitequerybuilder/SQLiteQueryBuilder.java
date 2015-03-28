package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.impl.SelectBuilder;
import com.alexfu.sqlitequerybuilder.impl.SelectType;

public class SQLiteQueryBuilder {
  public static SelectBuilder select(String... fields) {
    return new SelectBuilder(fields);
  }

  public static SelectBuilder select(SelectType type) {
    return new SelectBuilder(type);
  }
}
