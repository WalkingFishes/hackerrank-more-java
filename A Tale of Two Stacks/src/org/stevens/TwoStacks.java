package org.stevens;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/*
 * Use 2 stacks to simulate a queue
 * 
 * Every time a push is called on the first stack
 * Move the first stack onto the second stack
 * For a pop, move the second stack onto the first.
 */
class MyQueue<T> {
    private Stack<T> stackStack = new Stack<>();
    private Stack<T> stackQueue = new Stack<>();
    
    public void enqueue(T t) {
        // Queue is empty, enqueue item directly to it
        if (stackQueue.empty()) {
            stackQueue.push(t);
            System.out.println("Enqueue("+t+") stack:" + stackStack + ", queue:" + stackQueue);
            return;
        }
        // Reverse the queue into a stack so last item can be added
        while (!stackQueue.empty()) {
            stackStack.push(stackQueue.pop());
        }
        stackStack.push(t);
        // Reverse the stack back into the queue
        while (!stackStack.empty()) {
            stackQueue.push(stackStack.pop());
        }
        
        System.out.println("Enqueue("+t+") stack:" + stackStack + ", queue:" + stackQueue);
        return;
    }
    public void dequeue() {
        // Just take the top item off the queue
        stackQueue.pop();
        System.out.println("Dequeue() " + stackQueue);
        return;
    }
    public T peek() {
        return stackQueue.peek();
    }
}

public class TwoStacks {

    public static void main(String[] args) throws FileNotFoundException {
        MyQueue<Integer> queue = new MyQueue<Integer>();

    	File file = new File ("src/input.txt");
    	Scanner scan = new Scanner(file);
    	int n = scan.nextInt();
    	
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println("Peek " + queue.peek());
            }
        }

        scan.close();
    }
}
