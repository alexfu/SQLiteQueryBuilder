package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Builder;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

public class SelectLimitBuilder extends SegmentBuilder {

  private Builder prefix;
  private int limit = -1;
  private int offset = -1;

  public SelectLimitBuilder(Builder prefix, int limit) {
    this.prefix = prefix;
    this.limit = limit;
  }

  public SegmentBuilder offset(int offset) {
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
}
