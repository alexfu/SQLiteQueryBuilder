package com.alexfu.sqlitequerybuilder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;

public class DropTest {

  @Test
  public final void testDropView() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .view("myView")
      .ifExists()
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP VIEW IF EXISTS myView");
  }

  @Test
  public final void testDropViewNoIfExists() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .view("myView")
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP VIEW myView");
  }

  @Test
  public final void testDropIndex() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .index("myIndex")
      .ifExists()
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP INDEX IF EXISTS myIndex");
  }

  @Test
  public final void testDropIndexNoIfExists() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .index("myIndex")
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP INDEX myIndex");
  }

  @Test
  public final void testDropTrigger() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .trigger("myTrigger")
      .ifExists()
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP TRIGGER IF EXISTS myTrigger");
  }

  @Test
  public final void testDropTriggerNoIfExists() {
    // Arrange and Act
    String statement = SQLiteQueryBuilder
      .drop()
      .trigger("myTrigger")
      .toString();

    // Assert
    assertThat(statement).isEqualTo("DROP TRIGGER myTrigger");
  }
}
