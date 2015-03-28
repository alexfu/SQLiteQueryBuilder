package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SelectType;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectTypeBuilder extends SelectBuilder {

  private SelectType type;

  public SelectTypeBuilder(SelectType type) {
    this.type = type;
  }

  @Override
  public String build() {
    return ArrayUtils.join(" ", "SELECT", type.build());
  }
}
