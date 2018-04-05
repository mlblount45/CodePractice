package com.blountmarquis.stackoverflow;

import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {

  public int size;
  protected Node head;
  protected Node tail;
  public BasicLinkedList() {
    head = tail = null;
  }

  public BasicLinkedList<T> addToEnd(T data) {
    Node n = new Node(data);
    Node curr = head;
    //Check to see if the list is empty
    if (head == null) {
      head = n;
      tail = head;
    } else {
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = n;
      tail = n;

    }
    size++;
    return this;
  }

  public BasicLinkedList<T> addToFront(T data) {
    Node n = new Node(data);
    if (head == null) {
      head = n;
      tail = n;
    }
    n.next = head;
    head = n;
    size++;
    return this;
  }

  public T getFirst() {
    if (head == null) {
      return null;
    }
    return head.data;
  }

  public T getLast() {
    if (tail == null) {
      return null;
    }
    return tail.data;
  }

  public int getSize() {
    return size;
  }

  public T retrieveFirstElement() {
    // Check to see if the list is empty
    if (head == null) {
      return null;
    }
    Node firstElement = head;
    Node curr = head.next;
    head = curr;
    size--;
    return firstElement.data;

  }

  public T retrieveLastElement() {
    Node curr = head;
    Node prev = head;
    // Check to see if the list is empty
    if (head == null) {
      return null;
    } else {
      // If there's only one element in the list
      if (head.next == null) {
        curr = head;
        head = null;
      } else {
        while (curr.next != null) {
          prev = curr;
          curr = curr.next;
        }

        tail = prev;
        tail.next = null;
      }
    }
    size--;
    return curr.data;
  }

  public void remove(T targetData, Comparator<T> comparator) {
    Node prev = null, curr = head;
    while (curr != null) {
      if (comparator.compare(curr.data, targetData) == 0) {
        //Check to see if we need to remove the very first element
        if (curr == head) {
          head = head.next;
          curr = head;
        }
        //Check to see if we need to remove the last element, in which case update the tail
        else if (curr == tail) {
          curr = null;
          tail = prev;
          prev.next = null;
        }
        //If anywhere else in the list
        else {
          prev.next = curr.next;
          curr = curr.next;
        }
        size--;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {

      Node current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (hasNext()) {
          T data = current.data;
          current = current.next;
          return data;
        }
        return null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException("Remove not implemented.");
      }

    };
  }

  protected class Node {

    protected T data;
    protected Node next;

    protected Node(T data) {
      this.data = data;
      next = null;
    }
  }


}
