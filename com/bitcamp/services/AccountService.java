package com.bitcamp.services;
import com.bitcamp.domains.AccountBean;

public interface AccountService {
	void createAccount(int money);
	public String creatAccountNum();
	//계좌번호 생성 (1234-5678)
	public AccountBean[] findAll();
	AccountBean findByAccountNum(String accountNum);
	int countAccounts();
	boolean existAccountNum(String accountNum);
	String findDate(); // 오늘 날짜, 현재 시간(분까지) 반환
	void depositMoney(AccountBean param);
	void withdrawMoney(AccountBean param);
	void deleteAccountNum(String accountNum);
}
