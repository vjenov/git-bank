package com.bank.web.controllers;
import java.util.Random;
import javax.swing.JOptionPane;

import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimples.MemberServiceImpl;
import com.bank.web.services.MemberService;
public class MemberController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		CustomerBean custom = null;
		MemberBean member = null;
		MemberService service = new MemberServiceImpl();
		String msg = "";
		String[] arr = {};
		String temp = "";
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료, 1. 회원가입, 2. 회원전체보기, "
					+ "3. 이름으로 찾기, 4. 아이디로 찾기, 5. 로그인, 6. 전체회원수, 7. 아이디존재여부, "
					+ "8. 비번업데이트, 9. 회원탈퇴")) {
				case "0" :
					return;
				case "1" :
					temp = JOptionPane.showInputDialog("아이디, 비밀번호, 이름을 입력하세요");
					System.out.println("****" + temp);
					arr = temp.split(",");
					member = new MemberBean();
					member.setId(arr[0]);
					member.setPw(arr[1]);
					member.setName(arr[2]);
					break;
				case "2" :
					JOptionPane.showMessageDialog(null, service.findAllCustomers());
					break;
				case "3" :
					String searchWho = JOptionPane.showInputDialog("이름입력 혹은 아이디입력");
					JOptionPane.showMessageDialog(null, member);
					break;
				case "4" :
					String findId = JOptionPane.showInputDialog("아이디입력");
					service.findById(findId);
					JOptionPane.showMessageDialog(null, custom);
					break;
				case "5" :
					String loginValue = JOptionPane.showInputDialog("아이디입력,비번입력");
					String[] loginValues = loginValue.split(",");
					String loginId = loginValues[0];
					String loginPw = loginValues[1];
					custom = new CustomerBean();
					custom.setId(loginId);
					custom.setPw(loginPw);
					msg = "로그인 실패";
					if(service.login(custom) == true) {
						msg = "로그인 성공";
					}
					JOptionPane.showMessageDialog(null, msg);
					break;
				case "6" :
					custom = new CustomerBean();
					JOptionPane.showMessageDialog(null, service.countCustomers());
					break;
				case "7" :
					String existId = JOptionPane.showInputDialog("아이디입력");
					service.existId(existId);
					msg = "가입 가능한 아이디입니다.";
					if(service.existId(existId) == true) {
						msg = "이미 존재하는 아이디입니다.";
					}
					JOptionPane.showMessageDialog(null, msg);
					break;
				case "8" :
					temp = JOptionPane.showInputDialog("아이디,현재비번입력,신규비번입력");
					arr = temp.split(",");
					member = new MemberBean();
					member.setId(arr[0]);
					member.setPw(arr[1]+","+arr[2]);
					break;
				case "9" :
					temp = JOptionPane.showInputDialog("아이디,비번입력");
					arr = temp.split(",");
					member.setId(arr[0]);
					member.setPw(arr[1]);
					break;
					
					
			}
		}
	}

}
