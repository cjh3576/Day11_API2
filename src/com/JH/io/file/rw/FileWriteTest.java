package com.JH.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

	public static void main(String[] args) {
		File file = new File("c:\\test", "writeTest.txt");
		FileWriter fw = null;
		
		try {
			fw= new FileWriter(file, true); //뒤에  true는 덮어쓰지않고 append
			fw.write("fifthWrite\r\n");
			fw.flush(); //버퍼를 강제로 비우기
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("파일작성완료");
		}//finally
		
	}
}
