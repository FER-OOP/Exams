package hr.fer.oop.task5;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Resource implements Closeable {
  int p;

  public Resource(int p) {
    this.p = p;
    System.out.println(p + " created");
  }

  @Override
  public void close() throws IOException {
    System.out.println(p + " closed");
  }

  public void work() throws ResourceException {
	  if (p == 2) {
		  throw new ResourceException();
	  }
    System.out.println(p + " work ends " + 30 / p);
  }

  public static void main(String[] args) {
    Set<Integer> priorities = new TreeSet<>();
    priorities.add(2);
    priorities.add(0);
    priorities.add(2);
    List<Resource> resources = new ArrayList<>();
	  for (Integer p : priorities) {
		  resources.add(new Resource(p));
	  }

    for (Resource r : resources) {
      try (r) {
        r.work();
      } catch (ResourceException e) {
        System.out.println("Resource Exception");
      } catch (IOException e) {
        System.out.println("IO Exception");
      } catch (RuntimeException e) {
        System.out.println("Runtime Exception");
      }
    }

    try (Resource r3 = new Resource(3);
         Resource r1 = new Resource(1);) {
      Resource r0 = new Resource(0);
      r3.work();
      r1.work();
      r0.work();
      System.out.println("try ends");
    } catch (Exception e) {
      System.out.println("exception");
      return;
    } finally {
      System.out.println("finally");
    }
    System.out.println("end");
  }
}

