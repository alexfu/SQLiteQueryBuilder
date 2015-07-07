package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.ObjectType;
import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

/**
 * @author Steven Wu
 */
public class DropSegmentBuilder extends SegmentBuilder {

  private boolean ifExists;
  private ObjectType type;
  private String name;

  private DropSegmentBuilder(ObjectType type, String name) {
    this.type = type;
    this.name = name;
  }

  public DropSegmentBuilder() {
  }

  public DropSegmentBuilder table(String table) {
    Preconditions.checkNotNull(table, "Table name cannot be null");
    return new DropSegmentBuilder(ObjectType.TABLE, table);
  }

  public DropSegmentBuilder view(String view) {
    Preconditions.checkNotNull(view, "View name cannot be null");
    return new DropSegmentBuilder(ObjectType.VIEW, view);
  }

  public DropSegmentBuilder index(String index) {
    Preconditions.checkNotNull(index, "Index name cannot be null");
    return new DropSegmentBuilder(ObjectType.INDEX, index);
  }

  public DropSegmentBuilder trigger(String trigger) {
    Preconditions.checkNotNull(trigger, "Trigger name cannot be null");
    return new DropSegmentBuilder(ObjectType.TRIGGER, trigger);
  }

  public SegmentBuilder ifExists() {
    ifExists = true;
    return this;
  }

  @Override
  public String build() {
    String statement = "DROP " + type + (ifExists ? " IF EXISTS" : "");
    return StringUtils.join(" ", statement, name);
  }
  
}
