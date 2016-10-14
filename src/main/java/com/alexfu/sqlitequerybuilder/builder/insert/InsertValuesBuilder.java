package com.alexfu.sqlitequerybuilder.builder.insert;

import com.alexfu.sqlitequerybuilder.builder.SegmentBuilder;
import com.alexfu.sqlitequerybuilder.utils.DateUtils;
import com.alexfu.sqlitequerybuilder.utils.StringUtils;

import java.util.Calendar;

public class InsertValuesBuilder extends SegmentBuilder {
  private final SegmentBuilder predicate;
  private final Object[] values;

  InsertValuesBuilder(SegmentBuilder predicate, Object[] values) {
    this.predicate = predicate;
    this.values = clean(values);
  }

  private Object[] clean(Object[] values) {
    Object[] clean = new Object[values.length];
    for (int i = 0; i < values.length; i++) {
      Object item = values[i];

      if (item instanceof String) {
        item = "'" + item + "'";
      }

      if (item instanceof Calendar) {
        Calendar date = (Calendar) item;
        item = "'" + DateUtils.iso8601().format(date.getTime()) + "'";
      }

      clean[i] = item;
    }
    return clean;
  }

  @Override
  public String build() {
    return predicate.build() + " values (" + StringUtils.join(",", values) + ")";
  }
}
