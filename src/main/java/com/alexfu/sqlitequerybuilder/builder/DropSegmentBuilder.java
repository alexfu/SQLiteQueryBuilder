package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.DropType;

/**
 * @author Steven Wu
 */
public class DropSegmentBuilder extends SegmentBuilder {

  public DropBuilder table(String table) {
    return new DropBuilder(DropType.TABLE, table);
  }

  public DropBuilder view(String view) {
    return new DropBuilder(DropType.VIEW, view);
  }

  public DropBuilder index(String index) {
    return new DropBuilder(DropType.INDEX, index);
  }

  public DropBuilder trigger(String trigger) {
    return new DropBuilder(DropType.TRIGGER, trigger);
  }

  @Override
  public String build() {
    // TODO Auto-generated method stub
    return null;
  }

}
