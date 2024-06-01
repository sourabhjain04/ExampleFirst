package com.collectionDemo;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList l = new LinkedList();
		
		
		l.add("Bhaskar");
		
		l.add(30);
		
		l.add(null);
		
		l.add("Bhaskar");
		
		System.out.println(l);
		
		l.set(0, "software");
		
		System.out.println(l);
		
		l.set(0, "Aisiri");
		

		System.out.println(l);
		
		l.removeLast();
		
		System.out.println(l);
		
		l.addFirst("Venky");
		
		System.out.println(l);
	}

}
