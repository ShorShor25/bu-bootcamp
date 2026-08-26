package module7;

public class RaceCondition { 
 
  static int counter = 0; 
 
  public static void main(String[] args) throws InterruptedException { 
    Thread t1 = new Thread(() -> { 
      for (int i = 0; i < 100000; i++) counter++; 
    }); 
    Thread t2 = new Thread(() -> { 
      for (int i = 0; i < 100000; i++) counter++; 
    }); 
 
    t1.start(); t2.start(); 
    t1.join(); t2.join(); 
 
    System.out.println("Counter: " + counter); 
    // Expected: 200000 
    // Actual: something less, different every run 
  } 
}
