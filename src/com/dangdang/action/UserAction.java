package com.dangdang.action;

import java.util.Map;

import com.dangdang.entity.User;
import com.dangdang.service.UserService;
import com.dangdang.service.impl.UserServiceImpl;
import com.dangdang.utils.MailUtil;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private User user;
	private UserService us = new UserServiceImpl();
	private String qrCode;
	
	public String login(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		System.out.println(user);
		user = us.login(user.getEmail(), user.getPassword());
		System.out.println(user);
		if(user!=null){
			session.put("user", user);
			return "toMain";
		}
		return "toLogin.jsp";
	}
	
	public String register(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String code = (String)session.get("code"); 
		if(qrCode.equalsIgnoreCase(code)){
			us.register(user);
			MailUtil.sendSimpleMail(user.getEmail());
			return "toVerify_form.jsp";
			
		}
		return "error";
	}
	
	public String key(){
		us.activation(user.getEmail());
		return "toRegisterOk.jsp";
	}
	public String loginOut(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return "toMain";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
}
