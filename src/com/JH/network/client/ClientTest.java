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

public class ClientTest {

	public static void main(String[] args) {
		Socket s=null;
		OutputStream os=null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		ClientInfo ci = new ClientInfo();



		try {
			s = new Socket("211.238.142.25", 8180);
			System.out.println("서버와 접속 성공");
			boolean check = true;
			while(check) {
				check = ci.sendServer(s, sc);
				check = ci.ReceiveServer(s);

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}


}
