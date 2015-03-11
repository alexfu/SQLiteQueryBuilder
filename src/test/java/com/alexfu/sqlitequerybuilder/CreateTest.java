package com.alexfu.sqlitequerybuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreateTest {

	@Test
	public final void testCreateTable() {
		// Arrange 
		String[] names = {"column1", "column2"};
		ColumnType[] types = {ColumnType.INT, ColumnType.BIGINT};
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(names, types);
		
		// Assert
		assertEquals("Error: the actual query does not match the expected.", "CREATE TABLE myTable(column1 INT, column2 BIGINT)", query);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void testCreateTableWithException() {
		// Arrange
		String[] names = {"column3", "column4"};
		ColumnType[] types = {ColumnType.MEDIUMINT};
		
		// Act
		SQLiteQueryBuilder.createTable("myTable").column(names, types);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testCreateTableWithNoColumn() {
		// Arrange
		String[] names = {};
		ColumnType[] types = {ColumnType.MEDIUMINT};
		
		// Act
		SQLiteQueryBuilder.createTable("myTable").column(names, types);
	}
}
