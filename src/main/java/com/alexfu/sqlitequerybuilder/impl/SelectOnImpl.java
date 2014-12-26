package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectJoin;
import com.alexfu.sqlitequerybuilder.SelectOn;
import com.alexfu.sqlitequerybuilder.SelectWhere;

public class SelectOnImpl extends QueryBuilder implements SelectOn {
  public SelectOnImpl(String condition) {
    getBuilder().append("ON ").append(condition).append(" ");
  }

  public SelectWhere where(String condition) {
    return new SelectWhereImpl(condition);
  }

  public SelectJoin join(String table) {
    return new SelectJoinImpl(table);
  }
}
