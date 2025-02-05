class Node < T > {
    private T data;
    private Node < T > next;
    private Node < T > prev;
  
    public Node(T data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  
    public T getData() {
      return data;
    }
  
    public void setData(T data) {
      this.data = data;
    }
  
    public Node < T > getNext() {
      return next;
    }
  
    public void setNext(Node < T > next) {
      this.next = next;
    }
  
    public Node < T > getPrev() {
      return prev;
    }
  
    public void setPrev(Node < T > prev) {
      this.prev = prev;
    }
  }
  
  public class DoublyLinkedList < T > {
    // Declare variables
    private Node < T > head;
    private Node < T > tail;
    private int length;
  
    public DoublyLinkedList() {
      head = null;
      tail = null;
      length = 0;
    }
  
    public void insertAtFront(T data) {
      // Create a new node with the given data
      Node < T > newNode = new Node < > (data);
      // if the list is empty, set the head and tail to the new node
      if (isEmpty()) {
        head = tail = newNode;
      } else {
        // set the new node's next to the current head
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
      }
      // increment the length by one
      length++;
    }
  
    public void insertAtEnd(T data) {
      // Create a new node with the given data
      Node < T > newNode = new Node < > (data);
      // if the list is empty, set the head and tail to the new node
      if (isEmpty()) {
        head = tail = newNode;
      } else {
        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;
      }
      length++;
    }
  
    public void insertAtIndex(int index, T data) {
      if (index < 0 || index > length) {
        throw new IndexOutOfBoundsException("Invalid index");
      }
  
      if (index == 0) {
        insertAtFront(data);
        return;
      }
  
      if (index == length) {
        insertAtEnd(data);
        return;
      }
  
      Node < T > current = head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
  
      Node < T > newNode = new Node < > (data);
      newNode.setPrev(current.getPrev());
      newNode.setNext(current);
      current.getPrev().setNext(newNode);
      current.setPrev(newNode);
      length++;
    }
  
    public void removeByIndex(int index) {
      // 
      if (index < 0 || index >= length) {
        throw new IndexOutOfBoundsException("Invalid index");
      }
  
      if (index == 0) {
        // Remove from front
        head = head.getNext();
        if (head != null) {
          head.setPrev(null);
        } else {
          tail = null;
        }
      } else if (index == length - 1) {
        // Remove from end
        tail = tail.getPrev();
        tail.setNext(null);
      } else {
        // Remove from middle
        Node < T > current = head;
        for (int i = 0; i < index; i++) {
          current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
      }
  
      length--;
    }
  
    public void removeByKey(T key) {
      if (isEmpty()) {
        return;
      }
  
      // Check if it's the head
      if (head.getData().equals(key)) {
        head = head.getNext();
        if (head != null) {
          head.setPrev(null);
        } else {
          tail = null;
        }
        length--;
        return;
      }
  
      // Search for the key in the list
      Node < T > current = head;
      while (current != null && !current.getData().equals(key)) {
        current = current.getNext();
      }
  
      // If key was not found
      if (current == null) {
        return;
      }
  
      // If it's the tail
      if (current == tail) {
        tail = tail.getPrev();
        tail.setNext(null);
      } else {
        // If it's in the middle
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
      }
  
      length--;
    }
  
    public int contains(T key) {
      // Checks that the linked list empty or not
      if (isEmpty()) {
        return -1;
      }
  
      Node < T > current = head;
      int index = 0;
  
      while (current != null) {
        if (current.getData().equals(key)) {
          return index;
        }
        current = current.getNext();
        index++;
      }
  
      return -1;
  
    }
  
    // Helper function that checks if the linked list is empty or not
    public boolean isEmpty() {
      return length == 0;
    }
  
    public void set(int index, T data) {
      if (index < 0 || index >= length) {
        throw new IndexOutOfBoundsException("Invalid index");
      }
  
      Node < T > current = head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
      current.setData(data);
    }
  
    public T get(int index) {
      if (index < 0 || index >= length) {
        return null;
      }
  
      Node < T > current = head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
      return current.getData();
    }
  
    public int size() {
      return length;
    }
  
    @Override
    public String toString() {
      if (isEmpty()) {
        return "[]";
      }
  
      StringBuilder result = new StringBuilder("[");
      Node < T > current = head;
  
      while (current != null) {
        result.append(current.getData());
        if (current.getNext() != null) {
          result.append(", ");
        }
        current = current.getNext();
      }
  
      result.append("]");
      return result.toString();
    }
  }