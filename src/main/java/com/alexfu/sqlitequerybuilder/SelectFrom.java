package com.alexfu.sqlitequerybuilder;

public interface SelectFrom {
  public SelectWhere where(String condition);
  public SelectJoin join(String table);
}
