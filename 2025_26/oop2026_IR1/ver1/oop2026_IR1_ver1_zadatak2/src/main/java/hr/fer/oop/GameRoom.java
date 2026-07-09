package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;


//TODO: Finish generics.
public class GameRoom<T> {
 private final String name;
 private final List<T> machines = new ArrayList<>();

 public GameRoom(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }


 public void addMachine(T machine) {
	 // TODO: Finish method implementation. The declaration may be changed where necessary.
 }


 public List<T> getMachines() {
	 // TODO: Return an unmodifiable list of stored machines. The declaration may be changed where necessary.
 }

 
 public T findMachine(String code) {
	 // TODO: Return the matching machine or null. The declaration may be changed where necessary.
 }

 
 public List<T> getMachinesRequiringAtMost(int tokens) {
	// TODO: Return a new list containing matching machines. The declaration may be changed where necessary.
 }

 @Override
 public String toString() {
     return "";
 }
}