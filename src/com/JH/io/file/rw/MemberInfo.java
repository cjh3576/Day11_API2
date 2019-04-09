package com.JH.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	private ArrayList<Member> searchCompany(Scanner sc, ArrayList<Member> ar) {
		ArrayList<Member> ar2 = new ArrayList<Member>();
		String n = sc.next();
		for(Member m : ar) {
			if(n.equals(m.getCom())) {
				ar2.add(m);
			}
		}
		return ar2;
	}

	private ArrayList<Member> searchTeam(Scanner sc, ArrayList<Member> ar) {
		ArrayList<Member> ar2 = new ArrayList<Member>();
		String n = sc.next();
		for(Member m : ar) {
			if(n.equals(m.getGroup())) {
				ar2.add(m);
			}
		}
		return ar2;
	}

	public ArrayList<Member> searchGroup(Scanner sc, ArrayList<Member> ar) {
		System.out.println("1. 그룹명   2. 소속사");
		int num = sc.nextInt();

		ArrayList<Member> ar2 = new ArrayList<Member>();
		switch(num) {

		case 1:
			ar2 = this.searchTeam(sc, ar);

			break;
		case 2:

			ar2 = this.searchCompany(sc, ar);
			break;
		}

		return ar2;
	}


	public Member searchMember(Scanner sc, ArrayList<Member> ar) {
		Member member = null;

		String n = sc.next();
		for(Member m: ar) {
			if(n.equals(m.getName())) {
				member =m;
				break;
			}
		}

		return member;
	}
	public ArrayList<Member> getMembers() {
		File file = new File("c:\\test", "readTest.txt");
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Member> ar = new ArrayList<Member>();
		Member m = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			br.readLine();
			String a = null;

			while((a=br.readLine())!=null) {

				String[] b = a.split("-");
				m = new Member();
				m.setGroup(b[0]);
				m.setName(b[1]);
				m.setAge((Integer.parseInt(b[2])));
				m.setRole(b[3]);
				m.setCom(b[4]);

				ar.add(m);
			}

		}//try
		catch (Exception e ) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//finally
		return ar;
	}
}
