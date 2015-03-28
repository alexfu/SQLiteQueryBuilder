package com.alexfu.sqlitequerybuilder;

public enum ColumnConstraint {

  PRIMARY_KEY("PRIMARY KEY"),
  UNIQUE("UNIQUE"),
  CHECK("CHECK"),
  FOREIGN_KEY("FOREIGN KEY"),
  NOT_NULL("NOT NULL");

  private String name;

  private ColumnConstraint(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
