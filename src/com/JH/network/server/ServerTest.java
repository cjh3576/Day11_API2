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

public class ServerTest {

	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket sc = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os=null;
		OutputStreamWriter ow=null;
		BufferedWriter bw=null;
		Scanner ssc = new Scanner(System.in);
		ServerInfo si = new ServerInfo();

		
		try {
			System.out.println("Server : 클라이언트 접속 받을 준비중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");
			boolean check = true;
			while(true) {
			check = si.receiveClient(sc, is, ir, br);
			if(!check) break;
			check =si.sendClient(sc, os, ow, bw, ssc);
			if(!check) break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				while(true) {
				sc.close();
				ss.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}
}