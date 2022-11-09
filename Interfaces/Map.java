package Interfaces;

public interface Map<K, V> {
  public V get(K k);

  public void put(K k, V v);

  public V remove(K k);

  public int size();

  public boolean isEmpty();
}
