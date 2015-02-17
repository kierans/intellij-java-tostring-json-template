import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScalarPropertiesTest {
  private JsonNode rootNode;

  @BeforeMethod(groups = "unit")
  public void givenJson() throws Exception {
    final String json = new SimpleObject().toString();

    rootNode = parseJson(json);
  }

  @Test(groups = "unit")
  public void shouldParseStringProperty() throws Exception {
    final JsonNode stringNode = rootNode.get("aString");

    assertThatNodeIsCorrectType(stringNode, TextNode.class);
    assertThat(stringNode.asText(), is(SimpleObject.DEFAULT_STRING));
  }

  @Test(groups = "unit")
  public void shouldParseIntegerProperty() throws Exception {
    final JsonNode intNode = rootNode.get("anInteger");

    assertThatNodeIsCorrectType(intNode, IntNode.class);
    assertThat(intNode.asText(), is(String.valueOf(SimpleObject.DEFAULT_INTEGER)));
  }

  @Test(groups = "unit")
  public void shouldParseBooleanProperty() throws Exception {
    final JsonNode boolNode = rootNode.get("aBoolean");

    assertThatNodeIsCorrectType(boolNode, BooleanNode.class);
    assertThat(boolNode.asText(), is(String.valueOf(SimpleObject.DEFAULT_BOOLEAN)));
  }

  @Test(groups = "unit")
  public void shouldParseNullProperty() throws Exception {
    final JsonNode nullNode = rootNode.get("aNull");

    assertThatNodeIsCorrectType(nullNode, NullNode.class);
    assertThat(nullNode.asText(), is("null"));
  }

  private JsonNode parseJson(final String json) throws IOException {
    final ObjectMapper mapper = new ObjectMapper();

    return mapper.readTree(json);
  }

  private void assertThatNodeIsCorrectType(final JsonNode node, final Class<?> nodeType) {
    assertThat(node.getClass(), is(CoreMatchers.<Class<?>>equalTo(nodeType)));
  }
}
