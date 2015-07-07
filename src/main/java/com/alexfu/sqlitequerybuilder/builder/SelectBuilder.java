package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.Preconditions;

public abstract class SelectBuilder extends SegmentBuilder {
  public SelectFromBuilder from(String table) {
    Preconditions.checkNotNull(table, "Table cannot be null");
    return new SelectFromBuilder(this, table);
  }
}
