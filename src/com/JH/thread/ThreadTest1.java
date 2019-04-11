package com.JH.thread;

public class ThreadTest1 {
	public static void main(String[] args) {
		ThreadEat te = new ThreadEat();
		ThreadTv tv = new ThreadTv();
		ThreadMusic tm = new ThreadMusic();
		//run 메서드 호출 금지
		te.start();
		tv.start();
		Thread t = new Thread(tm, "iu");
		Thread t2 = new Thread(tm, "choa");
		t.start();
		t2.start();
	}
}
