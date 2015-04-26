package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Builder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectOrderByBuilder extends SegmentBuilder {

  private Builder prefix;
  private String column;

  public SelectOrderByBuilder(Builder prefix, String column) {
    this.prefix = prefix;
    this.column = column;
  }

  public SelectOrderTermBuilder asc() {
    return new SelectOrderTermBuilder(this, SelectOrderTermBuilder.Term.ASC);
  }

  public SelectOrderTermBuilder desc() {
    return new SelectOrderTermBuilder(this, SelectOrderTermBuilder.Term.DESC);
  }

  @Override
  public String build() {
    return StringUtils.join(" ", prefix.build(), "ORDER BY", column);
  }
}
