package com.JH.thread;

public class ThreadTv  extends Thread{
	
	@Override
	public void run() {
		tv();
	
	}
	private void tv() {
		for(int i = 0; i <10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("티비보기");
		}
	}
}
