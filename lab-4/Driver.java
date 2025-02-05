public class Driver {
  public static void main(String[] args) {
      // Create a doubly linked list of integers
      DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

      // Insert elements at the front
      list.insertAtFront(10);
      list.insertAtFront(20);
      list.insertAtFront(30);
      System.out.println("After inserting at front: " + list);

      // Insert elements at the end
      list.insertAtEnd(40);
      list.insertAtEnd(50);
      System.out.println("After inserting at end: " + list);

      // Insert elements at specific indices
      list.insertAtIndex(2, 25);
      System.out.println("After inserting 25 at index 2: " + list);

      // Remove elements by index
      list.removeByIndex(3);
      System.out.println("After removing element at index 3: " + list);

      // Remove element by key
      list.removeByKey(20);
      System.out.println("After removing element with value 20: " + list);

      // Check if the list contains a specific value
      int index = list.contains(40);
      System.out.println("Index of 40: " + index);

      // Update an element at a specific index
      list.set(1, 99);
      System.out.println("After setting index 1 to 99: " + list);

      // Retrieve an element by index
      System.out.println("Element at index 2: " + list.get(2));

      // Display the size of the list
      System.out.println("Size of the list: " + list.size());
  }
}
