/**
 * 
 */
package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.StringUtils;

/**
 * @author Steven Wu
 *
 */
public class DropTableBuilder extends SegmentBuilder {

	private String table;
	private boolean ifExists;
	
	public DropTableBuilder(String table) {
		this.table = table;
	}
	
	public DropTableBuilder ifExists() {
		ifExists = true;
		return this;
	}
	
	
	@Override
	public String build() {
		String statement = "DROP TABLE " + (ifExists ? "IF EXISTS" : "");
		return StringUtils.join(" ", statement, table);
	}
}
