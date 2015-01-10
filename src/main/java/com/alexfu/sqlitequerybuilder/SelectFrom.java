package com.alexfu.sqlitequerybuilder;

public interface SelectFrom {
  public SelectWhere where(String condition);
  public SelectJoin join(String table);
  public SelectOrderBy orderBy(String orderBy);
  public SelectGroupBy groupBy(String field);
}
