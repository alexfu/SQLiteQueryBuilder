package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import com.alexfu.sqlitequerybuilder.utils.DateUtils;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public final class InsertTest extends SQLiteTest {

  @Override
  public void before() throws SQLException, ClassNotFoundException {
    super.before();

    // Seed database
    String sql = "CREATE TABLE people (id INTEGER, name TEXT, timestamp TEXT)";
    statement.execute(sql);
  }

  @Test
  public void insertWithGoodValues() throws SQLException {
    // Arrange
    Calendar timestamp = Calendar.getInstance();
    String sql = SQLiteQueryBuilder.insert()
      .into("people")
      .columns("id", "name", "timestamp")
      .values(1, "John", timestamp)
      .build();

    // Act
    statement.execute(sql);

    // Assert
    ResultSet set = statement.executeQuery("SELECT * FROM people");
    set.next();
    assertThat(set.getInt("id")).isEqualTo(1);
    assertThat(set.getString("name")).isEqualTo("John");

    String date = DateUtils.iso8601().format(timestamp.getTime());
    assertThat(set.getString("timestamp")).isEqualTo(date);
  }

  @Test(expected = IllegalArgumentException.class)
  public void insertWithNullColumns() {
    SQLiteQueryBuilder.insert()
      .into("people")
      .columns(null)
      .values(1, "John", Calendar.getInstance())
      .build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void insertWithNullValues() {
    SQLiteQueryBuilder.insert()
      .into("people")
      .columns("id", "name", "timestamp")
      .values(null)
      .build();
  }
}
