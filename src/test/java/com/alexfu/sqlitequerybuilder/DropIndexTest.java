package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class DropIndexTest {
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
}
