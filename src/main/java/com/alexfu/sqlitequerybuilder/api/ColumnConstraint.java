package com.alexfu.sqlitequerybuilder.api;

public enum ColumnConstraint {

  PRIMARY_KEY("PRIMARY KEY"),
  PRIMARY_KEY_AUTO_INCREMENT("PRIMARY KEY AUTOINCREMENT"),
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
