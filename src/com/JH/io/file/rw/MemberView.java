package com.JH.io.file.rw;

import java.util.ArrayList;

public class MemberView {
	public void view(Member m) {
		System.out.println("그룹: " + m.getGroup() + "  이름 : " + m.getName() + "   나이 : " + m.getAge() + "  역할 : " + m.getRole()+ "   소속사 : " + m.getCom());
	}

	public void view(ArrayList<Member> ar) {
		for(Member s :ar) {
			System.out.println("그룹: " + s.getGroup() + "  이름 : " + s.getName() + "   나이 : " + s.getAge() + "  역할 : " + s.getRole()+ "   소속사 : " + s.getCom());
		}

	}
	
	public void view(String s ) {
		System.out.println(s);
	}
}
