package com.alexfu.sqlitequerybuilder.impl;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.ArrayUtils;

public class SelectLimitBuilder implements SegmentBuilder {

  private SegmentBuilder prefix;
  private int limit = -1;
  private int offset = -1;

  public SelectLimitBuilder(SegmentBuilder prefix, int limit) {
    this.prefix = prefix;
    this.limit = limit;
  }

  public SelectLimitBuilder offset(int offset) {
    this.offset = offset;
    return this;
  }

  @Override
  public String build() {
    String offsetString = null;
    if (offset != -1) {
      offsetString = ArrayUtils.join(" ", "OFFSET", offset);
    }

    String result = ArrayUtils.join(" ", prefix.build(), "LIMIT", limit);
    if (offsetString != null) {
      result = ArrayUtils.join(" ", result, offsetString);
    }
    return result;
  }
}
