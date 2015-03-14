package com.alexfu.sqlitequerybuilder;

/**
 * @author Steven Wu
 *
 */
public interface Create {
	
	public String column(String[] names, ColumnType[] types);
	
	public Create column(ColumnDefinition definition);
	
	public Create end();
}
