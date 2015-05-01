package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Column;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Wu
 */
public class CreateTableBuilder extends SegmentBuilder {

  private final List<Column> definitions = new ArrayList<Column>();
  private String table;
  private boolean ifNotExists;

  public CreateTableBuilder(String table) {
  	this.table = table;
	}

  public CreateTableBuilder column(Column column) {
    if (column == null) {
      throw new IllegalArgumentException("A non-null column is required.");
    }
    definitions.add(column);
    return this;
  }

	public CreateTableBuilder ifNotExists() {
		ifNotExists = true;
		return this;
	}
	
  @Override
  public String build() {
    String statement = "CREATE TABLE" + (ifNotExists ? " IF NOT EXISTS" : "");
    return StringUtils.join(" ", statement, table + "(" + StringUtils.join(",", definitions.toArray()) + ")");
  }
}
