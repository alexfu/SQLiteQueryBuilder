package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.Builder;

import static com.alexfu.sqlitequerybuilder.utils.StringUtils.join;

public class SelectWhereBuilder extends SegmentBuilder {

  private Builder prefix;
  private String condition;

  public SelectWhereBuilder(Builder prefix, String condition) {
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
