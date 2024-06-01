package com.collectionDemo;

import java.util.HashSet;

public class HeshSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet h= new HashSet();
		
		h.add("B");
		
		h.add("C");
		
		h.add("D");
		
		h.add("Z");
		
		h.add(null);
		
		h.add(10);
		
		System.out.println(h);
		
        h.add("B");
        
        System.out.println(h);
	}

}
