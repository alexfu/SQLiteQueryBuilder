package com.alexfu.sqlitequerybuilder.builder;

/**
 * @author Steven Wu
 *
 */
public class DropBuilder extends SegmentBuilder {

	private enum Type {
		TABLE
	}
	
	private Type type;
	
	public DropTableBuilder table(String table) {
		this.type = Type.TABLE;
		return new DropTableBuilder(table);
	}

	@Override
	public String build() {
		// TODO Auto-generated method stub
		return null;
	}

}
