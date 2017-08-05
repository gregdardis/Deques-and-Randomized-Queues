import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class RandomizedQueueJUnitTests {
    RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
    
    private static final int SIZE_EMPTY = 0;
    private static final int SIZE_FIVE = 5;
    
    @Test
    public void testEmptyRQueue() {
        assertEquals(SIZE_EMPTY, rQueue.size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItem() {
        rQueue.enqueue(null);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyRQueue() {
        rQueue.dequeue();
    }
    
    @Test
    public void testIteratorRandomness() {
        for (int i = 0; i < SIZE_FIVE; i++) {
            rQueue.enqueue(i);
        }
        Iterator<Integer> iterator = rQueue.iterator();
        assertEquals(SIZE_FIVE, rQueue.size());
        assertFalse(iterator.equals(rQueue.iterator()));
    }
} 
