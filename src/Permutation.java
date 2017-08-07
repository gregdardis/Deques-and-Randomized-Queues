import edu.princeton.cs.algs4.StdIn;

/**
 * This class takes a command line integer numberOfStrings, reads in a sequence of strings
 * from standard input, and prints numberOfStrings of them, uniformly at random.
 * Utilizes RandomizedQueue to do this.
 * 
 */
public class Permutation {

    public static void main(String[] args) {
        
        RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
        
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            rQueue.enqueue(str);
        }
        
        int numberOfStrings = Integer.parseInt(args[0]);
        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println(rQueue.dequeue());
        }
    }
}
