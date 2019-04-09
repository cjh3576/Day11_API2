package com.JH.io.file.rw;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	private Scanner sc;
	private MemberView mv;
	private MemberInfo mi;
	private MemberAdd ma;
	ArrayList<Member> ar;
	public MemberController() {
		mv= new MemberView();
		mi= new MemberInfo();
		ma = new MemberAdd();
		
	}
	
	public void start() {
		boolean check = true;
		
		while(check) {
			sc = new Scanner(System.in);
			System.out.println("1. 멤버정보 가져오기  2. 멤버정보 출력하기  3. 멤버 검색 출력하기  4. 소속사또는 그룹명으로 검색   5. 멤버 추가  6. 백   업   7. 종료");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				ar = mi.getMembers();
				System.out.println("멤버 가져오기 성공");
				break;
				
			case 2:
				if(ar==null) {
				System.out.println("멤버 정보가 없습니다");
				} else {
					mv.view(ar);
				}
				break;
			case 3:
				Member m =mi.searchMember(sc, ar);
				if(m!=null) {
				mv.view(m);
				} else {
					mv.view("멤버가 없습니다");
				}
				break;
			case 4:
				ArrayList<Member> ar2 = mi.searchGroup(sc, ar);
				if(ar2.size() != 0) {
					mv.view(ar2);
				} else {
					mv.view("입력한 정보가 없습니다");
				}
				break;
			case 5:
				Member m1 = ma.addMember(sc, ar);
				ar.add(m1);
			break;
			case 6:
				ma.backUp(ar);
				break;
			default :
				System.out.println("프로그램 종료");
				check = !check;
			}
		}
	}
}
