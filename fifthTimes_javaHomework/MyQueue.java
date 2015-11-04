package com.leetcode.homework;

import java.util.LinkedList;

public class MyQueue {
	private LinkedList myQueue;
	public MyQueue(){
		myQueue = new LinkedList();
	}
	
	 // Push element x to the back of queue.
    public void push(int x) {
    	myQueue.add(x);
    }

   // Removes the element from in front of queue.
    public void pop() {
    	LinkedList stack = new LinkedList();
    	while(!myQueue.isEmpty()){
    		stack.addLast(myQueue.removeLast());
    	}
    	stack.removeLast();
    	while(!stack.isEmpty()){
    		myQueue.addLast(stack.removeLast());
    	}
    }

    // Get the front element.
    public int peek() {
    	LinkedList stack = new LinkedList();
    	while(!myQueue.isEmpty()){
    		stack.addLast(myQueue.removeLast());
    	}
    	Integer val = (Integer) stack.getLast();
    	while(!stack.isEmpty()){
    		myQueue.addLast(stack.removeLast());
    	}
    	return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return myQueue.isEmpty();
    }
}
