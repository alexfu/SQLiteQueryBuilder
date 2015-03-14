package com.alexfu.sqlitequerybuilder;

public abstract class QueryBuilder {
  private static final StringBuilder BUILDER = new StringBuilder();

  public StringBuilder getBuilder() {
    return BUILDER;
  }

  public StringBuilder addComma() {
	  return BUILDER.append(", ");
  }
  
  public StringBuilder addLeftParenthesis() {
	  return BUILDER.append("(");
  }
  
  public StringBuilder addRightParenthesis() {
	  return BUILDER.append(")");
  }
  
  public StringBuilder addSpace() {
	  return BUILDER.append(" ");
  }
  
  @Override
  public String toString() {
    return BUILDER.toString().trim();
  }
}
