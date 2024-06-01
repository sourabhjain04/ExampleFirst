package com.Multithreading;

class MyThread1 extends Thread{
	
	public MyThread1(String name) {
		super();
	}

	public void run() {
		for (int i=0; i<5;i++) {
			System.out.println(getName()+" is running with priority " + getPriority() + ",count: "+ i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
	}
	
}
}

public class ThreadpriorityExample {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread1 t1 = new MyThread1("Thread-1");
		MyThread1 t2 = new MyThread1("Thread-2");
		MyThread1 t3 = new MyThread1("Thread-3");
		
		t1.setPriority(Thread.MIN_PRIORITY);// min priority 1
		
		t2.setPriority(Thread.NORM_PRIORITY);// min priority 5

		t3.setPriority(Thread.MAX_PRIORITY);// min priority 10

		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
