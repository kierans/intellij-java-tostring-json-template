package com.quasar.javatostring.json;

public class SimpleObject {
  public static final String DEFAULT_STRING = "Hello World";
  public static final Integer DEFAULT_INTEGER = 123;
  public static final Boolean DEFAULT_BOOLEAN = true;

  private final String aString;
  private final Integer anInteger;
  private final Boolean aBoolean;
  private final Object aNull;

  public SimpleObject() {
    aString = DEFAULT_STRING;
    anInteger = DEFAULT_INTEGER;
    aBoolean = DEFAULT_BOOLEAN;
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
