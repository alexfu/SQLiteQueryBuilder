package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteTest extends SQLiteTest {

  @Override
  public void before() throws SQLException, ClassNotFoundException {
    super.before();

    // Seed database

    String createTable = "CREATE TABLE my_table (id INTEGER)";
    statement.execute(createTable);

    for (int i = 1; i <= 10; i++) {
      String sql = "INSERT INTO my_table (id) VALUES (" + i + ")";
      statement.execute(sql);
    }
  }

  @Test
  public void testDeleteAll() throws SQLException {
    // Arrange
    String sql = SQLiteQueryBuilder
      .delete()
      .from("my_table")
      .build();

    // Act
    statement.execute(sql);

    // Assert
    ResultSet set = statement.executeQuery("SELECT * FROM my_table");
    int rowCount = 0;
    while (set.next()) { rowCount++; }
    assertThat(rowCount).isEqualTo(0);
  }

  @Test
  public void testDeleteWhere() throws SQLException {
    // Arrange
    String sql = SQLiteQueryBuilder
      .delete()
      .from("my_table")
      .where("id = 1")
      .build();

    // Act
    statement.execute(sql);

    // Assert
    ResultSet set = statement.executeQuery("SELECT * FROM my_table WHERE id = 1");
    int rowCount = 0;
    while (set.next()) { rowCount++; }
    assertThat(rowCount).isEqualTo(0);
  }
}
