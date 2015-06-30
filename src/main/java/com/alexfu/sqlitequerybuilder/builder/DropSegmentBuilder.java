package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.DropType;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

/**
 * @author Steven Wu
 */
public class DropSegmentBuilder extends SegmentBuilder {

  private boolean ifExists;
  private DropType type;
  private String name;

  private DropSegmentBuilder(DropType type, String name) {
    this.type = type;
    this.name = name;
  }

  public DropSegmentBuilder() {
  }

  public DropSegmentBuilder table(String table) {
    return new DropSegmentBuilder(DropType.TABLE, table);
  }

  public DropSegmentBuilder view(String view) {
    return new DropSegmentBuilder(DropType.VIEW, view);
  }

  public DropSegmentBuilder index(String index) {
    return new DropSegmentBuilder(DropType.INDEX, index);
  }

  public DropSegmentBuilder trigger(String trigger) {
    return new DropSegmentBuilder(DropType.TRIGGER, trigger);
  }

  public DropSegmentBuilder ifExists() {
    ifExists = true;
    return this;
  }

  @Override
  public String build() {
    return StringUtils.join(" ", "DROP", type, (ifExists ? "IF EXISTS" : ""), name);
  }
  
}
