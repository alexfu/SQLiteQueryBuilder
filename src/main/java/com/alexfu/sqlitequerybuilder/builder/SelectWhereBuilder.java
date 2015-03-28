package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;

import static com.alexfu.sqlitequerybuilder.utils.ArrayUtils.join;

public class SelectWhereBuilder implements SegmentBuilder {

  private SegmentBuilder prefix;
  private String condition;

  public SelectWhereBuilder(SegmentBuilder prefix, String condition) {
    this.condition = condition;
    this.prefix = prefix;
  }

  public SelectAndBuilder and(String condition) {
    return new SelectAndBuilder(this, condition);
  }

  public SelectLimitBuilder limit(int limit) {
    return new SelectLimitBuilder(this, limit);
  }

  public SelectOrderByBuilder orderBy(String column) {
    return new SelectOrderByBuilder(this, column);
  }

  @Override
  public String build() {
    return join(" ", prefix.build(), "WHERE", condition);
  }
}
