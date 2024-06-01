package com.Multithreading;

class MyThread extends Thread{
	String threadName;

	public MyThread(String name) {
		
		this.threadName = name;
	}
	

	public void run() {
		for (int i=0; i<5;i++) {
			System.out.println(threadName+" - " + i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
	}
		System.out.println(threadName+ "finished. ");
}
}

public class ThreadJoinExample {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThread t1 = new MyThread("Thread-1");
		MyThread t2 = new MyThread("Thread-2");
		MyThread t3 = new MyThread("Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
		
		  try { t1.join(); System.out.println("Joined " + t1.threadName); t2.join();
		  System.out.println("Joined " + t2.threadName); t3.join();
		  System.out.println("Joined " + t3.threadName);
		  
		  }catch(InterruptedException e) { System.out.println(e); }
		  System.out.println("All thread have finished execution. ");
		
	}

}
