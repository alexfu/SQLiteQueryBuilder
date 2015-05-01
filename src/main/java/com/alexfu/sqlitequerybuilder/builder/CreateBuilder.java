package com.alexfu.sqlitequerybuilder.builder;

public class CreateBuilder extends SegmentBuilder {
  private enum Type {
    TABLE
  }

  private Type type;

  public CreateTableBuilder table(String table) {
    type = Type.TABLE;
    return new CreateTableBuilder(table);
  }

  @Override
  public String build() {
    return null;
  }
}
