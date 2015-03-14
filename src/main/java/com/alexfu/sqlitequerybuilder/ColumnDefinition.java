package com.alexfu.sqlitequerybuilder;

import java.util.Objects;

public class ColumnDefinition {

	private final String name;
	private final ColumnType type;
	private final Integer length;
	private final Integer decimal;
	private final Boolean isNullable;
	private final Boolean isPrimaryKey;
	private final String defaultValue;
	
	private ColumnDefinition(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.length = builder.length;
		this.decimal = builder.decimal;
		this.isNullable = builder.isNullable;
		this.isPrimaryKey = builder.isPrimaryKey;
		this.defaultValue = builder.defaultValue;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type
	 */
	public ColumnType getType() {
		return type;
	}

	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @return the decimal
	 */
	public Integer getDecimal() {
		return decimal;
	}

	/**
	 * @return the isNullable
	 */
	public Boolean isNullable() {
		return isNullable;
	}

	/**
	 * @return the isPrimaryKey
	 */
	public Boolean isPrimaryKey() {
		return isPrimaryKey;
	}

	public String getDefaultValue() {
		return defaultValue;
	}
	
	public static class Builder {
		
		private final String name;
		private final ColumnType type;
		private Integer length;
		private Integer decimal;
		private Boolean isNullable;
		private Boolean isPrimaryKey;
		private String defaultValue;
		
		public Builder(String name, ColumnType type) {
			Objects.requireNonNull(name, "Column name cannot be null.");
			Objects.requireNonNull(type, "Column type cannot be null.");
			
			this.name = name;
			this.type = type;
		}
		
		public Builder length(Integer length) {	
			this.length = length;
			return this;
		}
		
		public Builder decimal(Integer decimal) {
			this.decimal = decimal;
			return this;
		}
		
		public Builder isNullable(Boolean isNullable) {
			this.isNullable = isNullable;
			return this;
		}
		
		public Builder isPrimaryKey(Boolean isPrimaryKey) {
			this.isPrimaryKey = isPrimaryKey;
			return this;
		}
		
		public Builder defaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
			return this;
		}
		
		public ColumnDefinition build() {
			return new ColumnDefinition(this);
		}
	}
}	
