import java.util.ArrayList;

public class Lab7_2 {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public Lab7_2() {
        root = null;
    }

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
        if (root == null) {
            return null;
        }

        if (n < root.data) {
            root.left = deleteRec(root.left, n);
        } else if (n > root.data) {
            root.right = deleteRec(root.right, n);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in right subtree)
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public String toTreeString() {
        if (root == null) return "";

        StringBuilder result = new StringBuilder();
        int maxLevel = getHeight(root);

        ArrayList < Node > nodes = new ArrayList < > ();
        nodes.add(root);

        int level = 0;
        int nodesInLevel = 1;

        while (!nodes.isEmpty() && level < maxLevel) {
            StringBuilder levelStr = new StringBuilder();
            int spacing = (int) Math.pow(2, maxLevel - level) - 1;

            for (int i = 0; i < nodesInLevel; i++) {
                Node node = nodes.remove(0);

                // Add spacing before node
                for (int j = 0; j < spacing; j++) {
                    levelStr.append(" ");
                }

                if (node != null) {
                    levelStr.append(node.data);
                    nodes.add(node.left);
                    nodes.add(node.right);
                } else {
                    levelStr.append(" ");
                    nodes.add(null);
                    nodes.add(null);
                }

                // Add spacing after node
                for (int j = 0; j < spacing; j++) {
                    levelStr.append(" ");
                }
            }

            result.append(levelStr).append("\n");
            level++;
            nodesInLevel *= 2;
        }

        return result.toString();
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public String toReverseOrderString() {
        StringBuilder result = new StringBuilder();
        toReverseOrderRec(root, result);
        if (result.length() > 0) {
            // Remove last comma
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    private void toReverseOrderRec(Node root, StringBuilder result) {
        if (root == null) return;

        toReverseOrderRec(root.right, result);
        result.append(root.data).append(",");
        toReverseOrderRec(root.left, result);
    }

    public static void main(String[] args) {
        Lab7_2 tree = new Lab7_2();

        // Test insert
        int[] testData = { 55, 12, 30, 97, 8, 103 };

        for (int num: testData) {
            tree.insert(num);
        }

        // Test toTreeString
        System.out.println("Tree structure:");
        System.out.println(tree.toTreeString());

        // Test toReverseOrderString
        System.out.println("Reverse order:");
        System.out.println(tree.toReverseOrderString());

        // Test delete
        System.out.println("\nAfter deleting 12:");
        tree.delete(12);
        System.out.println(tree.toTreeString());
        System.out.println("Reverse order after deletion:");
        System.out.println(tree.toReverseOrderString());
    }
}