package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectFromBuilder extends SegmentBuilder {

  private SelectBuilder prefix;
  private String[] tables;

  public SelectFromBuilder(SelectBuilder prefix, String... tables) {
    this.prefix = prefix;
    this.tables = tables;
  }

  public SelectWhereBuilder where(String condition) {
    return new SelectWhereBuilder(this, condition);
  }

  public SelectJoinBuilder join(String table) {
    return new SelectJoinBuilder(this, table, JoinType.JOIN);
  }

  public SelectJoinBuilder leftOuterJoin(String table) {
    return new SelectJoinBuilder(this, table, JoinType.LEFT_OUTER_JOIN);
  }

  public SelectJoinBuilder crossJoin(String table) {
    return new SelectJoinBuilder(this, table, JoinType.CROSS_JOIN);
  }

  public SelectJoinBuilder naturalJoin(String table) {
    return new SelectJoinBuilder(this, table, JoinType.NATURAL_JOIN);
  }

  public SelectJoinBuilder naturalLeftOuterJoin(String table) {
    return new SelectJoinBuilder(this, table, JoinType.NATURAL_LEFT_OUTER_JOIN);
  }

  public SelectOrderByBuilder orderBy(String column) {
    return new SelectOrderByBuilder(this, column);
  }

  public SelectGroupByBuilder groupBy(String column) {
    return new SelectGroupByBuilder(this, column);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "FROM", StringUtils.join(",", tables));
  }
}
