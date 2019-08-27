package com.bank.web.serviceimples;
import com.bank.web.domains.AccountBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private CustomerBean[] customers;
	private MemberBean[] members;
	private EmployeeBean[] employees;
	private int custCount, empCount;
	
	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		employees = new EmployeeBean[10];
		custCount = 0;
		empCount = 0;
	}
	
	public void join(CustomerBean param) {
			// TODO Auto-generated method stub
		customers[custCount] = param;
		custCount++;
	}
	public void register(EmployeeBean param) {
		// TODO Auto-generated method stub
		employees[empCount] = param;
		empCount++;
	}
	
	public CustomerBean[] findAllCustomers() {
		return customers;
	}
	public EmployeeBean[] findAllEmployees() {
		return employees;
	}
	@Override
	public MemberBean[] findByName(String name, String id) {
		int count1 = 0, count2 =0, count3 =0;
		for(int i = 0;i < custCount;i++) {
			if(name.equals(customers[i].getName())) {
				count1++;
				break;
			}
		}
		for(int i = 0;i < empCount; i++) {
			if(name.equals(employees[i].getId())) {
				count2++;
				break;
			}
		}
		count3 = count1 + count2;
		MemberBean[] members = new MemberBean[count3];
		int j =0;
		for(int i = 0; i < count3; i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(count1==j) {
					break;
				}
			}
		}
		for(int i = 0; i < count3; i++) {
			if(name.equals(employees[i].getName())) {
				members[j] = employees[i];
				j++;
			}if(count2==j) {
				break;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i = 0; i < custCount; i++) {
			if(id.equals(customers[i].getId())) {
				member = customers[i];
				break;
			}
		}for(int i = 0; i < empCount; i++) {
			if(id.equals(employees[i].getId())) {
				member = employees[i];
				break;
			}
		}
		return member;
	}

	@Override
	public boolean login(MemberBean param) {
		return findById(param.getId()).getPw().equals(param.getPw());
	}

	@Override
	public int countCustomers() {
		return custCount;
	}
	public int countEmployees() {
		return empCount;
	}

	@Override
	public boolean existId(String id) {
		boolean flag = false;
		for(int i =0; i < custCount; i++) {
			if(id.equals(customers[i].getId())) {
				flag = true;
			}else if(id.equals(employees[i].getId())) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void updatePass(MemberBean param) {
		// TODO Auto-generated method stub
		String id = param.getId();
		String[] passWord = param.getPw().split(",");
		String oldPw = passWord[0];
		String newPw = passWord[1];
		param.setPw(oldPw);
		if(login(param)) {
			for(int i = 0; i < custCount; i++) {
				if(id.equals(customers[i].getId())) {
					customers[i].setPw(newPw);
					break;
				}
			}for(int i = 0; i < empCount; i++) {
				if(id.equals(employees[i].getId())) {
					employees[i].setPw(newPw);
					break;
				}
			}
		}
	}

	@Override
	public void deleteMember(MemberBean param) {
		MemberBean[] arr = new MemberBean[custCount-1];
		String id, pw;
		if(login(param)) {
			for(int i = 0; i < custCount; i++) {
				if(customers[i].getId().equals(param.getId())) {
				customers[i] = customers[custCount-1];
				custCount--;
				break;
				}
			}
			for(int i = 0; i < empCount-1; i++) {
				if(employees[i].getId().equals(param.getId()))
				employees[i] = employees[empCount-1];
				empCount--;
				break;
			}
		}
	}

}	