package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class JoinOnBuilder implements SegmentBuilder {

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
    return new SelectJoinBuilder(this, table);
  }

  @Override
  public String build() {
    return ArrayUtils.join(" ", prefix.build(), "ON", condition);
  }
}
