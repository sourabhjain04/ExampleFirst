package com.first;

public class Person {

	private String name;
	
	private int age;
	
	
	public Person() {
		this.name="Unknown";
		this.age=0;
	}
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
		
	public Person(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public void displayDetails() {
		System.out.println("Name:" + name);
		System.out.println("age:" + age);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person1 = new Person();
		person1.displayDetails();
		
		Person person2 = new Person("Alice",30);
		person2.displayDetails();
		
		person1.setName("Bob");
		person1.setAge(25);
		person1.displayDetails();
		
		
	}

}
