package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import static com.alexfu.sqlitequerybuilder.utils.Preconditions.checkArgument;

public class InsertColumnsBuilder extends SegmentBuilder {
  private final SegmentBuilder predicate;
  private final String[] columns;

  InsertColumnsBuilder(SegmentBuilder predicate, String[] columns) {
    this.predicate = predicate;
    this.columns = columns;
  }

  public InsertValuesBuilder values(Object...values) {
    checkArgument(values != null, "Values cannot be null");
    return new InsertValuesBuilder(this, values);
  }

  @Override
  public String build() {
    return predicate.build() + " (" + StringUtils.join(",", columns) + ")";
  }
}
