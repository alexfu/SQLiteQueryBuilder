package com.alexfu.sqlitequerybuilder;

public interface SelectAnd {
  public SelectLimit limit(int limit);
  public SelectAnd and(String condition);
  public SelectOrderBy orderBy(String orderBy);
  public SelectGroupBy groupBy(String field);
}
