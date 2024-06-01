package com.collectionDemo;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack s = new Stack();
		
		s.push("A");
		
		s.push(10);
		
		s.push("B");
		
		s.push("C");
		s.push("C");
		System.out.println(s);
		
		System.out.println(s.pop());
		System.out.println(s);
		
		System.out.println(s.peek());
		System.out.println(s);
		
		System.out.println(s.search("A"));
		
		System.out.println(s.empty());
	}

}
