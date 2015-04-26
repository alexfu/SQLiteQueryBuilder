package com.alexfu.sqlitequerybuilder.api;

/**
 * @author Steven Wu
 */
public interface CreateTable {

  public CreateTable column(Column column);
  
  public CreateTable ifNotExists();
}
