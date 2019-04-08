package com.JH.io.file;

import java.io.File;

public class FileTest3 {

	public static void main(String[] args) {
		File file = new File("c:\\test");
		String str = "iu-suji-choa,hani";
		str = str.replace(",", "-");
		String[] names = str.split("-");
		
		for(int i =0; i<names.length; i++) {
		file = new File("c:\\test\\" + names[i]);
		
		file.mkdir();
		}
	}

}
