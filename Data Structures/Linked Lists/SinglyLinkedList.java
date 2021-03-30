/**
 * This class is my implementation of a Singly Linked List with a head and tail pointer. It does not have unique values and if there are duplicates, the delete() funtions will remove the first one found upon iteration.
 * @author Rae Abunahla (Github: @raean)
 */
public class SinglyLinkedList {

    private Node head;
    private Node tail;
        
    /**
     * Supporting inner class, Node, contains a value and a next pointer to the following node in the linked list.
     */
    private static class Node {

        int value;
        Node next;

        Node(int newValue) {
            value = newValue;
            next = null;
        }
    }

    /**
     * A constructor with no parameters passed.
     */
    public SinglyLinkedList() {
        head = null;
    }

    /**
     * A constructor with a head value passed as a parameter.
     */
    public SinglyLinkedList(int value) {
        this.head = new Node(value);
        this.tail = this.head;
    }

    /**
     * This method inserts an element with a specified value to the end of the linked list. It calls a recursive helper method.
     */
    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            head = insert(value, head);
        }
    }

    /**
     * This method recursively traverses the linked list until a null next pointer to place the new node with the specified value. It also re-assigns the tail pointer to the last node.
     * @param value is the value of the new node.
     * @param node is the passed down pointer of the linked list.
     * @return the same list in memory with the added node.
     */
    private Node insert(int value, Node node) {
        if (node.next == null) {
            node.next = new Node(value);
            tail = node.next;
        } else {
            node.next = insert(value, node.next);
        }
        return node;
    }

    /**
     * This method deletes an element with a specified value, provided that it contains the value and that the head is not null. A recursive helper method is called. The first occurence seen,in the case of duplicates, will be deleted.
     * @param value is the value of the node to be deleted.
     */
    public void delete(int value) {
        if (contains(value) && head != null) {
            head = delete(value, head, null);
        }
    }

    /**
     * This method recursively traverses the linked list until a node is found with a matching value. Once the node is found, it's nullified as it's pointer has changed. If the node is the last in the list, the tail is changed to the previous node, prev.
     * @param value is the value of the node to be deleted.
     * @param node the current node pointer.
     * @param prev is the node preceding the node passed.
     * @return the same list in memory with the deleted node.
     */
    private Node delete(int value, Node node, Node prev) {
        if (node.value == value) {
            node = node.next;
            if (node == null) {
                tail = prev;
            }
        } else {
            node.next = delete(value, node.next, node);
        }
        return node;
    }

    /**
     * This method checks if the value is found amongst the nodes in the linked list. A recursive helper method is called.
     * @param value is the value of the node to be checked for.
     * @return a boolean value that is true if the value is found within a node and false otherwise.
     */
    public boolean contains(int value) {
        if (head == null) {
            return false;
        } else {
            return contains(value, head);
        }
    }

    /**
     * This recursive method traverses the linked list until it finds an empty node, in which case the value is not present and it returns false, or until it finds a node with the same value, in which it returns true.
     * @param value is the value of the node to be checked for.
     * @param node is the current pointer of the list.
     * @return a boolean value that is true if the value is found within a node and false otherwise.
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
     * Returns the head of the list.
     */
    public int getHead() {
        return head.value;
    }

    /**
     * Returns the tail of the list
     */
    public int getTail() {
        return tail.value;
    }

    /**
     * Prints the all values of the linked list.
     */
    public String printList() {
        String result = "[ ";
        Node copy = head;
        while (copy!=null) {
            result += copy.value + " ";
            copy = copy.next;
        }
        return result + "]";
    }
    
    // Some test cases:
    public static void main(String[] args) {
        SinglyLinkedList list_1 = new SinglyLinkedList(1);
        list_1.insert(4);
        list_1.insert(7);
        list_1.insert(8);
        list_1.insert(3);
        list_1.insert(0);
        list_1.insert(2);
        System.out.println(list_1.printList());
        System.out.println(list_1.getTail());
        list_1.delete(2);
        System.out.println(list_1.printList());
        System.out.println(list_1.getTail());

    }

}