package hr.fer.oop;

public class MyList<T> {
  private int numberOfElementsInArray = 0;

  @SuppressWarnings("unchecked")
  private T[] elements = (T[]) new Object[10];

  public int size() {
    return numberOfElementsInArray;
  }

  public void addLast(T object) {
    if (numberOfElementsInArray == elements.length) {

      @SuppressWarnings("unchecked")
      T[] newArray = (T[]) new Object[elements.length * 2];
      System.arraycopy(elements, 0, newArray, 0, elements.length);
      elements = newArray;
    }
    elements[numberOfElementsInArray] = object;
    numberOfElementsInArray++;
  }

  public T elementAt(int index) {
    if (index < 0 || index >= numberOfElementsInArray) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    return elements[index];
  }
}

