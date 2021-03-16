/**
* BinarySearchTree class for Integers where the
* smaller or equal values residing in the left nodes and
* larger values residing in the right nodes.
* @author Rae Abunahla (Github: @raean)
*/
public class BinarySearchTree {

    // Our global private root:
    private Node root;

    // We use a private nested class becuase we only want BinaryTree's to access the node, and we want to be able to access the static variables across the class.
    private static class Node {
        Node leftChild;
        Node rightChild;
        int value;

        Node(int newValue) {
            value = newValue;
            leftChild = null;
            rightChild = null;
        }
    }
    
    // Constructor:
    public BinarySearchTree() {
        root = null;
    }

    /**
    * This method inserts a value into the appropriate location 
    * in the Binary Search Tree:
    */
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value <= node.value) {
            node.leftChild = insertNode(node.leftChild, value);
        } else {
            node.rightChild = insertNode(node.rightChild, value);
        }

        return node;
    }

    /**
    * This method deletes an existing value from the Binary Search 
    * Tree and re-aligns the appropriate tree nodes.
    */
    public void delete(int value) {
        if (contains(value)) {
            root = deleteNode(root, value);
        }
    }

    private Node deleteNode(Node node, int value) {
       if (node.value == value) {
           if (node.leftChild == null) {
               node = node.rightChild;
           } else if (node.rightChild == null) {
                node = node.leftChild;
           } else {
               int min = this.findMinimum(node.rightChild);
               deleteNode(node, min);
               Node newNode = new Node(min);
               newNode.leftChild = node.leftChild;
               newNode.rightChild = node.rightChild;
               node = newNode;
           }
       } else {
           if (value <= node.value) {
                node.leftChild = deleteNode(node.leftChild, value);
           } else {
                node.rightChild = deleteNode(node.rightChild, value);
           }
       }

        return node;
    }
    
    /**
     * Returns true if the node with a given value
     * exists within the BST.
     */
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else {
            if (value <= node.value) {
                return contains(node.leftChild, value);
            } else {
                return contains(node.rightChild, value);
            }
        }
    }

    /**
     * Returns the distance from a node of value1 to a node
     * of value2 within the BST.
     */
    public int longestPathLeaftoLeaf(int value1, int value2) {
        Node commonNode = highestCommonNode(root, value1, value2);
        System.out.println("common node is: " + commonNode.value);
        int depth1 = depthOfNode(commonNode, value1);
        int depth2 = depthOfNode(commonNode, value2);
        return depth1+depth2+1;
    }

    /**
    * Retrieves the highest common root of two nodes 
    * with values 'value1' and 'value2'.
    */
    private Node highestCommonNode(Node node, int value1, int value2) {
        if (contains(node.leftChild, value1) && contains(node.rightChild, value2)) {
            return node;
        } else {
            if (value1 <= node.value && value2 <= node.value) {
                return highestCommonNode(node.leftChild, value1, value2);
            } else {
                return highestCommonNode(node.rightChild, value1, value2);
            }
        }
        
    }

    /**
     * Retreives the depth of a specific node with a given value.
     * @return the depth of that node from the root.
     */
    public int depthOfNode(int value) {
        return depthOfNode(root, value);
    }

    private int depthOfNode(Node node, int value) {
        if (node.value == value) {
            return 0;
        } else {
            if (value <= node.value) {
                return depthOfNode(node.leftChild, value) + 1;
            } else {
                return depthOfNode(node.rightChild, value) + 1;
            }
        }
    }

    // Size function:

    // Maximum depth:

    /**
    * Prints out the Integer values of the Binary Search Tree 
    * in order.
    */
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


    /**
    * Prints out the Integer values of the Binary Search Tree 
    * in post-order.
    */
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

    /**
    * Prints out the Integer values of the Binary Search Tree 
    * in pre-order.
    */
    public void printPreOrder() {
        printPreOrder(root);
    }
    
    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + "  ");
        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
    }

    /**
    * Retrieves the left-most node within the BST.
    */
    public int findMinimum(Node node) {
        if (node.leftChild == null) {
            return node.value;
        } else {
            return findMinimum(node.leftChild);
        }
    }

    /**
    * Retrieves the right-most node within the BST.
    */
    public int findMaximum(Node node) {
        if (node.rightChild == null) {
            return node.value;
        } else {
            return findMinimum(node.rightChild);
        }
    }

    // Testing the methods above:
    public static void main(String[] args) {
        BinarySearchTree tester = new BinarySearchTree();
        // Populating the tree:
        tester.insert(3);
        tester.insert(6);
        tester.insert(9);
        tester.insert(1);
        tester.insert(4);
        tester.insert(-5);
        tester.insert(-9);
        tester.insert(7);
        tester.insert(2);
        tester.insert(14);
        tester.insert(0);
        tester.insert(12);
        tester.printInOrder();
        tester.delete(-10);
        System.out.println(" ");
        tester.printInOrder();

        // Testing the contains() method:
        System.out.println(tester.contains(4));
        System.out.println(tester.contains(-4));

        // Testing the longestPathLeafToLeaf method:
        System.out.println(tester.longestPathLeaftoLeaf(-5,6));
        System.out.println(tester.longestPathLeaftoLeaf(-9,0));
    }
}