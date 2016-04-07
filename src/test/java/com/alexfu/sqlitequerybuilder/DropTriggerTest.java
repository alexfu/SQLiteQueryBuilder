package com.alexfu.sqlitequerybuilder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;

public final class DropTriggerTest {
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
