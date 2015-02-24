package com.quasar.javatostring.json;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfObjectArray {
  private final List<List<SimpleObject>> list;
  private final SimpleObject[][] arr;

  public ArrayOfObjectArray() {
    list = new ArrayList<>();

    final List<SimpleObject> sublist = new ArrayList<>();
    sublist.add(new SimpleObject());
    sublist.add(new SimpleObject());
    sublist.add(new SimpleObject());

    list.add(sublist);

    arr = new SimpleObject[list.size()][];
    arr[0] = new SimpleObject[sublist.size()];

    sublist.toArray(arr[0]);
  }

  /**
   * Has a limitation where multi-dimensional arrays aren't converted properly.
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"list\": ").append(list);
    sb.append("}");

    return sb.toString();
  }
}
