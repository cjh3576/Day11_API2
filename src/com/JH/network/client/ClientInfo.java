package com.JH.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientInfo {
	OutputStream os=null;
	OutputStreamWriter ow = null;
	BufferedWriter bw = null;
	InputStream is=null;
	InputStreamReader ir = null;
	BufferedReader br = null;
	
	
	public boolean sendServer(Socket s, Scanner sc) {
		try {
				os = s.getOutputStream();
				ow = new OutputStreamWriter(os);//char
				bw = new BufferedWriter(ow);

				System.out.println("서버로 보낼 메세지 입력");
				String str= sc.next();
				if(str.equals("false")) {
					return false;
				}
				bw.write(str);
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
		return true;
	}
	
	
	public boolean ReceiveServer(Socket s) {
		try {
			
				is = s.getInputStream();
				ir = new InputStreamReader(is);//char
				br = new BufferedReader(ir);
				String str = br.readLine();
				if(str.equals("false")) {
					return false;
				} 
				System.out.println("Message : "+str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return true;

	}
}
