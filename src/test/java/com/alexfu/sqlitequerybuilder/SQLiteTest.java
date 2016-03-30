package com.alexfu.sqlitequerybuilder;

import org.junit.After;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLiteTest {
  Connection connection;
  Statement statement;

  @Before
  public void before() throws SQLException, ClassNotFoundException {
    connection = DriverManager.getConnection("jdbc:sqlite::memory:");
    statement = connection.createStatement();
    statement.setQueryTimeout(10);
  }

  @After
  public void after() throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }
}
