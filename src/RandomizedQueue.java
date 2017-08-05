import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * The {@code RandomizedQueue} class is a randomized queue, which is like a queue except
 * items are dequeued at random, instead of from the front of the data structure.
 * The Deque is implemented using an array, and can hold any object 
 * or primitive type, although you must use the wrapper class for primitives.
 * 
 * Supports methods such as checking if the queue is empty, returning its size, and shuffling
 * the queue before iterating through it's contents.
 * 
 * @author Greg Dardis
 *
 */
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
            doubleArraySize();
        }
    }
    
    /**
     * Doubles the size of the items array.
     */
    private void doubleArraySize() {
        Item[] temp = (Item[]) new Object[queueSize * 2];
        for (int i = 0; i < queueSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    
    /**
     * Halves the size of the items array.
     */
    private void halveArraySize() {
        Item[] temp = (Item[]) new Object[queueSize / 2];
        for (int i = 0; i < queueSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    
    /**
     * Removes a random item from the queue and returns it. 
     * 
     * @return  Random item removed
     */
    public Item dequeue() {
        if (isEmpty()) {
             throw new NoSuchElementException("Queue is empty, can't dequeue");
        }
        int randomIndex = StdRandom.uniform(0, size());
        Item item = items[randomIndex];
        items[randomIndex] = items[queueSize - 1];
        items[queueSize - 1] = null;
        queueSize--;
        if (queueSize < (items.length / 4)) {
            halveArraySize();
        }
        return item;
    }
    
    /**
     * @return  Random item from RandomizedQueue
     */
    private Item getRandomItem() {
        int randomIndex = StdRandom.uniform(0, size());
        return items[randomIndex];
    }
    
    /**
     * Samples a random item from the queue. 
     * Does not remove the item.
     * 
     * @return  Random item sampled
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty, can't sample");
        }
        return getRandomItem();
    }
    
    /**
     * @return A randomized iterator for the queue
     */
    public Iterator<Item> iterator() {
        // could use StdRandom.shuffle() here, didn't realize that existed
        shuffle();
        return new RandomizedQueueIterator();
    }
    
    /**
     * Shuffles the items array into random order.
     */
    private void shuffle() {
        Item[] temp = (Item[]) new Object[1];
        for (int i = 0; i < queueSize - 2; i++) {
            int j = StdRandom.uniform(i, queueSize);
            temp[0] = items[j];
            items[j] = items[i];
            items[i] = temp[0];
        }
    }
    
    public class RandomizedQueueIterator<Item> implements Iterator<Item> {
        
        private int i = 0;
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (Item) items[i++];
        }
        
        public boolean hasNext() {
            return i < (queueSize - 1);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        int numberToAdd = 20;
        int numberToSample = 5;
        int numberToRemove = 5;
        
        RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
        for (int i = 0; i < numberToAdd; i++) {
            rQueue.enqueue(i);
        }
        
        for (int i = 0; i < numberToRemove; i++) {
            System.out.println("Item removed: " + rQueue.dequeue());
        }
        
        for (int i = 0; i < numberToSample; i++) {
            System.out.println("Sample between 0 and " + numberToAdd + ": " + rQueue.sample());
        }
        
        Iterator<Integer> iterator = rQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator 1: " + iterator.next());
        }
        
        Iterator<Integer> iterator2 = rQueue.iterator();
        while (iterator2.hasNext()) {
            System.out.println("Iterator 2: " + iterator2.next());
        }
    }
}
