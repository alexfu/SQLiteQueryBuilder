package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Column;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateTableSegmentBuilder extends SegmentBuilder {

  private boolean isTemp;
  private boolean ifNotExists;
  private String name;
  private final List<Column> definitions = new ArrayList<Column>();

  public CreateTableSegmentBuilder() {}

  public CreateTableSegmentBuilder temp() {
    isTemp = true;
    return this;
  }

  public CreateTableSegmentBuilder ifNotExists() {
    ifNotExists = true;
    return this;
  }

  public CreateTableSegmentBuilder column(Column column) {
    if (column == null) {
      throw new IllegalArgumentException("A non-null column is required.");
    }
    definitions.add(column);
    return this;
  }

  public CreateTableSegmentBuilder table(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Table name can not be empty.");
    }
    this.name = name;
    return this;
  }

  @Override
  public String build() {
    String statement = "CREATE " + (isTemp ? "TEMP " : "") + "TABLE" + (ifNotExists ? " IF NOT EXISTS" : "");
    return StringUtils.join(" ", statement, name + "(" + StringUtils.join(",", definitions.toArray()) + ")");
  }

}
