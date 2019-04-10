package com.JH.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ServerTest2 {
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
		
		try {
			System.out.println("Server : 클라이언트 접속 받을 준비 중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");
			while(true) {
				is = sc.getInputStream(); //클라이언트로부터 받은 메세지
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir);
				String s = br.readLine();
				String [] str = s.split(",");
				String name = str[r.nextInt(str.length)];
				
				
				if(name.equals("false")) {
					System.out.println("종료하겠습니다.");
					break;
				} else {
					System.out.println("Message : "+name);
				}
				
				
				os = sc.getOutputStream(); //클라이언트로 보내는 메세지
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);

				
				
				if(name.equals("false")) {
					System.out.println("종료하겠습니다.");
					break;
				}
				bw.write(name);
				bw.write("\r\n");
				bw.flush();
			}
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
