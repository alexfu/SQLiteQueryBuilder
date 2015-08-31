package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.utils.Preconditions;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectGroupByBuilder extends SegmentBuilder {

  private SelectFromBuilder prefix;
  private String column;

  public SelectGroupByBuilder(SelectFromBuilder prefix, String column) {
    this.prefix = prefix;
    this.column = column;
  }

  public SelectHavingBuilder having(String condition) {
    Preconditions.checkArgument(condition != null, "Condition cannot be null");
    return new SelectHavingBuilder(this, condition);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "GROUP BY", column);
  }
}
