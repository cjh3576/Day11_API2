package com.JH.exception;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Example1 ex1 = new Example1();
		try {
			ex1.test();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
}
