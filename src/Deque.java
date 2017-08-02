
public class Deque<Item> implements Iterable<Item> {
    
    private int stackSize;
    
    /* Top of the stack */
    private Node first;
    
    private class Node {
        private Item item;
        private Node next;
    }
    
    public Deque() {
        // construct an empty deque
    }
 
    public boolean isEmpty() {
        // is the deque empty?
    }
    
    public int size() {
        // return the number of items on the deque
    }
    
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to deque.");
        }
    }
    
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to deque.");
        }
    }
    
    public Item removeFirst() {
        // remove and return the item from the front
    }
    
    public Item removeLast()  {
        // remove and return the item from the end
    }
    
    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
    }
    
    public static void main(String[] args) {
        // unit testing (optional)
    }
    
}
