package com.dangdang.action;

import java.util.List;
import java.util.Map;

import com.dangdang.entity.Address;
import com.dangdang.entity.User;
import com.dangdang.service.AddressService;
import com.dangdang.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	private Address address;
	private List<Address> addressList;
	private AddressService as = new AddressServiceImpl();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String showAll(){
		User user = (User) session.get("user");
		if(user!=null){
			addressList = as.selectAll(user);
			return "my_address.jsp";
		}
		return "login.jsp";
	}
	
	public String add(){
		System.out.println("add");
		int id = ((User)session.get("user")).getId();
		as.insert(address);
		return "showAll";
	}
	
	public String defaultA(){
		as.updateDefault(address.getId());
		return "showAll";
	}
	
	public String delete(){
		as.delete(address.getId());
		return "showAll";
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public AddressService getAs() {
		return as;
	}

	public void setAs(AddressService as) {
		this.as = as;
	}
	
}
