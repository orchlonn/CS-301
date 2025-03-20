
  
  public class Main {
    public static void main(String[] args) {
      LinkedQueue queue = new LinkedQueue();
  
      // Enqueue three elements onto the queue
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
  
      // Dequeue two elements from the queue
      System.out.println("Dequeued element: " + queue.dequeue());
      System.out.println("Dequeued element: " + queue.dequeue());
  
      // Peek at the front element without removing it
      System.out.println("Front element: " + queue.peek());
  
      // Check if the queue is empty
      System.out.println("Is queue empty? " + queue.isEmpty());
  
      // Check if the queue is full
      System.out.println("Is queue full? " + queue.isFull());
    }
  }