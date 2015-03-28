package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectFieldBuilder extends SelectBuilder {

  private String[] fields;

  public SelectFieldBuilder(String...fields) {
    this.fields = fields;
  }

  @Override
  public String build() {
    return ArrayUtils.join(" ", "SELECT", ArrayUtils.join(",", fields));
  }
}
