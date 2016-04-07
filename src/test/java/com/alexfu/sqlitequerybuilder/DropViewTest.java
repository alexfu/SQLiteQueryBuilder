package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class DropViewTest {
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
}
