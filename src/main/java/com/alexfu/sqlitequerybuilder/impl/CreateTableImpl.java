package com.alexfu.sqlitequerybuilder.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.alexfu.sqlitequerybuilder.Column;
import com.alexfu.sqlitequerybuilder.CreateTable;
import com.alexfu.sqlitequerybuilder.QueryBuilder;
import com.alexfu.sqlitequerybuilder.utils.SQLUtils;

/**
 * @author Steven Wu
 *
 */
public class CreateTableImpl extends QueryBuilder implements CreateTable {
	
	private final List<Column> definitions = new ArrayList<Column>();

	public CreateTableImpl(String table) {
		getBuilder().setLength(0);
		getBuilder().append("CREATE TABLE ").append(table).append("(");
	}

	@Override
	public CreateTable column(Column column) {
		Objects.requireNonNull(column, "A non-null column is required.");
		definitions.add(column);	
		return this;
	}

	@Override
	public String toString() {
		for (Column column : definitions) {
			getBuilder().append(column.getName()).append(SQLUtils.space()).append(column.getType());
			if (column.getConstraint() != null) {
				getBuilder().append(SQLUtils.space()).append(column.getConstraint().getName());	
			}
			
			getBuilder().append(SQLUtils.comma());
		}
		
		stripComma();
		return getBuilder().append(")").toString();
	}

	private void stripComma() {
		if (getBuilder().lastIndexOf(",") != -1) {
			getBuilder().deleteCharAt(getBuilder().lastIndexOf(","));
		}
	}

}
