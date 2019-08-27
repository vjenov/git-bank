package com.bank.web.services;
import com.bank.web.domains.*;

public interface AccountService {
	public void createAccount(int money);
	public String creatAccountNum();
	//계좌번호 생성 (1234-5678)
	public AccountBean[] findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccounts();
	public boolean existAccountNum(String accountNum);
	public String findDate(); // 오늘 날짜, 현재 시간(분까지) 반환
	public void depositMoney(AccountBean param);
	public void withdrawMoney(AccountBean param);
	public void deleteAccountNum(String accountNum);
}
