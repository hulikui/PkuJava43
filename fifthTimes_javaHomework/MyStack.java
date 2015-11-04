package com.leetcode.homework;

import java.util.LinkedList;

public class MyStack {
    LinkedList queue;
	
	public MyStack(){
		queue = new LinkedList();
	}
	// Push element x onto stack.
    public void push(int x) {
        LinkedList temp = new LinkedList();
        while(!queue.isEmpty())
        	temp.add(queue.removeFirst());
        
        queue.add(x);
        
        while(!temp.isEmpty())
        	queue.add(temp.removeFirst());
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();        
    }

    // Get the top element.
    public int top() {
        return (Integer) queue.getFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
