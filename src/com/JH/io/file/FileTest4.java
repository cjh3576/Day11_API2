package com.JH.io.file;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class FileTest4 {

	public static void main(String[] args) {
		File file = new File("c:\\test\\iu");
		String[] f1 = file.list();
		for(int i = 0; i<f1.length; i++) {
			File f= new File(file, f1[i]);
			String a = f.toString();
			String result = a.substring(a.lastIndexOf(".")+1);
			System.out.println(result);

			if(!( result.equals("jpg")|| result.equals("png")|| result.equals("bmp"))) {
				f.delete();
			}
		} //for 문

		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		File f= new File("c:\\test\\" + name);
		if(f.exists()) {
			f.delete();
		}
		
		else {
			f.mkdir();
		} //for문
		
		
		Random r = new Random();
		int a = r.nextInt();
		File f2 = new File("c:\\test||" + a);
		if(f2.exists()) {
			f2.delete();
		}
		else {
			f2 = new File("c:\\test\\" + a);
			f2.mkdir();
			
		}
		
	}

}

