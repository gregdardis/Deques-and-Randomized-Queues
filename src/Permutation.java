import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This class takes a command line integer numberOfStrings, reads in a sequence of strings
 * from standard input, and prints numberOfStrings of them, uniformly at random.
 * Utilizes RandomizedQueue to do this.
 * 
 * @author Greg Dardis
 *
 */
public class Permutation {

    public static void main(String[] args) {
        
        RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
        
        String[] strs = StdIn.readAllStrings();
        for (int i = 0; i < strs.length; i++) {
            rQueue.enqueue(strs[i]);
        }
        
        int numberOfStrings = Integer.parseInt(args[0]);
        
        for (int i = 0; i < numberOfStrings; i++) {
            StdOut.println(rQueue.iterator().next());
        }
    }
}
