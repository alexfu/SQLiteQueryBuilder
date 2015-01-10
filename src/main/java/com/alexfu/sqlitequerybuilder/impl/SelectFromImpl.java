package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.*;

import static com.alexfu.sqlitequerybuilder.utils.SQLUtils.wrap;

public class SelectFromImpl extends QueryBuilder implements SelectFrom {

  public SelectFromImpl(String table) {
    getBuilder().append("FROM ").append(wrap(table)).append(" ");
  }

  @Override
  public SelectJoin join(String table) {
    return new SelectJoinImpl(table);
  }

  @Override
  public SelectWhere where(String condition) {
    return new SelectWhereImpl(condition);
  }

  public SelectOrderBy orderBy(String orderBy) {
    return new SelectOrderByImpl(orderBy);
  }

  public SelectGroupBy groupBy(String field) {
    return new SelectGroupByImpl(field);
  }
}
