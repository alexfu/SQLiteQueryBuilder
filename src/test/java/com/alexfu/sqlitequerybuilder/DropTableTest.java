package com.alexfu.sqlitequerybuilder;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.alexfu.sqlitequerybuilder.api.SQLiteQueryBuilder;

public class DropTableTest {

	@Test
	public final void testDropTable() {
		// Arrange and Act
		String statement = SQLiteQueryBuilder
				.drop()
				.table("myTable")
				.ifExists()
				.toString();
		
		// Assert
		assertThat(statement).isEqualTo("DROP TABLE IF EXISTS myTable");
	}

}
