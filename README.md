***This is Assignment 2 from Princeton's Algorithms Part I course, made using Eclipse, version: Neon.2 Release (4.6.2)*.***

# Description
This program implemented a double-ended queue (deque) and a randomized queue.   

A deque is a generalization of a stack and a queue that supports both adding and removing items from the front and the end of the data structure. It is implemented using a Doubly Linked List. The Deque supports methods such as getting it's size, getting if it's empty or not, or returning an iterator through the contents of the data structure.

A randomized queue is similar to a stack and queue, except that the item removed is chosen uniformly at random from all items in the data structure. For this reason, it is implemented using a resizable array. The RandomizedQueue supports methods such as sampling a random item in the data structure, removing an item, getting it's size, and getting if it's empty or not. There is also an `iterator()` method which returns a new iterator in random order through the contents of the RandomizedQueue.

The Permutation class reads in a sequence of Strings from a given .txt file(txt-file-name), and prints the given number (num-strings-to-print) of them uniformly at random, while only printing each String at most once. Permutation utilizes RandomizedQueue to accomplish this.  

Unit testing done for Deque and RandomizedQueue classes using JUnit.

Deque.java and RandomizedQueue.java both support `main()` methods that print simple demonstrations to the console.

# Command Line Instructions for Permutation

`cd src/`

## Windows:  
Compile:  
 `javac -cp ".;../lib/algs4.jar;../lib/hamcrest-core-1.3.jar;../lib/junit-4.12.jar" *.java`

Run:  
`java -cp ".;../lib/algs4.jar;../lib/hamcrest-core-1.3.jar;../lib/junit-4.12.jar" Permutation <num-strings-to-print> < ../testing/<txt-file-name>`

## Mac:
Compile:  
 `javac -cp ".:../lib/algs4.jar:../lib/hamcrest-core-1.3.jar:../lib/junit-4.12.jar" *.java`

Run:  
`java -cp ".:../lib/algs4.jar:../lib/hamcrest-core-1.3.jar:../lib/junit-4.12.jar" Permutation <num-strings-to-print> < ../testing/<txt-file-name>`

# Command Line Instructions for Deque
(Simply replace Deque with RandomizedQueue to see that demonstration)
`cd src/`

## Windows:
Compile:  
`javac -cp ".;../lib/algs4.jar" Deque.java`

Run:  
`java -cp ".;../lib/algs4.jar" Deque`

## Mac:  
Compile:  
`javac -cp ".:../lib/algs4.jar" Deque.java`

Run:  
`java -cp ".:../lib/algs4.jar" Deque`

