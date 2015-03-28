package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;

import static com.alexfu.sqlitequerybuilder.utils.ArrayUtils.join;

public class SelectJoinBuilder implements SegmentBuilder {

  private SegmentBuilder prefix;
  private String table;

  public SelectJoinBuilder(SegmentBuilder prefix, String table) {
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
