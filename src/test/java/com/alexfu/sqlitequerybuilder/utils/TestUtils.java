package com.alexfu.sqlitequerybuilder.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alexfu on 3/31/16.
 */
public class TestUtils {
  public static void assertTablesExists(Connection connection, String... tables)
    throws SQLException {

    List<String> tableList = ConnectionUtils.tables(connection);
    assertThat(tableList).contains(tables);
  }

  public static void assertOnlyTablesExists(Connection connection, String... tables)
    throws SQLException {

    List<String> tableList = ConnectionUtils.tables(connection);
    assertThat(tableList).containsOnly(tables);
  }

  public static void assertOnlyColumnsExists(Connection connection, String table, String... columns)
    throws SQLException {

    List<String> columnList = ConnectionUtils.columns(connection, table);
    assertThat(columnList).containsOnly(columns);
  }
}
