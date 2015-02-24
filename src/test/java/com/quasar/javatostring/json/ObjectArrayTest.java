package com.quasar.javatostring.json;

import static com.quasar.javatostring.json.CorrectNodeTypeMatcher.correctNodeType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ObjectArrayTest {
  private JsonNode rootNode;

  @BeforeMethod(groups = "unit")
  public void givenJson() throws Exception {
    final String json = new ObjectArray().toString();

    rootNode = JsonParser.parseJson(json);
  }

  @Test(groups = "unit")
  public void shouldParseListOfSimpleObjects() {
    final JsonNode listNode = rootNode.get("list");

    assertThat(listNode, is(correctNodeType(ArrayNode.class)));
    assertThat(listNode.size(), is(3));
  }

  @Test(groups = "unit")
  public void shouldParseArrayOfSimpleObjects() {
    final JsonNode arrNode = rootNode.get("arr");

    assertThat(arrNode, is(correctNodeType(ArrayNode.class)));
    assertThat(arrNode.size(), is(3));
  }
}
