public class ArrayList<T> {
  private final int INITIAL_CAPACITY = 8;

  private Object[] arr;
  private int size;
  private int capacity;

  public ArrayList() {
    this.size = 0;
    this.capacity = this.INITIAL_CAPACITY;
    this.arr = new Object[this.capacity];
  }

  public ArrayList(int cap) {
    this.size = 0;
    this.capacity = cap;
    this.arr = new Object[this.capacity];
  }

  @SuppressWarnings("unchecked")
  public T get(int i) {
    checkSize(i);
    return (T) arr[i];
  }

  public void set(int i, T t) {
    checkSize(i);
    arr[i] = t;
  }

  public void add(T t) {
    if (this.size == this.capacity) {
      grow();
    }
    this.arr[size++] = t;
  }

  @SuppressWarnings("unchecked")
  public T remove(int i) {
    checkSize(i);
    T removed = (T) arr[i];
    if (i < size - 1) {
      for (int j = 1; i + j < size; j++) {
        this.arr[i + j - 1] = this.arr[i + j];
      }
    }
    size--;
    return removed;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void checkSize(int i) {
    if (i < 0 || i > this.size)
      throw new IllegalArgumentException();
  }

  private void grow() {
    this.capacity *= 2;
    this.arr = copyArray(this.arr, this.capacity);
  }

  private Object[] copyArray(Object[] src, int newSize) {
    if (src.length > newSize)
      throw new IllegalArgumentException();
    Object[] newArr = new Object[newSize];
    for (int i = 0; i < src.length; i++) {
      newArr[i] = src[i];
    }
    return newArr;
  }
}