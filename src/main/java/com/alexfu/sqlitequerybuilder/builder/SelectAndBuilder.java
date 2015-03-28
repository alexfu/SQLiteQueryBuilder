package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectAndBuilder implements SegmentBuilder {

  private SelectWhereBuilder prefix;
  private String condition;

  public SelectAndBuilder(SelectWhereBuilder prefix, String condition) {
    this.prefix = prefix;
    this.condition = condition;
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "AND", condition);
  }
}
