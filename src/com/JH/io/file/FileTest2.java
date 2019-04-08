package com.JH.io.file;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		File file = new File("c:\\");
		File f ;
		String[] f1 = file.list();

		for(int i = 0; i<f1.length; i++) {
			f = new File("c:\\"+ f1[i]);
			f= new File(file, f1[i]);
			if( f.isFile()) {
				System.out.println(f1[i].length() + " 크기");
				System.out.println(f1[i] + "파일입니다.");
			}
			if(f.isDirectory()) {
				System.out.println(f1[i] + "폴더 입니다.");
			}
		}
		
		
		
		
	}
}
