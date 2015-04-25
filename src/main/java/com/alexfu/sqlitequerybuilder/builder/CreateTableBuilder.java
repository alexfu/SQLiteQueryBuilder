package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Column;
import com.alexfu.sqlitequerybuilder.api.CreateTable;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Wu
 */
public class CreateTableBuilder extends SegmentBuilder implements CreateTable {

  private final List<Column> definitions = new ArrayList<Column>();
  private String table;

  public CreateTableBuilder(String table) {
    this.table = table;
  }

  @Override
  public CreateTable column(Column column) {
    if (column == null) {
      throw new IllegalArgumentException("A non-null column is required.");
    }
    definitions.add(column);
    return this;
  }

  @Override
  public String build() {
    return StringUtils.join(" ", "CREATE TABLE", table + "(" + StringUtils.join(",", definitions.toArray()) + ")");
  }
}
