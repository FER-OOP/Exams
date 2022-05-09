package hr.fer.oop.zad3;

public class MyList<E> {

  private MyListElement<E> head;

  public int addLast(E o) {
    if (head == null) {
      head = new MyListElement<>(o);
      return 0;
    }

    MyListElement<E> current = head;
    int index = 0;
    while (current.getNext() != null) {
      current = current.getNext();
      index++;
    }

    current.setNext(new MyListElement<>(o));
    return index + 1;

  }

  public void removeAt(int index) {
    if (index == 0) {
      if (head != null) {
        head = head.getNext();
      }
      return;
    }

    MyListElement<E> current = head;
    for (int i = 0; i < index - 1 && current != null; i++) {
      current = current.getNext();
    }

    if (current != null && current.getNext() != null) {
      current.setNext(current.getNext().getNext());
    }
  }

  public E elementAt(int index) {
    MyListElement<E> current = head;
    for (int i = 0; i < index && current != null; i++) {
      current = current.getNext();
    }
    return current == null ? null : current.getContent();
  }

  public int size() {
    MyListElement<E> current = head;
    int index = 0;
    for (; current != null; index++) {
      current = current.getNext();
    }
    return index;
  }
}
