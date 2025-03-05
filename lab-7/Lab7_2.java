// Lab7_2.java
import java.util.LinkedList;
import java.util.Queue;

public class Lab7_2 {  // Explicitly declared as public
    static class BinarySearchTree {
        class Node {
            int data;
            Node left;
            Node right;
            Node(int data) {
                this.data = data;
            }
        }
        
        private Node root;
        
        public void insert(int n) {
            root = insertRec(root, n);
        }
        
        private Node insertRec(Node root, int n) {
            if (root == null) {
                return new Node(n);
            }
            if (n < root.data) {
                root.left = insertRec(root.left, n);
            } else if (n > root.data) {
                root.right = insertRec(root.right, n);
            }
            return root;
        }
        
        public void delete(int n) {
            root = deleteRec(root, n);
        }
        
        private Node deleteRec(Node root, int n) {
            if (root == null) return null;
            
            if (n < root.data) {
                root.left = deleteRec(root.left, n);
            } else if (n > root.data) {
                root.right = deleteRec(root.right, n);
            } else {
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                
                root.data = minValue(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            return root;
        }
        
        private int minValue(Node root) {
            int min = root.data;
            while (root.left != null) {
                min = root.left.data;
                root = root.left;
            }
            return min;
        }
        
        public String toTreeString() {
            if (root == null) return "";
            
            StringBuilder sb = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                StringBuilder level = new StringBuilder();
                boolean hasNonNullChild = false;
                
                for (int i = 0; i < levelSize; i++) {
                    Node current = queue.poll();
                    level.append(String.format("%4d", current.data));
                    
                    if (current.left != null) {
                        queue.add(current.left);
                        hasNonNullChild = true;
                    } else {
                        queue.add(new Node(-1));
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                        hasNonNullChild = true;
                    } else {
                        queue.add(new Node(-1));
                    }
                }
                
                if (!level.toString().trim().isEmpty()) {
                    sb.append(level.toString().trim()).append("\n");
                }
                if (!hasNonNullChild) break;
            }
            
            return sb.toString().replace("-1", "   ");
        }
        
        public String toReverseOrderString() {
            StringBuilder sb = new StringBuilder();
            reverseOrderRec(root, sb);
            return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        }
        
        private void reverseOrderRec(Node root, StringBuilder sb) {
            if (root != null) {
                reverseOrderRec(root.right, sb);
                sb.append(root.data).append(",");
                reverseOrderRec(root.left, sb);
            }
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] testData = {55, 12, 30, 97, 8, 103};
        
        for (int num : testData) {
            tree.insert(num);
        }
        
        System.out.println("Tree structure:");
        System.out.println(tree.toTreeString());
        
        System.out.println("Reverse order:");
        System.out.println(tree.toReverseOrderString());
        
        tree.delete(12);
        System.out.println("\nAfter deleting 12:");
        System.out.println(tree.toTreeString());
    }
}