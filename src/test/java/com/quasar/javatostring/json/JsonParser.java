package com.quasar.javatostring.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
  public static JsonNode parseJson(final String json) throws IOException {
    final ObjectMapper mapper = new ObjectMapper();

    return mapper.readTree(json);
  }
}
