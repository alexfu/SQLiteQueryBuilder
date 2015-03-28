package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;

public abstract class SelectBuilder implements SegmentBuilder {
  public SelectFromBuilder from(String table) {
    return new SelectFromBuilder(this, table);
  }

  @Override
  public String toString() {
    return build();
  }
}
