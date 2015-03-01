package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectGroupBy;

public class SelectGroupByImpl extends QueryBuilder implements SelectGroupBy {
  public SelectGroupByImpl(String field) {
    getBuilder().append("GROUP BY ").append(field).append(" ");
  }
}
