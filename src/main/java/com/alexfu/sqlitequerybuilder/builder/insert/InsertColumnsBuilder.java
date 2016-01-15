package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class InsertColumnsBuilder extends SegmentBuilder {
  private final SegmentBuilder predicate;
  private final String[] columns;

  public InsertColumnsBuilder(SegmentBuilder predicate, String[] columns) {
    this.predicate = predicate;
    this.columns = columns;
  }

  public InsertValuesBuilder values(Object...values) {
    return new InsertValuesBuilder(this, values);
  }

  @Override
  public String build() {
    return predicate.build() + " (" + StringUtils.join(",", columns) + ")";
  }
}
