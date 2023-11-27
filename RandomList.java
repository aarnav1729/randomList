// required imports
import java.util.Random;

// class definition for RandomListNode
class RandomListNode<E> {
    // data element of type E
    E data;

    // reference to next node in list
    RandomListNode<E> next;

    // reference to previous node in list
    RandomListNode<E> prev;

    // default constructor to initialize node to empty state
    public RandomListNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// class definition for RandomList
public class RandomList<E> {

    // reference to first node in list
    private RandomListNode<E> head;

    // reference to last node in list
    private RandomListNode<E> tail;

    // reference to random number generator object (Random)
    private Random random;

    // default constructor to initialize list to empty state, initialize random number generator object (Random), and print name, email and message
    public RandomList() {

        // initialize list to empty state
        this.head = null;
        this.tail = null;

        // initialize random number generator object (Random)
        this.random = new Random();

        // print name, email and message
        System.out.println("Aarnav Singh - chhabraa@csp.edu");
        System.out.println("I certify that this is my own work");
    }

    // constructor to add element of type E to list using randomAdd method
    public RandomList(E data) {
        this();
        randomAdd(data);
    }

    // add element of type E to list 
    public void randomAdd(E data) {

        // create new node with data
        RandomListNode<E> newNode = new RandomListNode<>(data);

        // list is empty => set head and tail to new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        
        // list is not empty => add new node to a random location in the list
        else {

            // get random index
            int randomIndex = random.nextInt(size() + 1);

            // random index is 0 => add new node to beginning of list
            if (randomIndex == 0) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } 
            
            // random index is size of list => add new node to end of list
            else if (randomIndex == size()) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } 
            
            // random index is not at start or end of list => add new node to random location
            else {
                RandomListNode<E> current = getNodeAtIndex(randomIndex - 1);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
        }
    }

    // remove random element of type E from list and return it
    public E randomRemove() {
        if (isEmpty()) {
            return null;
        }

        // get random index
        int randomIndex = random.nextInt(size());

        // get node at random index
        RandomListNode<E> nodeToRemove = getNodeAtIndex(randomIndex);

        // node to remove is head => set head to next node
        if (nodeToRemove.prev == null) {
            head = nodeToRemove.next;
        } 
        
        // node to remove is not head => set previous node's next to node after node to remove
        else {
            nodeToRemove.prev.next = nodeToRemove.next;
        }

        // node to remove is tail => set tail to previous node
        if (nodeToRemove.next == null) {
            tail = nodeToRemove.prev;
        } 
        
        // node to remove is not tail => set next node's previous to node before node to remove
        else {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        // return data of node to remove
        return nodeToRemove.data;
    }

    // return random element of type E
    public E randomGet() {
        if (isEmpty()) {
            return null;
        }

        // get random index
        int randomIndex = random.nextInt(size());

        // get node at random index
        RandomListNode<E> node = getNodeAtIndex(randomIndex);

        // return data of node
        return node.data;
    }

    // print list of elements from head to tail
    public void printList() {

        // list is empty => print message
        RandomListNode<E> current = head;

        // print list of elements from head to tail
        int index = 1;
        while (current != null) {
            System.out.println(index + "> " + current.data);

            // move to next node in list and increment index
            current = current.next;
            index++;
        }
    }

    // print list of elements from tail to head
    public void printReverseList() {

        // list is empty => print message
        RandomListNode<E> current = tail;

        // print list of elements from tail to head
        int index = size();
        while (current != null) {
            System.out.println(index + "> " + current.data);

            // move to previous node in list and decrement index
            current = current.prev;
            index--;
        }
    }

    // return element E at specified location
    public E get(int index) {

        // index is out of bounds => return null
        if (index < 0 || index >= size()) {
            return null;
        }

        // index is 0 => return head
        RandomListNode<E> node = getNodeAtIndex(index);
        return node.data;
    }

    // helper method to get node at specific index
    private RandomListNode<E> getNodeAtIndex(int index) {

        // index is out of bounds => return null
        if (index < 0 || index >= size()) {
            return null;
        }

        // index is 0 => return head
        RandomListNode<E> current = head;

        // index is not 0 => move to node at index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // return node at index
        return current;
    }

    // helper method to check if the list is empty
    private boolean isEmpty() {

        // head is null => list is empty
        return head == null;
    }

    // helper method to get size of list
    private int size() {

        // list is empty => return 0
        int count = 0;

        // list is not empty => count number of nodes in list
        RandomListNode<E> current = head;
        while (current != null) {

            // increment count and move to next node in list
            count++;
            current = current.next;
        }

        // return size of list
        return count;
    }
}