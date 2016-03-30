package com.alexfu.sqlitequerybuilder.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
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
      tables.add(rs.getString(3));
    }

    return tables;
  }
}
