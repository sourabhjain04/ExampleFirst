package com.first;

class A{
	public void add() {
		System.out.println("this is class A method");
	}
}

class B extends A{
	public void add() {
		System.out.println("this is class B method");
	}
}
public class TestOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A obj = new A();
		obj.add();
		
		A obj2 = new B();
		obj2.add();
	}

}
