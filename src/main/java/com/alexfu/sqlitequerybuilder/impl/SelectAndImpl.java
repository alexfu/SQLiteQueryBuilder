package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectAnd;
import com.alexfu.sqlitequerybuilder.SelectLimit;

public class SelectAndImpl extends QueryBuilder implements SelectAnd {
  public SelectAndImpl(String condition) {
    getBuilder().append("AND ").append(condition).append(" ");
  }

  @Override
  public SelectLimit limit(int limit) {
    return new SelectLimitImpl(limit);
  }

  @Override
  public SelectAnd and(String condition) {
    getBuilder().append("AND ").append(condition).append(" ");
    return this;
  }
}
