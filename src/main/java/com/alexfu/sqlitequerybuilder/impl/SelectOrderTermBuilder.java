package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectOrderTermBuilder implements SegmentBuilder {

  public enum Term {
    ASC, DESC
  }

  private SelectOrderByBuilder prefix;
  private Term term;

  public SelectOrderTermBuilder(SelectOrderByBuilder prefix, Term term) {
    this.prefix = prefix;
    this.term = term;
  }

  public SelectLimitBuilder limit(int limit) {
    return new SelectLimitBuilder(this, limit);
  }

  @Override
  public String build() {
    return ArrayUtils.join(" ", prefix.build(), term);
  }
}
