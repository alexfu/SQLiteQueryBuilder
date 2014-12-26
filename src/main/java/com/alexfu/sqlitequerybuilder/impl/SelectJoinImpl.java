package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectJoin;
import com.alexfu.sqlitequerybuilder.SelectOn;

import static com.alexfu.sqlitequerybuilder.utils.SQLUtils.wrap;

public class SelectJoinImpl extends QueryBuilder implements SelectJoin {
  public SelectJoinImpl(String table) {
    getBuilder().append("JOIN ").append(wrap(table)).append(" ");
  }

  @Override
  public SelectOn on(String condition) {
    return new SelectOnImpl(condition);
  }
}
