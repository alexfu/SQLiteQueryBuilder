package com.alexfu.sqlitequerybuilder;

import com.alexfu.sqlitequerybuilder.impl.CreateTableImpl;
import com.alexfu.sqlitequerybuilder.impl.SelectImpl;

public class SQLiteQueryBuilder {
	public static Select select(String... fields) {
		return new SelectImpl(fields);
	}

	public static Select select() {
		return new SelectImpl();
	}

	public static CreateTable createTable(String name) {
		return new CreateTableImpl(name);
	}
}
