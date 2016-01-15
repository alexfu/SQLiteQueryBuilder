package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import com.alexfu.sqlitequerybuilder.utils.DateUtils;
import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class InsertTest {
  @Test
  public void simple() {
    Calendar timestamp = Calendar.getInstance();
    String sql = SQLiteQueryBuilder.insert()
      .into("people")
      .columns("id", "name", "timestamp")
      .values(1, "John", Calendar.getInstance())
      .build();

    String iso8601 = DateUtils.iso8601().format(timestamp.getTime());
    String result = "INSERT INTO people (id,name,timestamp) values (1,'John','" + iso8601 + "')";
    assertThat(sql).isEqualTo(result);
  }
}
