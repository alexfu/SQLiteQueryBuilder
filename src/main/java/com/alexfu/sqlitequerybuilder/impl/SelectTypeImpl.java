package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectFrom;
import com.alexfu.sqlitequerybuilder.SelectType;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectTypeImpl extends QueryBuilder implements SelectType {
  
  public enum Type {
    DISTINCT, ALL
  }
  
  public SelectTypeImpl(Type type, String... columns) {
    getBuilder().append(type.toString()).append(" ")
        .append(ArrayUtils.join(columns, ","))
        .append(" ");
  }

  @Override
  public SelectFrom from(String table) {
    return new SelectFromImpl(table);
  }
}
