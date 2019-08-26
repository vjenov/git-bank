package com.bitcamp.serviceimples;
import com.bitcamp.domains.AccountBean;
import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private CustomerBean[] custom;
	private AdminBean[] admin;
	private int count = 0;
	private int adminCount = 0;
	@Override
	public void join(CustomerBean param) {
			// TODO Auto-generated method stub
		custom[count] = param;
		count++;
	}
	public void adminJoin(AdminBean param) {
		admin[adminCount] = param;
		adminCount++;
	}
	@Override
	public CustomerBean[] findAllCustomers() {
		return custom;
	}

	@Override
	public CustomerBean[] findByName(String name) {
		int j = 0;
		for(int i =0;i< count;i++) {
			if(name.equals(this.custom[i].getName())) {
				j++;
			}
		}
		custom = new CustomerBean[j];
		j = 0;
		for(int i=0; i< count;i ++) {
			if(name.equals(this.custom[i].getName())) {
				custom[j] = this.custom[i];
				j++;
				if(custom.length == j) {
					break;
				}
			}
			
			custom[i] = this.custom[i];
		}
		return custom;
	}

	@Override
	public CustomerBean findById(String id) {
		CustomerBean custom = new CustomerBean();
		for(int i = 0; i < count; i++) {
			if(id.equals(this.custom[i].getId())) {
				custom = this.custom[i];
				break;
			}
		}
		return custom;
	}

	@Override
	public boolean login(CustomerBean param) {
		
		String id = param.getId();
		String pw = param.getPw();
		boolean result = false;
		for(int i = 0; i < count; i++) {
			if(id.equals(custom[i].getId())&& param.getPw().equals(custom[i].getPw())) {
				result = true;
			}
			break;
		}
		return result;
	}

	@Override
	public int countCustomers() {
		return count;
	}

	@Override
	public boolean existId(String id) {
		boolean result = false;
		for(int i =0; i < count; i++) {
			if(id.equals(custom[i].getId())) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void updatePass(CustomerBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(CustomerBean param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int countAdimins() {
		// TODO Auto-generated method stub
		return adminCount;
	}

}	