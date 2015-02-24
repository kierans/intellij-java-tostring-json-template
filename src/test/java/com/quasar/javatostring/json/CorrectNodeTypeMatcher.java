package com.quasar.javatostring.json;

import com.fasterxml.jackson.databind.JsonNode;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CorrectNodeTypeMatcher extends TypeSafeMatcher<JsonNode> {
  private final Class<? extends JsonNode> nodeType;

  public CorrectNodeTypeMatcher(final Class<? extends JsonNode> nodeType) {
    this.nodeType = nodeType;
  }

  @Override
  protected boolean matchesSafely(final JsonNode node) {
    return node.getClass() == nodeType;
  }

  @Override
  public void describeTo(final Description description) {
    description.appendText("JsonNode of type ");
    description.appendText(nodeType.getSimpleName());
  }

  @Override
  protected void describeMismatchSafely(final JsonNode item, final Description mismatchDescription) {
    mismatchDescription.appendText("was type ");
    mismatchDescription.appendText(item.getClass().getSimpleName());
  }

  public static CorrectNodeTypeMatcher correctNodeType(final Class<? extends JsonNode> nodeType) {
    return new CorrectNodeTypeMatcher(nodeType);
  }
}
