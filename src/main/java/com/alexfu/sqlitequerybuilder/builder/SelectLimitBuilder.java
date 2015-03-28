package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

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
      offsetString = StringUtils.join(" ", "OFFSET", String.valueOf(offset));
    }

    String result = StringUtils.join(" ", prefix.build(), "LIMIT", String.valueOf(limit));
    if (offsetString != null) {
      result = StringUtils.join(" ", result, offsetString);
    }
    return result;
  }

  @Override
  public String toString() {
    return build();
  }
}
