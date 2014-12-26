package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectOrderBy;
import com.alexfu.sqlitequerybuilder.SelectOrderStep;

public class SelectOrderByImpl extends QueryBuilder implements SelectOrderBy {
  public SelectOrderByImpl(String orderBy) {
    getBuilder().append("ORDER BY ").append(orderBy).append(" ");
  }

  public SelectOrderStep asc() {
    getBuilder().append("ASC ");
    return new SelectOrderStepImpl();
  }

  public SelectOrderStep desc() {
    getBuilder().append("DESC ");
    return new SelectOrderStepImpl();
  }
}
