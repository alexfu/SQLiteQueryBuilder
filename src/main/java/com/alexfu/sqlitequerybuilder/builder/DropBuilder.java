package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.DropType;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;


/**
 * @author Steven Wu
 *
 */
public class DropBuilder extends SegmentBuilder {

	private boolean ifExists;
	private DropType type;
	private String name;

	public DropBuilder(DropType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public DropBuilder ifExists() {
		ifExists = true;
		return this;
	}

	@Override
	public String build() {
		return StringUtils.join(" ", "DROP", type, (ifExists ? "IF EXISTS" : ""), name);
	}
}
