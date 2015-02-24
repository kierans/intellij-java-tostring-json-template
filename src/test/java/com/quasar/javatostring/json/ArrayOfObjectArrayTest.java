package com.quasar.javatostring.json;

import static com.quasar.javatostring.json.CorrectNodeTypeMatcher.correctNodeType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayOfObjectArrayTest {
  private JsonNode rootNode;

  @BeforeMethod(groups = "unit")
  public void givenJson() throws Exception {
    final String json = new ArrayOfObjectArray().toString();

    rootNode = JsonParser.parseJson(json);
  }

  @Test(groups = "unit")
  public void shouldParseListOfListOfSimpleObjects() {
    final JsonNode listNode = rootNode.get("list");

    assertThat(listNode, is(correctNodeType(ArrayNode.class)));
    assertThat(listNode.size(), is(1));

    final JsonNode sublist = listNode.get(0);
    assertThat(sublist, is(correctNodeType(ArrayNode.class)));
    assertThat(sublist.size(), is(3));
  }
}
