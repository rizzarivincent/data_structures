package HashMap;

import Interfaces.Map;
import Pair.Pair;

public class HashMap<K, V> implements Map<K, V> {
  private final int INITIAL_CAPACITY = 8;

  private Pair<K, V> tombstone;

  private Pair<K, V>[] arr;
  private int size;
  private int capacity;
  private double alpha = 0.6;

  @SuppressWarnings("unchecked")
  public HashMap() {
    this.capacity = INITIAL_CAPACITY;
    this.size = 0;
    this.arr = (Pair<K, V>[]) new Object[this.capacity];
  }

  @SuppressWarnings("unchecked")
  public HashMap(int cap) {
    this.capacity = cap;
    this.size = 0;
    this.arr = (Pair<K, V>[]) new Object[this.capacity];
  }

  public V get(K k) {
    int idx = find(k);
    if (arr[idx] == null)
      return null;
    return arr[idx].v;
  }

  public void put(K k, V v) {
    int idx = find(k);
    // k exists in array
    if (arr[idx] != null) {
      arr[idx].v = v;
    }
    // Adding (k, v) to array
    this.size++;
    // Grow if needed
    if (overloaded()) {
      grow();
      // Find index in new array
      idx = find(k);
    } else {
      // Find empty spot in array (either null or tombstone)
      idx = findEmpty(k);
    }
    arr[idx] = new Pair<K, V>(k, v);
  }

  public V remove(K k) {
    int idx = find(k);
    if (arr[idx] == null)
      return null;
    V val = arr[idx].v;
    arr[idx] = tombstone;
    size--;
    return val;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private int find(K k) {
    int hash = k.hashCode();
    int i = 0;
    int idx = hash + i * i;
    while (arr[idx] != null) {
      if (arr[idx].k == k) {
        return idx;
      }
      i++;
      idx = hash + i * i;
    }
    return idx;
  }

  private int findEmpty(K k) {
    int hash = k.hashCode();
    int i = 0;
    int idx = hash + i * i;
    while (arr[idx] != null && arr[idx] != tombstone) {
      i++;
      idx = hash + i * i;
    }
    return idx;
  }

  private boolean overloaded() {
    return (size / (double) capacity) >= alpha;
  }

  @SuppressWarnings("unchecked")
  private void grow() {
    capacity *= 2;
    Pair<K, V>[] oldArr = arr;
    this.arr = (Pair<K, V>[]) new Object[capacity];
    for (int i = 0; i < oldArr.length; i++) {
      if (oldArr[i] != null && oldArr[i] != tombstone) {
        put(oldArr[i].k, oldArr[i].v);
      }
    }
  }
}
