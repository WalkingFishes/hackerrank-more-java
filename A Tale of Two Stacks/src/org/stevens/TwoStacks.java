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
    private Stack<T> stack = new Stack<>();
    private Stack<T> queue = new Stack<>();

    private void prepareQueue() {
        if (queue.empty()) {
            while (!stack.empty()) {
                queue.push(stack.pop());
            }
        }
        return;
    }
    
    public void enqueue(T t) {
        stack.push(t);
        System.out.println("Enqueue: " + stack + ", " + queue);
    }
    public T dequeue() {
        prepareQueue();
        System.out.println("Dequeue: " + stack + ", " + queue);
        return queue.pop();
    }
    public T peek() {
        prepareQueue();
        System.out.println("Peek: " + stack + ", " + queue);
        return queue.peek();
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
