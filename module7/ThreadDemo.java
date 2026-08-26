package module7;

public class ThreadDemo {
 
  public static void main(String[] args) throws InterruptedException { 
 
    // Create a thread that runs a task concurrently 
    Thread worker = new Thread(() -> { 
      for (int i = 0; i < 5; i++) { 
        System.out.println("Worker thread: " + i); 
        try { Thread.sleep(100); } catch (InterruptedException e) { break; } 
      } 
    }); 
 
    worker.start();  // start the thread 
 
    // Main thread continues while worker runs 
    for (int i = 0; i < 5; i++) { 
      System.out.println("Main thread:  " + i); 
      Thread.sleep(100); 
    } 
 
    worker.join();  // wait for worker to finish before exiting 
    System.out.println("Both threads done."); 
  } 
} 
