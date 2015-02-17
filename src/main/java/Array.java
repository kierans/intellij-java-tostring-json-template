import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
  private final List<SimpleObject> list;
  private final SimpleObject[] arr;

  public Array() {
    list = new ArrayList<>();

    list.add(new SimpleObject());
    list.add(new SimpleObject());
    list.add(new SimpleObject());

    arr = new SimpleObject[list.size()];
    list.toArray(arr);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"list\": ").append(list);
    sb.append(", \"arr\": ").append(arr == null ? "null" : Arrays.asList(arr).toString());
    sb.append("}");

    return sb.toString();
  }
}
