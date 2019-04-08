package com.JH.io.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("C:\\test\\ex1.txt");
		file = new File("C:\\test", "ex1.txt");
		file = new File("C:\\test");
		File file2 = new File(file, "ex1.txt");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.length());
		File f = new File("C:\\");

		String[] f1 = f.list();
		for(int i =0; i<f1.length;i++) {
		System.out.println(f1[i]);
		
		String [] ar = f.list();
		File[] list = f.listFiles();
		
		file = new File("C:\\test\\JH\\test2");
//		file.mkdirs(); //file.mkdir();
		
		file = new File("c:\\test\\test2");
		file.delete();
		
		}
	}

}
