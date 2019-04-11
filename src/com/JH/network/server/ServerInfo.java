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
import java.util.Scanner;

public class ServerInfo {
	ServerSocket ss=null;
	Socket sc = null;

	public boolean sendClient(Socket sc, OutputStream os, OutputStreamWriter ow, BufferedWriter bw, Scanner ssc) {
		try {

			os = sc.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			System.out.println("클라이언트로 보낼 메세지 입력");
			String s = ssc.next();
			if(s.equals("false")) {
				System.out.println("종료하겠습니다.");

			}
			bw.write(s);
			bw.write("\r\n");
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;

	}



	public boolean receiveClient(Socket sc,InputStream is, InputStreamReader ir, BufferedReader br) {


		try {
			is = sc.getInputStream();
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);
			String s = br.readLine();
			boolean check = true;
			if(s.equals("false")) {
				System.out.println("종료하겠습니다.");
				check =! check;
			} else {
				System.out.println("Message : "+s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;





	}
}
