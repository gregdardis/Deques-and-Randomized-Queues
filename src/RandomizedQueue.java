import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] items;
    private int queueSize;
    
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        queueSize = 0;
    }
    
    public boolean isEmpty() {
        return queueSize == 0;
    }
    
    public int size() {
        return queueSize;
    }
    
    /**
     * Adds an item to the end of the queue array.
     * 
     * @param item  Item to add
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to randomized queue.");
        }
        items[queueSize++] = item;
        if (queueSize == items.length) {
            resize();
        }
    }
    
    /**
     * Doubles the size of the items array.
     */
    private void resize() {
        Item[] temp = (Item[]) new Object[queueSize * 2];
        for (int i = 0; i < queueSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    
    public Item dequeue() {
        if (isEmpty()) {
             throw new NoSuchElementException("Queue is empty, can't dequeue");
        }
        
        
    }
    
    /**
     * Samples a random item from the randomized queue. 
     * Does not remove the item.
     * 
     * @return  Item sampled
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, can't sample");
        }
        int randomIndex = StdRandom.uniform(0, size());
        Item item = items[randomIndex];
        return item;
    }
    
    // The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order
    public Iterator<Item> iterator() {
//         return an independent iterator over items in random order
    }
    
    public class RandomizedQueueIterator<Item> implements Iterator<Item> {
        public Item next() {
            
        }
        
        public boolean hasNext() {
            
        }
        
        public void remove() {
            
        }
    }
    
    public static void main(String[] args) {
        int numberToAdd = 30;
        int numberToSample = 5;
        RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
        for (int i = 0; i < numberToAdd; i++) {
            rQueue.enqueue(i);
        }
        for (int i = 0; i < numberToSample; i++) {
            System.out.println("Sample between 0 and " + numberToAdd + ": " + rQueue.sample());
        }
    }
}
