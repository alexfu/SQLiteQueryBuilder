package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class JoinOnBuilder extends SegmentBuilder {

  private SelectJoinBuilder prefix;
  private String condition;

  public JoinOnBuilder(SelectJoinBuilder prefix, String condition) {
    this.prefix = prefix;
    this.condition = condition;
  }

  public SelectWhereBuilder where(String condition) {
    Preconditions.checkNotNull(condition, "Condition cannot be null");
    return new SelectWhereBuilder(this, condition);
  }

  public SelectJoinBuilder join(String table) {
    Preconditions.checkNotNull(table, "Table name cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.JOIN);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "ON", condition);
  }
}
