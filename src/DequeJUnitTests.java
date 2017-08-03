import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class DequeJUnitTests {
    
    private static final int SIZE_EMPTY = 0;
    private static final int SIZE_TWO = 2;
    
    private static final Integer FIRST_ELEMENT = 15;
    private static final Integer SECOND_ELEMENT = 12;
    
    Deque<Integer> intDeque = new Deque<>();
    
    @Test
    public void testEmptyDequeSize() {
        assertEquals(SIZE_EMPTY, intDeque.size());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullItems() {
        intDeque.addFirst(null);
        intDeque.addLast(null);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyDeque() {
        intDeque.removeFirst();
        intDeque.removeLast();
    }
    
    @Test
    public void testAddTwoItemsRemoveFromEnd() {
        intDeque.addFirst(FIRST_ELEMENT);
        intDeque.addLast(SECOND_ELEMENT);
        assertEquals(SIZE_TWO, intDeque.size());
        assertEquals(SECOND_ELEMENT, intDeque.removeLast());
        assertEquals(FIRST_ELEMENT, intDeque.removeLast());
        assertEquals(SIZE_EMPTY, intDeque.size());
    }
    
    @Test
    public void testAddTwoItemsRemoveFromStart() {
        intDeque.addFirst(FIRST_ELEMENT);
        intDeque.addLast(SECOND_ELEMENT);
        assertEquals(SIZE_TWO, intDeque.size());
        assertEquals(FIRST_ELEMENT, intDeque.removeFirst());
        assertEquals(SECOND_ELEMENT, intDeque.removeFirst());
        assertEquals(SIZE_EMPTY, intDeque.size());
    }
}
