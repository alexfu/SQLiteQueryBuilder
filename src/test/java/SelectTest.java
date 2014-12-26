import com.alexfu.sqlitequerybuilder.SQLiteQueryBuilder;

import static org.junit.Assert.assertEquals;

public class SelectTest {
  @org.junit.Test
  public void singleColumnSelectTest() {
    String query = SQLiteQueryBuilder
        .select("column")
        .from("mytable")
        .toString();

    assertEquals(query, "SELECT `column` FROM `mytable`");
  }

  @org.junit.Test
  public void multiColumnSelectTest() {
    String query = SQLiteQueryBuilder.
        select("column1", "column2", "column3")
        .from("mytable")
        .toString();

    assertEquals(query, "SELECT `column1`,`column2`,`column3` FROM `mytable`");
  }

  @org.junit.Test
  public void starColumnSelectTest() {
    String query = SQLiteQueryBuilder
        .select()
        .from("mytable")
        .toString();

    assertEquals(query, "SELECT * FROM `mytable`");
  }

  @org.junit.Test
  public void selectWhereTest() {
    String query = SQLiteQueryBuilder
        .select("column")
        .from("mytable")
        .where("id = 1")
        .toString();

    assertEquals(query, "SELECT `column` FROM `mytable` WHERE id = 1");
  }

  @org.junit.Test
  public void selectJoinTest() {
    String query = SQLiteQueryBuilder
        .select()
        .from("mytable")
        .join("secondtable")
        .on("mytable.id = secondtable.id")
        .where("id = 1")
        .toString();

    assertEquals(query, "SELECT * FROM `mytable` JOIN `secondtable` ON mytable.id = secondtable.id WHERE id = 1");
  }

  @org.junit.Test
  public void selectMultiJoinTest() {
    String query = SQLiteQueryBuilder
        .select()
        .from("mytable")
        .join("secondtable")
        .on("mytable.id = secondtable.id")
        .join("thirdtable")
        .on("secondtable.id = thirdtable.id")
        .where("id = 1")
        .toString();

    assertEquals(query, "SELECT * FROM `mytable` JOIN `secondtable` ON mytable.id = secondtable.id " +
        "JOIN `thirdtable` ON secondtable.id = thirdtable.id WHERE id = 1");
  }  

  @org.junit.Test
  public void selectAndTest() {
    String query = SQLiteQueryBuilder
        .select()
        .from("mytable")
        .where("id = 1")
        .and("color = 'red'")
        .toString();

    assertEquals(query, "SELECT * FROM `mytable` WHERE id = 1 AND color = 'red'");
  }

  @org.junit.Test
  public void selectLimitTest() {
    String query = SQLiteQueryBuilder
        .select()
        .from("mytable")
        .where("id = 1")
        .limit(5)
        .toString();

    assertEquals(query, "SELECT * FROM `mytable` WHERE id = 1 LIMIT 5");
  }
}
