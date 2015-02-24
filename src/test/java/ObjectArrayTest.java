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

    rootNode = TestFunctions.parseJson(json);
  }

  @Test(groups = "unit")
  public void shouldParseListOfSimpleObjects() {
    final JsonNode listNode = rootNode.get("list");

    TestFunctions.assertThatNodeIsCorrectType(listNode, ArrayNode.class);
    assertThat(listNode.size(), is(3));
  }

  @Test(groups = "unit")
  public void shouldParseArrayOfSimpleObjects() {
    final JsonNode arrNode = rootNode.get("arr");

    TestFunctions.assertThatNodeIsCorrectType(arrNode, ArrayNode.class);
    assertThat(arrNode.size(), is(3));
  }
}
