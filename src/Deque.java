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
    
    /* Top of the Deque */
    private Node first;
    
    /* Bottom of the Deque */
    private Node last;
    
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
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }
    
    /**
     * Removes an item from the start of the Linked List Deque.
     * 
     * @return  Item removed from Deque
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Item item = first.item;
        first = first.next;
        dequeSize--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    
    /**
     * Removes an item from the end of the Linked List Deque.
     * 
     * @return  Item removed from Deque
     */
    public Item removeLast()  {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        Item item = last.item;
        last = current;
        last.next = null;
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("test");
    }
    
}
