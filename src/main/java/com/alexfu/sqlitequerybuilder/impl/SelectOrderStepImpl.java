package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectLimit;
import com.alexfu.sqlitequerybuilder.SelectOrderStep;

public class SelectOrderStepImpl extends QueryBuilder implements SelectOrderStep {
  public SelectLimit limit(int limit) {
    return new SelectLimitImpl(limit);
  }

  public SelectLimit limit(int limit, int offset) {
    return new SelectLimitImpl(limit, offset);
  }
}
