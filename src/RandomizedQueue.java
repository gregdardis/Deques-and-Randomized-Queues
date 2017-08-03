
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
        // remove and return a random item
    }
    
    public Item sample() {
        // return (but do not remove) a random item
    }
    
    public Iterator<Item> iterator() {
         return an independent iterator over items in random order
    }
    
    public static void main(String[] args) {
        // unit testing (optional)
    }
    
}
