public class BinarySearchTree {

    // Global variable:
    private Node root;

    // We use a private nested class becuase we only want BinaryTree's to access the node, and we want to be able to access the static variables across the class.
    private static class Node {
        Node leftChild;
        Node rightChild;
        int value;

        Node(int new_value) {
            value = new_value;
            leftChild = null;
            rightChild = null;
        }
    }

    // Variables
    
    // Constructor:
    public void BinarySearchTree() {
        root = null;
    }

    // Insertion
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            System.out.println(node.value);
        } else if (value <= node.value) {
            node.leftChild = insertNode(node.leftChild, value);
        } else {
            node.rightChild = insertNode(node.rightChild, value);
        }

        return node;
    }

    // Deletion

    // Look up function:

    // Size function:

    // Maximum depth:

    // Minimum value function:

    // Maximum value function:

    // Print all orders.
    // In-Order:

    public void printInOrder() {
        printInOrder(root);
    }
    
    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.leftChild);
        System.out.print(node.value + "  ");
        printInOrder(node.rightChild);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }
    
    private void printPostOrder(Node node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.print(node.value + "  ");

    }
    

    // Ouptut:
    public static void main(String[] args) {
        BinarySearchTree tester = new BinarySearchTree();
        tester.insert(3);
        tester.insert(6);
        tester.insert(9);
        tester.insert(1);
        tester.insert(4);
        tester.insert(-5);
        tester.printInOrder();
    }
}