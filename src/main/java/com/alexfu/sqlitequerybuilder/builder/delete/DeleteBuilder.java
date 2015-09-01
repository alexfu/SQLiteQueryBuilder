package com.alexfu.sqlitequerybuilder.builder.delete;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class DeleteBuilder extends SegmentBuilder {
  public DeleteFromBuilder from(String table) {
    Preconditions.checkArgument(table != null, "Table name cannot be null");
    return new DeleteFromBuilder(this, table);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", "DELETE");
  }
}
