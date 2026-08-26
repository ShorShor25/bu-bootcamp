package module7;

// SAFE: synchronized counter 
public class SafeCounter { 
 
  static int counter = 0; 
  static final Object lock = new Object(); 
 
  public static void main(String[] args) throws InterruptedException { 
    Thread t1 = new Thread(() -> { 
      for (int i = 0; i < 100000; i++) { 
        synchronized (lock) { counter++; } 
      } 
    }); 
    Thread t2 = new Thread(() -> { 
      for (int i = 0; i < 100000; i++) { 
        synchronized (lock) { counter++; } 
      } 
    }); 
 
    t1.start(); t2.start(); 
    t1.join(); t2.join(); 
 
    System.out.println("Counter: " + counter); // always 200000 
  } 
} 