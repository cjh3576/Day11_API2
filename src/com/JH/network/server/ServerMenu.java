package com.JH.network.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class ServerMenu {
	private String[] lunch; 
	private String[] dinner;
	
	public void init() throws Exception{
		File file = new File("c:\\test\\lunch.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String menus = br.readLine();
		lunch = menus.split("-");
		br.close();
		fr.close();
		file = new File("c:\\test\\dinner.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		br.readLine();
		menus = br.readLine();
		dinner = menus.split("-");
		br.close();
		fr.close();
	}
	public String getRandom() {
		String menu = null;
		
		
		
		return menu;
	}
	public String getLunch() {
		String menu = null;
		Random r = new Random();
		int index = r.nextInt(lunch.length);
		menu = lunch[index];
		
		return menu;
		
	}
	
	public String getDinner() {
		String menu = null;
		Random r = new Random();
		int index = r.nextInt(dinner.length);
		menu = dinner[index];
		return menu;
	}
	
}
