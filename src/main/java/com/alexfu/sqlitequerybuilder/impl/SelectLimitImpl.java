package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectLimit;

public class SelectLimitImpl extends QueryBuilder implements SelectLimit {
  public SelectLimitImpl(int limit) {
    getBuilder().append("LIMIT ").append(limit).append(" ");
  }
}
