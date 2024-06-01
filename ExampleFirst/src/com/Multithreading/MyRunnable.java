package com.Multithreading;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i=0; i<5;i++) {
			System.out.println(Thread.currentThread().getName()+" - " + i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
	}

	

}
