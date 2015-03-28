package com.alexfu.sqlitequerybuilder.builder;

public abstract class SelectBuilder extends SegmentBuilder {
  public SelectFromBuilder from(String table) {
    return new SelectFromBuilder(this, table);
  }
}
