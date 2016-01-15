package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class InsertIntoBuilder extends SegmentBuilder {
  private final InsertBuilder predicate;
  private final String table;

  public InsertIntoBuilder(InsertBuilder predicate, String table) {
    this.predicate = predicate;
    this.table = table;
  }

  public InsertColumnsBuilder columns(String...columns) {
    return new InsertColumnsBuilder(this, columns);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", predicate.build(), table);
  }
}
