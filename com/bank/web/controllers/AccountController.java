package com.bank.web.controllers;
import javax.swing.JOptionPane;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceimples.AccountServiceImpl;

import java.util.Random;
public class AccountController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountBean ab = null;
		AccountServiceImpl service = new AccountServiceImpl();
		Random ran = new Random();
		String result;
		String temp;
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료, 1. 계좌생성, 2. 모든 계좌정보, 3. 번화로 계좌찾기, "
					+ "4. 전체개설계좌수, 5. 계좌번호존재여부, 6. 금액입금, 7. 금액인출, 8. 계좌삭제")) {
				case "0" :
					return;
				case "1" :
					String money = JOptionPane.showInputDialog("입금할 금액 입력");
					service.createAccount(Integer.parseInt(money));
					JOptionPane.showMessageDialog(null, service.creatAccountNum());
					break;
				case "2" :
					JOptionPane.showMessageDialog(null, service.findAll());
					break;
				case "3" :
					ab = new AccountBean();
					result = JOptionPane.showInputDialog("계좌번호 입력");
					service.findByAccountNum(result);
					JOptionPane.showMessageDialog(null, service.findByAccountNum(result));
					break;
				case "4" :
					JOptionPane.showMessageDialog(null, service.countAccounts());
					break;
				case "5" :
					ab = new AccountBean();
					String msg = "없는 계좌번호입니다.";
					result = JOptionPane.showInputDialog("계좌번호 입력");
					ab.setAccountNum(result);
					if(service.existAccountNum(result) == true) {
						msg = "현재 사용 중인 계좌번호입니다.";
					}
					JOptionPane.showMessageDialog(null, msg);
					break;
				case "6" :
					temp = JOptionPane.showInputDialog("계좌번호,입금할 금액 입력");
					String[] arr1 = temp.split(",");
					ab = new AccountBean();
					ab.setAccountNum(arr1[0]);
					ab.setMoney(arr1[1]);
					break;
				case "7" :
					temp = JOptionPane.showInputDialog("계좌번호,인출할 금액 입력");
					String[] arr2 = temp.split(",");
					ab = new AccountBean();
					ab.setAccountNum(arr2[0]);
					ab.setMoney(arr2[1]);
					break;
				case "8" :
					service.deleteAccountNum(JOptionPane.showInputDialog("계좌번호 입력"));
					break;
					}
	}

	}
}
