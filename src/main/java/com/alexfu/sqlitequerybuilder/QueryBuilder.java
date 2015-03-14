package com.alexfu.sqlitequerybuilder;

public abstract class QueryBuilder {
  private static final StringBuilder BUILDER = new StringBuilder();

  public StringBuilder getBuilder() {
    return BUILDER;
  }

  @Override
  public String toString() {
    return BUILDER.toString().trim();
  }
}
