package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.Builder;

import static com.alexfu.sqlitequerybuilder.utils.StringUtils.join;

public class SelectJoinBuilder extends SegmentBuilder {

  private Builder prefix;
  private String table;

  public SelectJoinBuilder(Builder prefix, String table) {
    this.prefix = prefix;
    this.table = table;
  }

  public JoinOnBuilder on(String condition) {
    return new JoinOnBuilder(this, condition);
  }

  @Override
  public String build() {
    return join(" ", prefix.build(), "JOIN", table);
  }
}
