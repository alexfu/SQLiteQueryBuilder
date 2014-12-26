package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectFrom;
import com.alexfu.sqlitequerybuilder.SelectJoin;
import com.alexfu.sqlitequerybuilder.SelectWhere;

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
}
