package com.quasar.javatostring.json;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;

public class TestFunctions {
  public static JsonNode parseJson(final String json) throws IOException {
    final ObjectMapper mapper = new ObjectMapper();

    return mapper.readTree(json);
  }

  public static void assertThatNodeIsCorrectType(final JsonNode node, final Class<?> nodeType) {
    assertThat(node.getClass(), is(CoreMatchers.<Class<?>>equalTo(nodeType)));
  }
}
