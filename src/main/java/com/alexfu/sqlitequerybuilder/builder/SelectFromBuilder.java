package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectFromBuilder implements SegmentBuilder {

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
    return new SelectJoinBuilder(this, table);
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

  @Override
  public String toString() {
    return toString();
  }
}
