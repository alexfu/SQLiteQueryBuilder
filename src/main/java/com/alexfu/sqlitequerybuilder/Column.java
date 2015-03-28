package com.alexfu.sqlitequerybuilder;

public class Column {

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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the type
	 */
	public ColumnType getType() {
		return type;
	}
	/**
	 * @return the constraint
	 */
	public ColumnConstraint getConstraint() {
		return constraint;
	}
	
}
