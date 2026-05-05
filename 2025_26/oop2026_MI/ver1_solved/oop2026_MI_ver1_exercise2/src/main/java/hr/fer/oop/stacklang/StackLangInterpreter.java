package hr.fer.oop.stacklang;

import hr.fer.oop.stack.Stack;
import hr.fer.oop.stack.CapacityException;
import hr.fer.oop.stack.EmptyException;
import hr.fer.oop.stacklang.exception.*;

public class StackLangInterpreter {

  private Stack<Integer> stack;

  public StackLangInterpreter(int stackSize) {
    this.stack = new Stack<>(stackSize);
  }

  public void runProgram(String programString) throws StackLangException {
    String[] lines = programString.split(System.lineSeparator());
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      if (line.isBlank()) {
        continue;
      }
      String[] lineSplit = line.split(" ");
      String commandName = lineSplit[0];
      runCommandLine(i + 1, commandName, lineSplit);
    }
  }

  private void runCommandLine(int line, String commandName, String[] arguments) throws StackLangException {
    if (StackLangCommand.PUSH.toString().equals(commandName)) {
      pushCmd(line, arguments);
    } else if (StackLangCommand.PRINT.toString().equals(commandName)) {
      System.out.println(this.stack);
    } else if (StackLangCommand.ADD.toString().equals(commandName)) {
      addCmd(line, arguments);
    } else if (StackLangCommand.MUL.toString().equals(commandName)) {
      mulCmd(line, arguments);
    } else {
      throw new UnsupportedCommandException(line, commandName);
    }
  }

  private void mulCmd(int line, String[] arguments) throws CommandException {
    try {
      if (arguments.length < 2) {
        throw new NotEnoughArgumentsException(arguments.length, 2);
      }
      int value = this.stack.pop();
      int scalar = Integer.parseInt(arguments[1]);
      this.stack.push(value * scalar);
    } catch (NumberFormatException | EmptyException | NotEnoughArgumentsException e) {
      throw new CommandException(e, line, StackLangCommand.MUL);
    }
  }

  private void addCmd(int line, String[] arguments) throws CommandException {
    try {
      int a = stack.pop();
      int b = stack.pop();
      stack.push(a + b);
    } catch (EmptyException e) {
      throw new CommandException(e, line, StackLangCommand.ADD);
    }
  }

  private void pushCmd(int line, String[] arguments) throws CommandException {
    try {
      if (arguments.length < 2) {
        throw new NotEnoughArgumentsException(arguments.length, 2);
      }
      int value = Integer.parseInt(arguments[1]);
      this.stack.push(value);
    } catch (CapacityException | NumberFormatException | NotEnoughArgumentsException e) {
      throw new CommandException(e, line, StackLangCommand.PUSH);
    }
  }
}
