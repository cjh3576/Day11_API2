package com.JH.thread;

public class ThreadEat extends Thread{
	@Override
	public void run() {
		eat();
	}
	private void eat() {
		for(int i = 0; i<10; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("찹찹");
		}
	}
}
