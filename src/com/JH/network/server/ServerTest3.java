package com.JH.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServerTest3 {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket sc = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os=null;
		OutputStreamWriter ow=null;
		BufferedWriter bw=null;
		Scanner ssc = new Scanner(System.in);
		Random r = new Random();
		File lunch = new File("c:\\test", "lunch.txt");
		File dinner = new File("c:\\test", "dinner.txt");
		FileReader fr = null;
		FileReader fr2 = null;
		ArrayList<String> ar = new ArrayList<String>();

		try {
			System.out.println("Server : 클라이언트 접속 받을 준비 중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");
			
			
			
			is = sc.getInputStream(); //클라이언트로부터 받은 메세지
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);
			String s = br.readLine();
			String name=null;
			String a = null;
			if(s.equals("점심")) {
				fr= new FileReader(lunch);
				br= new BufferedReader(fr);
				br.readLine();
				
				while((a=br.readLine())!=null) {
					ar.add(a);
				}
				name = ar.get(r.nextInt(ar.size()));
			}
			
			if(s.equals("저녁")) {
				fr= new FileReader(dinner);
				br= new BufferedReader(fr);
				br.readLine();
				
				while((a=br.readLine())!=null) {
					ar.add(a);
				}
				name = ar.get(r.nextInt(ar.size()));
			}
			
			if(s.equals("아무거나")) {
				fr = new FileReader(lunch);
				fr2 = new FileReader(dinner);
				br= new BufferedReader(fr);
				br.readLine();
				while((a=br.readLine())!=null) {
					ar.add(a);
				}
				br = new BufferedReader(fr2);
				br.readLine();
				while((a=br.readLine())!=null) {
					ar.add(a);
				}
				name = ar.get(r.nextInt(ar.size()));
			}
			os = sc.getOutputStream(); //클라이언트로 보내는 메세지
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			bw.write(name);
			bw.write("\r\n");
			bw.flush();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				ssc.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
