package com.bank.web.serviceimples;
import java.util.Random;
import com.bank.web.domains.*;
import com.bank.web.services.AccountService;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] accounts;
	int count;
	Random ran;
	
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
	}
	public void createAccount(int money) {
		AccountBean acc = new AccountBean();
		acc.setMoney(money+"");
		acc.setAccountNum(creatAccountNum());
		acc.setToday(findDate());
		accounts[count] = acc;
		count++;
	}

	@Override
	public String creatAccountNum() {
		String accountNum = "";
		Random ran = new Random();
		for(int i=0; i<9; i++) {
			accountNum += (i==4)? "-" :ran.nextInt(10);
		}
		return accountNum;
	}

	@Override
	public AccountBean[] findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(accountNum);
		for(int i = 0;i < count;i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
			acc = accounts[i];
			break;
			}
		}
		return acc;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		AccountBean acc = new AccountBean();
		acc.setAccountNum(accountNum);
		for(int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		for(int i = 0; i < count; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				accounts[i].setMoney(String.valueOf(Integer.parseInt(accounts[i].getMoney()) 
						+ Integer.parseInt(param.getMoney())));
				break;
			}
		}
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		for(int i = 0; i < count; i++) {
			if(param.getAccountNum().equals(accounts[i].getAccountNum())) {
				accounts[i].setMoney(String.valueOf(Integer.parseInt(accounts[i].getMoney()) 
						- Integer.parseInt(param.getMoney())));
				break;
			}
		}
		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		for(int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = accounts[count-1];
				count--;
				break;
			}
		}
	}
}