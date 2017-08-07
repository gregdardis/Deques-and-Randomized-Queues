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
        items = (Item[]) new Object[2];
        queueSize = 0;
    }
    
    public boolean isEmpty() {
        return queueSize == 0;
    }
    
    public int size() {
        return queueSize;
    }
     
    /**
     * Changes the size of the items array by a factor of newSize.
     */
    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < queueSize; i++) {
            temp[i] = items[i];
        }
        items = temp;
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
        if (queueSize == items.length) {
            resize(items.length * 2);
        }
        items[queueSize++] = item;
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
        int randomIndex = StdRandom.uniform(queueSize);
        Item item = items[randomIndex];
        items[randomIndex] = items[queueSize - 1];
        items[queueSize - 1] = null;
        queueSize--;
        if (queueSize > 0 && queueSize == (items.length / 4)) {
            resize(items.length / 2);
        }
        return item;
    }
    
    /**
     * @return  Random item from RandomizedQueue
     */
    private Item getRandomItem() {
        int randomIndex = StdRandom.uniform(queueSize);
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
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        
        private int copiedQueueSize = queueSize;
        private Item[] copiedQueue;
        
        public RandomizedQueueIterator() {
            copiedQueue = (Item[]) new Object[copiedQueueSize];
            for (int i = 0; i < queueSize; i++) {
                copiedQueue[i] = (Item) items[i];
            }
        }
        
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int randomIndex = StdRandom.uniform(copiedQueueSize);
            Item item = copiedQueue[randomIndex];
            copiedQueue[randomIndex] = copiedQueue[copiedQueueSize - 1];
            copiedQueue[copiedQueueSize - 1] = null;
            copiedQueueSize--;
            return item;
        }
        
        public boolean hasNext() {
            return copiedQueueSize > 0;
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
        System.out.println("Added " + numberToAdd + " items to the randomized queue, numbers from 0 to " + (numberToAdd - 1));
        for (int i = 0; i < numberToAdd; i++) {
            rQueue.enqueue(i);
        }
        
        System.out.println("Removed " + numberToRemove + " random items from the queue.");
        for (int i = 0; i < numberToRemove; i++) {
            System.out.println("Item removed: " + rQueue.dequeue());
        }
        
        System.out.println("\nSample " + numberToSample + " random items but don't remove them.");
        for (int i = 0; i < numberToSample; i++) {
            System.out.println("Sample between 0 and " + numberToAdd + ": " + rQueue.sample());
        }
        
        Iterator<Integer> iterator = rQueue.iterator();
        System.out.println("\nLets iterate through all the contents in random order.");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        Iterator<Integer> iterator2 = rQueue.iterator();
        System.out.println("Lets iterate through all the contents in random order AGAIN!.");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
