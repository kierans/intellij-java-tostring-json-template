package com.quasar.javatostring.json;

public class SimpleObject {
  private final String aString;
  private final Integer anInteger;
  private final Boolean aBoolean;
  private final Object aNull;

  public SimpleObject() {
    aString = SimpleProperties.DEFAULT_STRING;
    anInteger = SimpleProperties.DEFAULT_INTEGER;
    aBoolean = SimpleProperties.DEFAULT_BOOLEAN;
    aNull = null;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"aString\": \"").append(aString).append('\"');
    sb.append(", \"anInteger\": ").append(anInteger);
    sb.append(", \"aBoolean\": ").append(aBoolean);
    sb.append(", \"aNull\": ").append(aNull);
    sb.append("}");

    return sb.toString();
  }
}
