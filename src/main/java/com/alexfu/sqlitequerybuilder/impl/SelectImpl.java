package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.Select;
import com.alexfu.sqlitequerybuilder.SelectFrom;
import com.alexfu.sqlitequerybuilder.SelectType;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

import static com.alexfu.sqlitequerybuilder.utils.SQLUtils.wrap;

public class SelectImpl extends QueryBuilder implements Select {

  public SelectImpl() {
    getBuilder().setLength(0);
    getBuilder().append("SELECT ");
  }

  public SelectImpl(String... fields) {
    getBuilder().setLength(0);
    getBuilder().append("SELECT ")
        .append(ArrayUtils.join(",", fields))
        .append(" ");
  }

  @Override
  public SelectFrom from(String table) {
    return new SelectFromImpl(table);
  }

  @Override
  public SelectType distinct(String... columns) {
    return new SelectTypeImpl(SelectTypeImpl.Type.DISTINCT, columns);
  }

  @Override
  public SelectType all(String... columns) {
    return new SelectTypeImpl(SelectTypeImpl.Type.ALL, columns);
  }
}
