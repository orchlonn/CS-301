// LinkedQueue class implementation

import java.util.LinkedList;

public class LinkedQueue {
    private LinkedList list;
    private int size;
    private int MAX_CAPACITY;
  
    // Constructor
    public LinkedQueue() {
      list = new LinkedList();
      size = 0;
      MAX_CAPACITY = 5;
    }
  
    // Enqueue method
    public void enqueue(int element) {
      if (isFull()) {
        System.out.println("Queue is full. Cannot enqueue " + element);
      } else {
        list.append(element);
        size++;
        System.out.println(element + " enqueued to the queue.");
      }
    }
  
    // Dequeue method
    public int dequeue() {
      if (isEmpty()) {
        System.out.println("Queue is empty. Cannot dequeue.");
        return -1; // Indicating queue underflow
      } else {
        int frontElement = peek();
        list.removeFirst();
        size--;
        System.out.println(frontElement + " dequeued from the queue.");
        return frontElement;
      }
    }
  
    // Peek method
  
    public int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty. No element to peek.");
        return -1;
      }
  
      // Traverse the list manually to get the front node (without helper function)
      Node current = list.head;
      System.out.println("Front element is: " + current.data);
      return current.data;
    }
  
    // Check if the queue is empty
    public boolean isEmpty() {
      return size == 0;
    }
  
    // Check if the queue is full
    public boolean isFull() {
      return size == MAX_CAPACITY;
    }
  }