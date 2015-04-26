package com.alexfu.sqlitequerybuilder.api;

import com.alexfu.sqlitequerybuilder.builder.CreateTableBuilder;
import com.alexfu.sqlitequerybuilder.builder.SelectBuilder;
import com.alexfu.sqlitequerybuilder.builder.SelectFieldBuilder;
import com.alexfu.sqlitequerybuilder.builder.SelectTypeBuilder;

public class SQLiteQueryBuilder {
  public static SelectBuilder select(String... fields) {
    return new SelectFieldBuilder(fields);
  }

  public static SelectBuilder select(SelectType type) {
    return new SelectTypeBuilder(type);
  }

  public static CreateTableBuilder createTable(String table) {
    return new CreateTableBuilder(table, false);
  }
  
  public static CreateTableBuilder createTable(String table, boolean tableExists) {
  	return new CreateTableBuilder(table, tableExists);
  }
}
