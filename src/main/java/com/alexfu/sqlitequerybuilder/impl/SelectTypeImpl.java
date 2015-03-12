package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.SelectFrom;
import com.alexfu.sqlitequerybuilder.SelectType;

public class SelectTypeImpl extends QueryBuilder implements SelectType {
  
  public enum Type {
    DISTINCT, ALL
  }
  
  public SelectTypeImpl(Type type, String... columns) {
    getBuilder().append(type.toString()).append(" ");
    for (int i = 0; i < columns.length; i++) {
      getBuilder().append(columns[i]);
      if (i < columns.length-1) {
        getBuilder().append(",");
      } else {
        getBuilder().append(" ");
      }
    }
  }

  @Override
  public SelectFrom from(String table) {
    return new SelectFromImpl(table);
  }
}
