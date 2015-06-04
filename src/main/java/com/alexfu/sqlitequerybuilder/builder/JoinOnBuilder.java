package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class JoinOnBuilder extends SegmentBuilder {

  private SelectJoinBuilder prefix;
  private String condition;

  public JoinOnBuilder(SelectJoinBuilder prefix, String condition) {
    this.prefix = prefix;
    this.condition = condition;
  }

  public SelectWhereBuilder where(String condition) {
    return new SelectWhereBuilder(this, condition);
  }

  public SelectJoinBuilder join(String table) {
    return new SelectJoinBuilder(this, table, JoinType.JOIN);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "ON", condition);
  }
}
