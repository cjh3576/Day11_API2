package com.JH.io;

import java.io.IOException;
import java.io.InputStream;

public class IoTest1 {

	public static void main(String[] args) {
		
		System.out.println("입력 ");
		InputStream is = System.in;
		
		try {
			int num = is.read();
			System.out.println(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("종료");
	}
}


