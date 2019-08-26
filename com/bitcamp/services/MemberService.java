package com.bitcamp.services;
import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
public interface MemberService {
	void join(CustomerBean param);
	public void adminJoin(AdminBean param);
	CustomerBean[] findAllCustomers();
	CustomerBean[] findByName(String name);
	CustomerBean findById(String id);
	boolean login(CustomerBean param);
	int countCustomers();
	int countAdimins();
	boolean existId(String id);
	void updatePass(CustomerBean param);
	void deleteMember(CustomerBean param);
}
