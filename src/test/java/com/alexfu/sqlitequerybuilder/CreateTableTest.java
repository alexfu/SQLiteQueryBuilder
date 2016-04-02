package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.Column;
import com.alexfu.sqlitequerybuilder.api.ColumnConstraint;
import com.alexfu.sqlitequerybuilder.api.ColumnType;
import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import org.junit.Test;

import java.sql.SQLException;

import static com.alexfu.sqlitequerybuilder.utils.TestUtils.*;

public final class CreateTableTest extends SQLiteTest {

  @Test
  public final void testCreateTableWithOneColumn() throws SQLException {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    // Act
    String sql = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .toString();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1");
  }

  @Test
  public final void testCreateTableWithMultipleColumns() throws SQLException {
    // Arrange
    Column column1 = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);
    Column column2 = new Column("column2", ColumnType.TEXT);
    Column column3 = new Column("column3", ColumnType.TEXT, ColumnConstraint.NOT_NULL);

    // Act
    String sql = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column1)
      .column(column2)
      .column(column3)
      .toString();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1", "column2", "column3");
  }

  @Test
  public final void testCreateTableWithDefaultColumnValue() throws SQLException {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY, "0");

    // Act
    String sql = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .toString();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1");
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
  public final void createTableIfNotExists() throws SQLException {
    // Arrange
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    // Act
    String sql = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .ifNotExists()
      .column(column)
      .toString();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1");
  }

  @Test
  public final void createTempTable() throws SQLException {
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    String sql = SQLiteQueryBuilder
      .create()
      .temp()
      .table("myTable")
      .column(column)
      .build();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1");
  }

  @Test
  public final void createTempTableIfNotExists() throws SQLException {
    Column column = new Column("column1", ColumnType.INTEGER, ColumnConstraint.PRIMARY_KEY);

    String sql = SQLiteQueryBuilder
      .create()
      .temp()
      .table("myTable")
      .ifNotExists()
      .column(column)
      .build();

    statement.execute(sql);

    // Assert
    assertOnlyTablesExists(connection, "myTable");
    assertOnlyColumnsExists(connection, "myTable", "column1");
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
  public final void createTablePrimaryKeyAutoIncrement() throws SQLException {
    Column column = new Column("column1", ColumnType.INTEGER,
      ColumnConstraint.PRIMARY_KEY_AUTO_INCREMENT);

    String sql = SQLiteQueryBuilder
      .create()
      .table("myTable")
      .column(column)
      .build();

    statement.execute(sql);

    // Assert
    assertTablesExists(connection, "myTable", "sqlite_sequence");
    assertOnlyColumnsExists(connection, "myTable", "column1");
  }

}
