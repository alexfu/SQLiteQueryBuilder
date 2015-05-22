package com.alexfu.sqlitequerybuilder.builder;

public enum JoinType {
  JOIN("JOIN"),
  CROSS_JOIN("CROSS JOIN"),
  LEFT_OUTER_JOIN("LEFT OUTER JOIN"),
  NATURAL_JOIN("NATURAL JOIN"),
  NATURAL_LEFT_OUTER_JOIN("NATURAL LEFT OUTER JOIN");

  private final String sql;

  JoinType(String sql) {
    this.sql = sql;
  }

  public final String toSQL() {
    return sql;
  }
}
