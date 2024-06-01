package com.collectionDemo;

import java.util.ArrayList;

public class ArrayListDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList obj = new ArrayList();
		
		obj.add("A");
		obj.add(10);
		obj.add("A");
		obj.add(null);
		
		System.out.println(obj);
		
		obj.remove(2);
		System.out.println(obj);
		
		obj.add(2,"m");
		obj.add("n");
		System.out.println(obj);
	}

}
