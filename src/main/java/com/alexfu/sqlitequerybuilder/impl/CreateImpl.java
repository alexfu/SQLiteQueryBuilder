package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.ColumnDefinition;
import com.alexfu.sqlitequerybuilder.ColumnType;
import com.alexfu.sqlitequerybuilder.Create;
import com.alexfu.sqlitequerybuilder.QueryBuilder;

/**
 * @author Steven Wu
 *
 */
public class CreateImpl extends QueryBuilder implements Create {

	/**
	 * 
	 */
	public CreateImpl(String table) {
		getBuilder().setLength(0);
		getBuilder().append("CREATE TABLE ").append(table).append("(");
	}

	@Override
	public String column(String[] names, ColumnType[] types) {
		if (names.length == 0 || types.length == 0) {
			throw new IllegalArgumentException("At least one column should be defined.");
		}
		
		if (names.length != types.length) {
			throw new IllegalArgumentException("The number of column names is not equal to the number of column types.");
		}
		
		getBuilder().append("(");
		for (int i = 0; i < names.length; i++) {
			getBuilder().append(names[i]).append(" ").append(types[i]);
			if (i < names.length - 1) {
				getBuilder().append(",");
			}
		}
		getBuilder().append(")");
		return getBuilder().toString();
	}

	@Override
	public Create column(ColumnDefinition definition) {
		getBuilder().append(definition.getName()).append(" ").append(definition.getType());
		
		if (definition.getLength() != null && definition.getDecimal() != null) {
			getBuilder().append("(").append(definition.getLength()).append(",").append(definition.getDecimal()).append(")");
			addExtraDefinition(definition);
		} else if (definition.getLength() != null) {
			getBuilder().append("(").append(definition.getLength()).append(")");	
			addExtraDefinition(definition);
		}
		
		getBuilder().append(",");
		return this;
	}

	private void addExtraDefinition(ColumnDefinition definition) {
		if (definition.isNullable() != null && !definition.isNullable()) {
			getBuilder().append(" ").append("NOT NULL");
		} 
		
		if (definition.getDefaultValue() != null) {
			getBuilder().append(" ").append("DEFAULT").append(" ").append(definition.getDefaultValue());
		} 
		
		if (definition.isPrimaryKey() != null && definition.isPrimaryKey()) {
			getBuilder().append(" ").append("PRIMARY KEY");
		}
	}

	@Override
	public Create end() {
		int indexOf = getBuilder().lastIndexOf(",");
		if (indexOf != -1) {
			getBuilder().deleteCharAt(indexOf);
		}
		
		getBuilder().append(")");
		return this;
	}

}
