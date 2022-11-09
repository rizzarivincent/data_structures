package LinkedList;

import Interfaces.List;

public class LinkedList<T> implements List<T> {
  private class Node {
    private T val;
    private Node next;

    public Node(T val) {
      this.val = val;
      this.next = null;
    }

    public T getVal() {
      return this.val;
    }

    public void setVal(T val) {
      this.val = val;
    }

    public Node getNext() {
      return this.next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

  private int size;
  private Node head;
  private Node tail;

  public LinkedList() {
    this.size = 0;
    this.head = null;
    this.tail = null;
  }

  public T get(int i) {
    checkSize(i);
    Node curr = this.head;
    for (int j = 0; j < i; j++) {
      curr = curr.getNext();
    }
    return curr.getVal();
  }

  public void set(int i, T t) {
    checkSize(i);
    Node curr = this.head;
    for (int j = 0; j < i; j++) {
      curr = curr.getNext();
    }
    curr.setVal(t);
  }

  public void add(T t) {
    if (size == 0) {
      this.head = new Node(t);
      this.tail = this.head;
    } else {
      this.tail.setNext(new Node(t));
      this.tail = this.tail.getNext();
    }
    this.size++;
  }

  public T remove(int i) {
    checkSize(i);
    T val;
    if (i == 0) {
      val = this.head.getVal();
      this.head = this.head.getNext();
    } else {
      Node curr = this.head;
      for (int j = 0; j < i - 1; j++)
        curr = curr.getNext();
      val = curr.getNext().getVal();
      curr.setNext(curr.getNext().getNext());
      if (i == size - 1)
        tail = curr;
    }
    size--;
    return val;
  }

  public T remove(T t) {
    if (size == 0)
      return null;

    if (this.head.getVal() == t) {
      this.head = head.getNext();
      size--;
      return t;
    }

    Node prev = this.head;
    while (prev.getNext() != null) {
      if (prev.getNext().getVal() == t) {
        if (prev.getNext() == this.tail) {
          this.tail = prev;
        }
        prev.setNext(prev.getNext().getNext());
        return t;
      }
    }

    return null;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void checkSize(int i) {
    if (i < 0 || i >= size)
      throw new IllegalArgumentException();
  }
}