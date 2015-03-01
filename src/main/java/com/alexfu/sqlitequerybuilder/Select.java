package com.alexfu.sqlitequerybuilder;

public interface Select {
  public SelectFrom from(String table);
  public SelectType distinct(String...columns);
  public SelectType all(String...columns);
}
