package com.Multithreading;

public class MutiThread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread is running..");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MutiThread1 obj = new MutiThread1();
		
		Thread t1 = new Thread(obj);// using the constructor thread(runnable r)
		
		t1.start();
	}

	
}
