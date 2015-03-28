package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;

import static com.alexfu.sqlitequerybuilder.utils.ArrayUtils.join;

public class SelectBuilder implements SegmentBuilder {

  private String[] fields;
  private SelectType type;

  public SelectBuilder(String...fields) {
    this.fields = fields;
  }

  public SelectBuilder(SelectType type) {
    this.type = type;
  }

  public SelectFromBuilder from(String table) {
    return new SelectFromBuilder(this, table);
  }

  @Override
  public String build() {
    if (fields != null) {
      return join(" ", "SELECT", join(",", fields));
    }

    if (type != null) {
      return join(" ", "SELECT", type.build());
    }

    return null;
  }
}
