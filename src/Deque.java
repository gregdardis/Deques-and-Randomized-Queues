import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code Deque} class is a double-ended queue, which is a generalization of a stack and a queue
 * to which items can be added or removed from both the front or back of the data structure.
 * The Deque is implemented using a single Linked List, and can hold any object 
 * or primitive type, although you must use the wrapper class for primitives.
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
        private Node prev;
    }
    
    /**
     * Creates an empty Deque.
     */
    public Deque() {
        dequeSize = 0;
        first = null;
        last = null;
    }
 
    public boolean isEmpty() {
        return dequeSize == 0;
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
        first.prev = null;
        if (isEmpty()) {
            first.next = null;
            last = first;
        } else {
            oldFirst.prev = first;
            first.next = oldFirst;
            if (size() == 1) {
                last.prev = first;
            }
        }
        dequeSize++;
    }
    
    /**
     * Adds an item to the end of the Linked List Deque.
     * 
     * @param item  Item to add to the Deque
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to deque.");
        }
        
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        dequeSize++;
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
        } else {
            first.prev = null;
        }
        return item;
    }
    
    /**
     * Removes an item from the end of the Linked List Deque.
     * 
     * @return  Item removed from Deque
     */
    public Item removeLast() {
        if (isEmpty()) {
          throw new NoSuchElementException("Deque is empty");
        }
        Item item = last.item;
        last = last.prev;
        dequeSize--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
        private Node current;
        
        public DequeIterator() {
            this.current = first;
        }
        
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
        int numberToAdd = 30;
        Deque<Integer> dequeInts = new Deque<Integer>();
        for (int i = 0; i < numberToAdd; i++) {
            dequeInts.addLast(i);
        }
        
        Iterator<Integer> iterator = dequeInts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
