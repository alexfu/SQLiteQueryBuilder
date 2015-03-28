package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectFieldBuilder extends SelectBuilder {

  private String[] fields;

  public SelectFieldBuilder(String... fields) {
    this.fields = fields;
  }

  @Override
  public String build() {
    return StringUtils.join(" ", "SELECT", StringUtils.join(",", fields));
  }
}
