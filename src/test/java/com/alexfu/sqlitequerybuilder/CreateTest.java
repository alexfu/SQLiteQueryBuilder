package com.alexfu.sqlitequerybuilder;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CreateTest {

	@Test
	@Ignore
	public final void testCreateTable() {
		// Arrange 
		String[] names = {"column1", "column2"};
		ColumnType[] types = {ColumnType.INT, ColumnType.BIGINT};
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(names, types);
		
		// Assert
		assertEquals("Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 INT, column2 BIGINT)", query);
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
	
	@Test
	public final void testCreateTableWithLength() {
		// Arrange
		ColumnDefinition definition = new ColumnDefinition.Builder("column1", ColumnType.INT).length(1).build();
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(definition).end().toString();
		
		// Assert
		assertEquals("Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 INT(1))", query);
	}	
	
	@Test
	public final void testCreateTableWithLengthAndDecimal() {
		// Arrange
		ColumnDefinition definition = new ColumnDefinition.Builder("column1", ColumnType.FLOAT).length(10).decimal(2).build();
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(definition).end().toString();
		
		// Assert
		assertEquals("Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 FLOAT(10,2))", query);
	}
	
	@Test
	public final void testCreateTableWithAllDefinitions() {
		// Arrange
		ColumnDefinition definition = new ColumnDefinition.Builder("column1",
				ColumnType.DECIMAL).length(5).decimal(2).isNullable(false)
				.isPrimaryKey(true).defaultValue("10.05").build();
		
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(definition).end().toString();
		
		// Assert
		assertEquals(
				"Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 DECIMAL(5,2) NOT NULL DEFAULT 10.05 PRIMARY KEY)",
				query);
	}
	
	@Test
	public final void testCreateTableWithMultipleColumns() {
		// Arrange
		ColumnDefinition definition1 = new ColumnDefinition.Builder("column1",
				ColumnType.DECIMAL).length(5).decimal(2).isNullable(false)
				.isPrimaryKey(true).defaultValue("10.05").build(); 
		ColumnDefinition definition2 = new ColumnDefinition.Builder("column2", ColumnType.INT).build();
			
		// Act
		String query = SQLiteQueryBuilder.createTable("myTable").column(definition1).column(definition2).end().toString();
		
		// Assert
		assertEquals(
				"Error: the actual query does not match the expected.",
				"CREATE TABLE myTable(column1 DECIMAL(5,2) NOT NULL DEFAULT 10.05 PRIMARY KEY,column2 INT)",
				query);
	}
	
}
