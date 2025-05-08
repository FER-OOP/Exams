package hr.fer.oop;

public class MyList {
  private int numberOfElementsInArray = 0;
  private Object[] elements = new Object[10];

  public int size() {
    return numberOfElementsInArray;
  }

  public void addLast(Object object) {
    if (numberOfElementsInArray == elements.length) {
      Object[] newArray = new Object[elements.length * 2];
      System.arraycopy(elements, 0, newArray, 0, elements.length);
      elements = newArray;
    }
    elements[numberOfElementsInArray] = object;
    numberOfElementsInArray++;
  }

  public Object elementAt(int index) {
    if (index < 0 || index >= numberOfElementsInArray) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    return elements[index];
  }

}
