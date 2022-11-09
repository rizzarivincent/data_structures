package Interfaces;

public interface List<T> {

  public T get(int i);

  public void set(int i, T t);

  public void add(T t);

  public T remove(int i);

  public T remove(T t);

  public int size();

  public boolean isEmpty();
}
