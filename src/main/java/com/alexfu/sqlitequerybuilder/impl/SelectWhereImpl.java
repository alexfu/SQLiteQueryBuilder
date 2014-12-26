package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectAnd;
import com.alexfu.sqlitequerybuilder.SelectLimit;
import com.alexfu.sqlitequerybuilder.SelectWhere;

public class SelectWhereImpl extends QueryBuilder implements SelectWhere {
  public SelectWhereImpl(String condition) {
    getBuilder().append("WHERE ").append(condition).append(" ");
  }

  @Override
  public SelectAnd and(String column) {
    return new SelectAndImpl(column);
  }

  @Override
  public SelectLimit limit(int limit) {
    return new SelectLimitImpl(limit);
  }
}
