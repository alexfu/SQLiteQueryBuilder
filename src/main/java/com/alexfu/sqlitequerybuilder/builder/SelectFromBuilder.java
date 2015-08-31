package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectFromBuilder extends SegmentBuilder {

  private SelectBuilder prefix;
  private String[] tables;

  public SelectFromBuilder(SelectBuilder prefix, String... tables) {
    this.prefix = prefix;
    this.tables = tables;
  }

  public SelectWhereBuilder where(String condition) {
    Preconditions.checkArgument(condition != null, "Condition cannot be null");
    return new SelectWhereBuilder(this, condition);
  }

  public SelectJoinBuilder join(String table) {
    Preconditions.checkArgument(table != null, "Table cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.JOIN);
  }

  public SelectJoinBuilder leftOuterJoin(String table) {
    Preconditions.checkArgument(table != null, "Table cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.LEFT_OUTER_JOIN);
  }

  public SelectJoinBuilder crossJoin(String table) {
    Preconditions.checkArgument(table != null, "Table cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.CROSS_JOIN);
  }

  public SelectJoinBuilder naturalJoin(String table) {
    Preconditions.checkArgument(table != null, "Table cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.NATURAL_JOIN);
  }

  public SelectJoinBuilder naturalLeftOuterJoin(String table) {
    Preconditions.checkArgument(table != null, "Table cannot be null");
    return new SelectJoinBuilder(this, table, JoinType.NATURAL_LEFT_OUTER_JOIN);
  }

  public SelectOrderByBuilder orderBy(String column) {
    Preconditions.checkArgument(column != null, "Column cannot be null");
    return new SelectOrderByBuilder(this, column);
  }

  public SelectGroupByBuilder groupBy(String column) {
    Preconditions.checkArgument(column != null, "Column cannot be null");
    return new SelectGroupByBuilder(this, column);
  }

  public SelectLimitBuilder limit(int limit) {
    return new SelectLimitBuilder(this, limit);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "FROM", StringUtils.join(",", tables));
  }
}
