package com.JH.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest3 {

	public static void main(String[] args) {
		Socket s=null;
		OutputStream os=null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);

		try {

			s = new Socket("211.238.142.25",8180);
			System.out.println("서버와 접속 성공");

			os = s.getOutputStream();//서버로 보낼 메세지,byte
			ow = new OutputStreamWriter(os);//char
			bw = new BufferedWriter(ow); //string
			

			System.out.println("1. 점심   2. 저녁  3. 아무거나 "); 
			String str= sc.nextLine();

			bw.write(str);
			bw.write("\r\n");
			bw.flush();


			is = s.getInputStream(); //서버로부터 받은 메세지
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);
			str = br.readLine();

			System.out.println("오늘의 메뉴 : "+str);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				sc.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


