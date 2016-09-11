package com.alexfu.sqlitequerybuilder.api;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class ForeignKeyConstraint implements Builder {

  private String parentTable;
  private String parentKey;
  private String childKey;

  public ForeignKeyConstraint(String childKey, String parentTable, String parentKey) {
    this.parentTable = parentTable;
    this.parentKey = parentKey;
    this.childKey = childKey;
  }

  @Override
  public String toString() {
    return build();
  }

  @Override
  public String build() {
    return StringUtils.join("", "FOREIGN KEY", "(", childKey, ") ",
      "REFERENCES ", parentTable, "(", parentKey, ")");
  }
}
