package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import static com.alexfu.sqlitequerybuilder.utils.Preconditions.checkArgument;

public class InsertIntoBuilder extends SegmentBuilder {
  private final InsertBuilder predicate;
  private final String table;

  public InsertIntoBuilder(InsertBuilder predicate, String table) {
    this.predicate = predicate;
    this.table = table;
  }

  public InsertColumnsBuilder columns(String...columns) {
    checkArgument(columns != null, "Column names cannot be null");
    return new InsertColumnsBuilder(this, columns);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", predicate.build(), table);
  }
}
