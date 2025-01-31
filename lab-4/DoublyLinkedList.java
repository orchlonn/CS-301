class Node<T> {
  private T data;
  private Node<T> next;
  private Node<T> prev;
  
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

  public Node<T> getNext() {
      return next;
  }

  public void setNext(Node<T> next) {
      this.next = next;
  }

  public Node<T> getPrev() {
      return prev;
  }

  public void setPrev(Node<T> prev) {
      this.prev = prev;
  }
}

public class DoublyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;
  private int length;

  public DoublyLinkedList() {
      head = null;
      tail = null;
      length = 0;
  }

  public void insertAtFront(T data) {
      Node<T> newNode = new Node<>(data);
      if (isEmpty()) {
          head = tail = newNode;
      } else {
          newNode.setNext(head);
          head.setPrev(newNode);
          head = newNode;
      }
      length++;
  }

  public void insertAtEnd(T data) {
      Node<T> newNode = new Node<>(data);
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

      Node<T> current = head;
      for (int i = 0; i < index; i++) {
          current = current.getNext();
      }

      Node<T> newNode = new Node<>(data);
      newNode.setPrev(current.getPrev());
      newNode.setNext(current);
      current.getPrev().setNext(newNode);
      current.setPrev(newNode);
      length++;
  }

  public void removeByIndex(int index) {}

  public boolean isEmpty() {
      return length == 0;
  }

  public int length() {
      return length;
  }
}