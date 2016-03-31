package com.alexfu.sqlitequerybuilder.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexfu on 3/30/16.
 */
public class ConnectionUtils {
  public static List<String> tables(Connection connection) throws SQLException {
    List<String> tables = new ArrayList<String>();

    DatabaseMetaData metaData = connection.getMetaData();
    ResultSet rs = metaData.getTables(null, null, "%", null);
    while (rs.next()) {
      tables.add(rs.getString("TABLE_NAME"));
    }

    return tables;
  }

  public static List<String> columns(Connection connection, String table) throws SQLException {
    List<String> columns = new ArrayList<String>();

    DatabaseMetaData metaData = connection.getMetaData();
    ResultSet rs = metaData.getColumns(null, null, table, null);
    while (rs.next()) {
      columns.add(rs.getString("COLUMN_NAME"));
    }

    return columns;
  }
}
