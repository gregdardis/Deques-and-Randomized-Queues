import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code Deque} class is a double-ended queue, which is a generalization of a stack and a queue
 * to which items can be added or removed from both the front or back of the data structure.
 * The Deque is implemented using a single Linked List, and can hold any element of type Item.
 * 
 * Supports methods such as checking if the Deque is empty, returning its size, and iterating
 * through the Deque from front to end.
 * 
 * All operations take constant time in the worst-case.
 * 
 * @author Greg Dardis
 *
 */
public class Deque<Item> implements Iterable<Item> {
    
    private int dequeSize;
    
    /* Top of the stack */
    private Node first;
    
    private class Node {
        private Item item;
        private Node next;
    }
    
    /**
     * Creates an empty Deque.
     */
    public Deque() {
        dequeSize = 0;
        first = null;
    }
 
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        return dequeSize;
    }
    
    /**
     * Adds an item to the start of the Linked List Deque.
     * 
     * @param item  Item to add to the Deque
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to deque.");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        dequeSize++;
    }
    
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to deque.");
        }
    }
    
    /**
     * Removes an item from the start of the Linked List Deque.
     * 
     * @return  Item removed from Deque
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = first.item;
        first = first.next;
        dequeSize--;
        return item;
    }
    
//    public Item removeLast()  {
//        // remove and return the item from the end
//    }
    
//    public Iterator<Item> iterator() {
//        // return an iterator over items in order from front to end
//    }
    
    public static void main(String[] args) {
        System.out.println("test");
    }
    
}
