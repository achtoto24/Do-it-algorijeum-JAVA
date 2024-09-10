import java.util.Comparator;

public class LinkedList<E> {
  class Node<E> {
    private E data;
    private Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head; // head가 가리키고 있는 놈
  private Node<E> crnt;

  public LinkedList() {
    head = crnt = null;
  }

  public E search(E obj, Comparator<? super E> c) {
    Node<E> ptr = head;

    while (ptr != null) {
      if (c.compare(obj, ptr.data) == 0) {
        crnt = ptr;
        return ptr.data;
      }
      ptr = ptr.next;
    }
    return null;
  }

  public void purge(Comparator<? super E> c) {
    if (head != null) {
      Node<E> ptr = head;
      while (ptr != null) {
        Node<E> ptr2 = ptr.next;
        if (ptr2 != null) {
          while (ptr2 != null) {
            if (c.compare(ptr.data, ptr2.data) == 0)
              remove(ptr2);
            ptr2 = ptr2.next;
          }
        }
        ptr = ptr.next;
      }
    }
  }

  public E retrieve(int n) {
    if (n < 0) return null;
    Node<E> ptr = head;
    Node<E> ptr2 = head;
    int cnt = 0;
    while (ptr != null) {
      ptr = ptr.next;
      cnt++;
    }
    if (cnt < n) {
      return null;
    }
    for (int j = 0; j < n; j++) {
      ptr2 = ptr2.next;
    }
    return ptr2.data;
  }

  public void addFirst(E obj) {
    Node<E> ptr = head;
    head = crnt = new Node<E>(obj, ptr);
  }

  public void addLast(E obj) {
    if (head == null)
      addFirst(obj);
    else {
      Node<E> ptr = head;
      while (ptr.next != null)
        ptr = ptr.next;
      ptr.next = crnt = new Node<E>(obj, null);
    }
  }

  public void removeFirst() {
    if (head != null)
      head = crnt = head.next;
  }

  public void removeLast() {
    if (head != null) {
      if (head.next == null)
        removeFirst();
      else {
        Node<E> ptr = head;
        Node<E> pre = head;

        while (ptr.next != null) {
          pre = ptr;
          ptr = ptr.next;
        }
        pre.next = null;
        crnt = pre;
      }
    }
  }

  public void remove(Node p) {
    if (head != null) {
      if (p == head)
        removeFirst();
      else {
        Node<E> ptr = head;

        while (ptr.next != p) {
          ptr = ptr.next;
          if (ptr == null)
            return;
        }
        ptr.next = p.next;
        crnt = ptr;
      }
    }
  }

  public void removeCurrentNode() {
    remove(crnt);
  }

  public void clear() {
    while (head != null)
      removeFirst();
    crnt = null;
  }

  public boolean next() {
    if (crnt == null || crnt.next == null)
      return false;
    crnt = crnt.next;
    return true;
  }

  public void printCurrentNode() {
    if (crnt == null)
      System.out.println("선택한 노드가 없습니다.");
    else
      System.out.println(crnt.data);
  }

  public void dump() {
    Node<E> ptr = head;

    while (ptr != null) {
      System.out.println(ptr.data);
      ptr = ptr.next;
    }
  }
}