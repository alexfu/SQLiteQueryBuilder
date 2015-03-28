package com.alexfu.sqlitequerybuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreateTableTest {

	@Test
	public final void testCreateTableWithOneColumn() {
		// Arrange
		Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(column).toString();
		
		// Assert
		assertEquals("Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 INTEGER PRIMARY KEY)", query);
	}
	
	@Test
	public final void testCreateTableWithMultipleColumns() {
		// Arrange
		Column column1 = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);
		Column column2 = new Column("column2", ColumnType.TEXT);
		Column column3 = new Column("column3", ColumnType.TEXT, ColumnConstraint.NOT_NULL);
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(column1).column(column2).column(column3).toString();
		
		// Assert
		assertEquals(
				"Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 INTEGER PRIMARY KEY,column2 TEXT,column3 TEXT NOT NULL)", query);
	}
	
	@Test(expected = NullPointerException.class)
	public final void passNullColumnShouldThrowExeption() {
		// Act
		SQLiteQueryBuilder.createTable("myTable").column(null).toString();
	}
	
}
