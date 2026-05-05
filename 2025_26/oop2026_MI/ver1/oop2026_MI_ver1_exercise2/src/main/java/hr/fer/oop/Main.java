package hr.fer.oop;

import hr.fer.oop.stacklang.StackLangInterpreter;
import hr.fer.oop.stacklang.exception.StackLangException;

public class Main {

  private static void simpleExample() throws StackLangException {
    StackLangInterpreter interpreter = new StackLangInterpreter(1024);
    interpreter.runProgram("""
        PUSH 10
        PUSH 20
        PUSH 30
        PUSH 40

        PRINT
        ADD
        ADD
        MUL 3
        PRINT
        """);
  }

  private static void simpleErrorExample() {
    try {
      new StackLangInterpreter(10).runProgram("ADD");
    } catch (StackLangException e) {
      System.out.println("Greška u naredbi na retku " + e.getLine());
      System.out.println("Uzrok: " + e.getCause());
    }
  }

  private static void errorExample() {
    try {
      new StackLangInterpreter(10).runProgram("""
          PUSH 3
          MUL 3 4 5
          PRINT
          PUSH
          PRINT
          """);
    } catch (StackLangException e) {
      System.out.println("Greška u naredbi na retku " + e.getLine() + ", " + e);
      System.out.println("Uzrok: " + e.getCause());
    }
  }

  public static void main(String[] args) throws StackLangException {
    System.out.println("--- JEDNOSTAVAN PRIMJER ---");
    simpleExample();

    System.out.println("\n--- PRIMJER S GREŠKOM 1 ---");
    simpleErrorExample();

    System.out.println("\n--- PRIMJER S GREŠKOM 2 ---");
    errorExample();
  }

}
