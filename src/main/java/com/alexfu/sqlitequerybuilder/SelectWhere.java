package com.alexfu.sqlitequerybuilder;

public interface SelectWhere {
  public SelectAnd and(String condition);
  public SelectLimit limit(int limit);
}
