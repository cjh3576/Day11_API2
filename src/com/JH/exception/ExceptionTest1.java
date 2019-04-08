package com.JH.exception;

public class ExceptionTest1 {

	public static void main(String[] args) {
		//Error, Exception
		try { 
			int [] ar = new int [3];
			System.out.println(ar[100]);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류");
		}
	}

}
