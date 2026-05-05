package hr.fer.oop.stack;

// TODO: Finish this class
public class Stack {

  private final Object[] stack;
  private int numberOfElements = 0;

  public Stack(int capacity) {
    this.stack = new Object[capacity];
  }

  // TODO: Finish/Modify this method!
  public void push(Object value) {
    // Missing some code?
    this.stack[numberOfElements++] = value;
  }

  // TODO: Finish/Modify this method!
  public Object pop() {
    // Missing some code?
    return this.stack[--numberOfElements];
  }

  public int getNumberOfElements() {
    return numberOfElements;
  }

  public int getCapacity() {
    return this.stack.length;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SL Program Stack:");
    if (numberOfElements == 0) {
      sb.append(" empty!");
    } else {
      for (int i = 0; i < numberOfElements; ++i) {
        sb.append(System.lineSeparator());
        sb.append("    ");
        sb.append(stack[i]);
      }
    }
    return sb.toString();
  }

}
