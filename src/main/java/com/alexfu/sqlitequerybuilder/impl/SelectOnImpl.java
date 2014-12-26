package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectOn;
import com.alexfu.sqlitequerybuilder.SelectWhere;

public class SelectOnImpl extends QueryBuilder implements SelectOn {
  public SelectOnImpl(String condition) {
    getBuilder().append("ON ").append(condition).append(" ");
  }

  @Override
  public SelectWhere where(String condition) {
    return new SelectWhereImpl(condition);
  }
}
