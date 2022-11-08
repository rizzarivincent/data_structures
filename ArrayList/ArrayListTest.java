public class ArrayListTest {
  public static void main(String[] args) {
    emptyTrueAfterInit();
    emptyFalseAfterAdd();
    emptyTrueAfterAddAndRemove();
    addOneValue();
    addMultipleValues();
  }

  private static void emptyTrueAfterInit() {
    ArrayList<Integer> list = new ArrayList<>();
    assert (list.isEmpty() == true);
  }

  private static void emptyFalseAfterAdd() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(4);
    assert (list.isEmpty() == false);
  }

  private static void emptyTrueAfterAddAndRemove() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(20);
    list.remove(0);
    assert (list.isEmpty() == true);
  }

  private static void addOneValue() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(5);
    assert (list.size() == 1);
    assert (list.get(0) == 5);
  }

  private static void addMultipleValues() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    assert (list.size() == 1);
    assert (list.get(0) == 1);
    list.add(3);
    assert (list.size() == 2);
    assert (list.get(1) == 3);
    list.add(5);
    assert (list.size() == 3);
    assert (list.get(2) == 5);
    list.add(7);
    assert (list.size() == 4);
    assert (list.get(3) == 7);
  }
}
