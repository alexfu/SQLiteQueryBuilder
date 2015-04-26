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
  private String command = "CREATE TABLE";

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
	public CreateTable ifNotExists() {
		command = StringUtils.join(" ", command, "IF NOT EXISTS");
		return this;
	}
	
  @Override
  public String build() {
		return StringUtils.join(" ", command, table + "(" + StringUtils.join(",", definitions.toArray()) + ")");
  }
}
