package com.alexfu.sqlitequerybuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectTest {
  @Test
  public void singleColumnSelectTest() {
    String query = SQLiteQueryBuilder
        .select("column")
        .from("mytable")
        .build();

    assertEquals(query, "SELECT column FROM mytable");
  }

  @Test
  public void multiColumnSelectTest() {
    String query = SQLiteQueryBuilder.
        select("column1", "column2", "column3")
        .from("mytable")
        .build();

    assertEquals(query, "SELECT column1,column2,column3 FROM mytable");
  }

  @Test
  public void starColumnSelectTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .build();

    assertEquals(query, "SELECT * FROM mytable");
  }

  @Test
  public void selectWhereTest() {
    String query = SQLiteQueryBuilder
        .select("column")
        .from("mytable")
        .where("id = 1")
        .build();

    assertEquals(query, "SELECT column FROM mytable WHERE id = 1");
  }

  @Test
  public void selectJoinTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .join("secondtable")
        .on("mytable.id = secondtable.id")
        .where("id = 1")
        .build();

    assertEquals(query, "SELECT * FROM mytable JOIN secondtable ON mytable.id = secondtable.id WHERE id = 1");
  }

  @Test
  public void selectMultiJoinTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .join("secondtable")
        .on("mytable.id = secondtable.id")
        .join("thirdtable")
        .on("secondtable.id = thirdtable.id")
        .where("id = 1")
        .build();

    assertEquals(query, "SELECT * FROM mytable JOIN secondtable ON mytable.id = secondtable.id " +
        "JOIN thirdtable ON secondtable.id = thirdtable.id WHERE id = 1");
  }

  @Test
  public void selectAndTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .where("id = 1")
        .and("color = 'red'")
        .build();

    assertEquals(query, "SELECT * FROM mytable WHERE id = 1 AND color = 'red'");
  }

  @Test
  public void selectLimitTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .where("id = 1")
        .limit(5)
        .build();

    assertEquals(query, "SELECT * FROM mytable WHERE id = 1 LIMIT 5");
  }

  @Test
  public void selectOrderByTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .orderBy("rank")
        .build();

    assertEquals(query, "SELECT * FROM mytable ORDER BY rank");
  }

  @Test
  public void selectGroupByTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .groupBy("rank")
        .build();

    assertEquals(query, "SELECT * FROM mytable GROUP BY rank");
  }

  @Test
  public void selectOrderByAdvancedTest() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .where("id = 1")
        .orderBy("rank")
        .desc()
        .limit(10)
        .offset(5)
        .build();

    assertEquals(query, "SELECT * FROM mytable WHERE id = 1 ORDER BY rank DESC LIMIT 10 OFFSET 5");
  }

  @Test
  public void selectDistinctTest() {
    String query = SQLiteQueryBuilder
        .select(SelectType.DISTINCT("one", "two", "three"))
        .from("mytable")
        .build();

    assertEquals(query, "SELECT DISTINCT one,two,three FROM mytable");
  }

  @Test
  public void selectAllTest() {
    String query = SQLiteQueryBuilder
        .select(SelectType.ALL("one", "two", "three"))
        .from("mytable")
        .build();

    assertEquals(query, "SELECT ALL one,two,three FROM mytable");
  }

  @Test
  public void selectOrderByAsc() {
    String query = SQLiteQueryBuilder
        .select("*")
        .from("mytable")
        .orderBy("age")
        .asc()
        .build();

    assertEquals(query, "SELECT * FROM mytable ORDER BY age ASC");
  }
}
