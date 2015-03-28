package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectGroupByBuilder implements SegmentBuilder {

  private SelectFromBuilder prefix;
  private String column;

  public SelectGroupByBuilder(SelectFromBuilder prefix, String column) {
    this.prefix = prefix;
    this.column = column;
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "GROUP BY", column);
  }

  @Override
  public String toString() {
    return build();
  }
}
