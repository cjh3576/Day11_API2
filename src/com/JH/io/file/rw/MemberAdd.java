package com.JH.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberAdd {
	public Member addMember(Scanner sc, ArrayList<Member> ar) {
		Member m = new Member();

		System.out.println("그룹 명을 입력하세요");
		m.setGroup(sc.next());
		System.out.println("이름을 입력하세요");
		m.setName(sc.next());
		System.out.println("나이를 입력하세요");
		m.setAge(sc.nextInt());
		System.out.println("역할을 입력하세요 ");
		m.setRole(sc.next());
		System.out.println("소속사를 입력하세요");
		m.setCom(sc.next());

		return m;

	}

	public void backUp(ArrayList<Member> ar) {
		File file = new File("c:\\test", "readTest.txt");
		FileWriter fw = null;
		try {
			fw= new FileWriter(file, false); //뒤에  true는 덮어쓰지않고 append
			fw.write("start\r\n");
			for(Member member : ar) {
				fw.write(member.getGroup()+ "-" + member.getName()+"-" +member.getAge()+"-"+member.getRole()+"-"+member.getCom()+"\r\n");
				fw.flush(); //버퍼를 강제로 비우기
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("백업 완료");
		}//finally

	}
}

