/**
 * This class is my implementation of a Doubly Linked List with a head and tail pointer. It does not have unique values and if there are duplicates, the delete() funtions will remove the first one found upon iteration.
 * @author Rae Abunahla (Github: @raean)
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
        
    /**
     * Supporting inner class, Node, contains a value, a next pointer to the following node, and a prev pointer to the preceeding node in the linked list.
     */
    private static class Node {

        int value;
        Node next;
        Node prev;

        Node(int newValue) {
            value = newValue;
            next = null;
            prev = null;
        }
    }

    /**
     * Constructor with no parameters.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Constructors with an initial parameter to populate the head node.
     * @param value is the value of the first node.
     */
    public DoublyLinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
    }

    /**
     * Insert adds a Node to the of the linked list. It does not check for duplicates and adds the node to the first available spot.
     * @param value is the value of the Node to be added.
     */
    public void insert(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            this.tail = this.head;
        } else {
            this.head = insert(value, this.head);
        }
    }
    
    /**
     * A recursive call for the instertion method that finds the first available spot within the linked list to add the new Node. It resets the tail pointer as well.
     */
    private Node insert(int value, Node node) {
        if (node.next == null) {
            Node newNode = new Node(value);
            node.next = newNode;
            newNode.prev = node;
            this.tail = newNode;
        } else {
            node.next = insert(value, node.next);
        }
        return node;
    }

    /**
     * Removes the selected node with the particular value from the linked list. It first checks if the value exists in the list and if the size of the list is 0.
     * @param value is the value to be removed from the linked list.
     */
    public void remove(int value) {
        if (contains(value)) {
            if (head.next == null) {
                head = null;
            } else {
                head = remove(value, head);
            }
        }
    }

    /**
     * This is the recursive call that supports the removal of the particular value.
     * @param value is the value to be removed.
     * @param node is the pointer node used to traverse the list.
     * @return a pointer to the updated list.
     */
    private Node remove(int value, Node node) {
        if (node.value == value) {
            if (node.next != null) {
                Node nextNode = node.next;
                nextNode.prev = node.prev;
            } else {
                this.tail = node.prev;
            }
            if (node.prev != null) {
                Node prevNode = node.prev;
                prevNode.next = node.next;
            } else {
                head = node.next;
            }

            return node.next;
        } else {
            node.next = remove(value, node.next);
        }
        return node;
    }

    /**
     * Checks if the linked list contains a particular value. If the linked list is empty, this function returns false.
     * @param value is the value to search for within the linked list.
     * @return a boolean value as to whether the value exists or not.
     */
    public boolean contains(int value) {
        if (head == null) {
            return false;
        } else {
            return contains(value, head);
        }
    }

    /**
     * This method is the recursive caller for the contains() method to check if a particular value exists within the linked list.
     * @param value is the value to search for within the linked list.
     * @param node is the node pointer that is used to traverse the linked list.
     * @return a boolean value as to whether the value exists or not.
     */
    private boolean contains(int value, Node node) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            return true;
        } else {
            return contains(value, node.next);
        }
    }

    /**
     * Prints the linked list for testing purposes.
     */
    public void printList() {
        Node pointer = this.head;
        System.out.print("[  ");
        while (pointer != null) {
            System.out.print(pointer.value + "  ");
            pointer = pointer.next;
        }
        System.out.println(']');
    }

    /**
     * Testing scenarios.
     */
    public static void main(String[] args) {
        DoublyLinkedList test = new DoublyLinkedList(); 
        test.insert(4); test.insert(6); test.insert(8); test.insert(3);
        test.printList();
        System.out.println("Tail is: " + test.tail.value);
        test.remove(3);
        System.out.println("Tail is: " + test.tail.value);
        test.printList();
    }

}