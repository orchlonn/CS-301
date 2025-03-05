/*
Discussion on sorting options time complexity:
1. Sorting during insert() (Insertion Sort approach):
   - Time Complexity: O(n^2) - each insertion requires traversing and comparing with existing elements
   - Advantage: List is always sorted, good for applications needing immediate sorted access
   - Scenario: Real-time systems where sorted order is needed after each insertion

2. Sorting during sort() call:
   - Time Complexity: O(n^2) if using insertion sort, could be O(n log n) with other algorithms
   - Advantage: Faster insertions O(1), good when insertions are frequent and sorting is rare
   - Scenario: Batch processing where sorting is done once after all data is collected
*/

public class Lab7_1 {
    static class DoublyLinkedList {
        class Node {
            int data;
            Node prev;
            Node next;
            Node(int data) {
                this.data = data;
            }
        }
        
        private Node head;
        private Node tail;
        
        public void insert(int n) {
            Node newNode = new Node(n);
            
            if (head == null) {
                head = tail = newNode;
                return;
            }
            
            Node current = head;
            while (current != null && current.data < n) {
                current = current.next;
            }
            
            if (current == head) { 
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            } else { 
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        
        public String sort() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data);
                if (current.next != null) {
                    sb.append(", ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        int[] testData = {55, 12, 8, 30, 97, 103};
        
        for (int num : testData) {
            list.insert(num);
        }
        
        System.out.println(list.sort()); 
    }
}