package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectOrderByBuilder implements SegmentBuilder {

  private SegmentBuilder prefix;
  private String column;

  public SelectOrderByBuilder(SegmentBuilder prefix, String column) {
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
    return ArrayUtils.join(" ", prefix.build(), "ORDER BY", column);
  }
}
