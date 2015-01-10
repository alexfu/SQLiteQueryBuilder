package com.alexfu.sqlitequerybuilder;

public class SelectGroupByImpl extends QueryBuilder implements SelectGroupBy {
  public SelectGroupByImpl(String field) {
    getBuilder().append("GROUP BY ").append(field).append(" ");
  }
}
