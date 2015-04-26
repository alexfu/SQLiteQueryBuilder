package com.alexfu.sqlitequerybuilder.builder;

import com.alexfu.sqlitequerybuilder.api.Builder;

public abstract class SegmentBuilder implements Builder {
  @Override
  public String toString() {
    return build();
  }
}
