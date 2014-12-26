package com.alexfu.sqlitequerybuilder;

public interface SelectOn {
  public SelectWhere where(String condition);
  public SelectJoin join(String table);
}
