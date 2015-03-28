package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class Column implements SegmentBuilder {

	private final String name;
	private final ColumnType type;
	private final ColumnConstraint constraint;
	
	/**
	 * @param name
	 * @param type
	 * @param constraint
	 */
	public Column(String name, ColumnType type, ColumnConstraint constraint) {
		this.name = name;
		this.type = type;
		this.constraint = constraint;
	}
	
	/**
	 * @param name
	 * @param type
	 */
	public Column(String name, ColumnType type) {
		this.name = name;
		this.type = type;
		this.constraint = null;
	}

	@Override
	public String build() {
		String result = StringUtils.join(" ", name, type.toString());
		if (constraint != null) {
			result = StringUtils.join(" ", result, constraint.toString());
		}
		return result;
	}

	@Override
	public String toString() {
		return build();
	}
}
