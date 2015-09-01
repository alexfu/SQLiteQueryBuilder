package com.alexfu.sqlitequerybuilder.builder.delete;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class DeleteFromBuilder extends SegmentBuilder {

  private DeleteBuilder prefix;
  private String[] tables;

  public DeleteFromBuilder(DeleteBuilder prefix, String... tables) {
    this.prefix = prefix;
    this.tables = tables;
  }

  public DeleteWhereBuilder where(String condition) {
    Preconditions.checkArgument(condition != null, "Condition cannot be null");
    return new DeleteWhereBuilder(this, condition);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "FROM", StringUtils.join(",", tables));
  }
}
