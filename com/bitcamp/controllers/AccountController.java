package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.AccountBean;
import java.util.Random;
public class AccountController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random(4);
		AccountBean ab = new AccountBean();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료, 1. 계좌번호 생성")) {
				case "0" :
					return;
				case "1" :
					String money = JOptionPane.showInputDialog("입금할 금액 입력");
					ab.setMoney(money);
					ab.setAccountNum(ran.next());
					
		}
	}

	}
}
