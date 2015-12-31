package com.alexfu.sqlitequerybuilder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.alexfu.sqlitequerybuilder.api.Column;
import com.alexfu.sqlitequerybuilder.api.ColumnConstraint;
import com.alexfu.sqlitequerybuilder.api.ColumnType;
import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;

public class CreateTableTest {

  @Test
  public final void testCreateTableWithOneColumn() {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    // Act
    String query = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .toString();

    // Assert
    assertThat(query).isEqualTo("CREATE TABLE myTable(column1 INTEGER PRIMARY KEY)");
  }

  @Test
  public final void testCreateTableWithMultipleColumns() {
    // Arrange
    Column column1 = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);
    Column column2 = new Column("column2", ColumnType.TEXT);
    Column column3 = new Column("column3", ColumnType.TEXT, ColumnConstraint.NOT_NULL);

    // Act
    String query = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column1)
      .column(column2)
      .column(column3)
      .toString();

    // Assert
    assertThat(query).isEqualTo("CREATE TABLE myTable(column1 INTEGER PRIMARY KEY,column2 TEXT,"
      + "column3 TEXT NOT NULL)");
  }

  @Test
  public final void testCreateTableWithDefaultColumnValue() {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY, "0");

    // Act
    String query = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .toString();

    // Assert
    assertThat(query).isEqualTo("CREATE TABLE myTable(column1 INTEGER PRIMARY KEY DEFAULT 0)");
  }

  @Test(expected = IllegalArgumentException.class)
  public final void passNullColumnShouldThrowExeption() {
    // Act
    SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(null)
      .toString();
  }

  @Test
  public final void createTableIfNotExists() {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    // Act
    String query = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .ifNotExists()
      .column(column)
      .toString();

    // Assert
    assertThat(query).isEqualTo("CREATE TABLE IF NOT EXISTS myTable(column1 INTEGER PRIMARY KEY)");
  }

  @Test
  public final void createTempTable() {
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    String query = SQLiteQueryBuilder
      .create()
      .temp()
      .table("myTable")
      .column(column)
      .build();

    assertThat(query).isEqualTo("CREATE TEMP TABLE myTable(column1 INTEGER PRIMARY KEY)");
  }

  @Test
  public final void createTempTableIfNotExists() {
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    String query = SQLiteQueryBuilder
      .create()
      .temp()
      .table("myTable")
      .ifNotExists()
      .column(column)
      .build();

    assertThat(query).isEqualTo("CREATE TEMP TABLE IF NOT EXISTS myTable(column1 INTEGER "
      + "PRIMARY KEY)");
  }

  @Test(expected = IllegalArgumentException.class)
  public final void emptyTableName() {
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    SQLiteQueryBuilder
      .create()
      .table("")
      .column(column)
      .build();
  }

  @Test
  public final void createTablePrimaryKeyAutoIncrement() {
    Column column = new Column("column1", ColumnType.INTEGER,
      ColumnConstraint.PRIMARY_KEY_AUTO_INCREMENT);

    String query = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .build();

    assertThat(query).isEqualTo("CREATE TABLE myTable(column1 INTEGER PRIMARY KEY AUTOINCREMENT)");
  }

}
