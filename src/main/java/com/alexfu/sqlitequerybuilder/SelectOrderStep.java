package com.alexfu.sqlitequerybuilder;

public interface SelectOrderStep {
  public SelectLimit limit(int limit);
  public SelectLimit limit(int limit, int offset);
}
