package com.chping.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chping.entity.User;
import com.chping.service.userService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/web")
public class userAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session; //session载体
	private Map<String, Object> dataMap; //json数据传输载体
	private String oldPassword; //修改密码时的老密码
	private User user;
	@Autowired
	private userService userService;
	public userAction() {
		//获取session对象
		session = ActionContext.getContext().getSession();
		//初始化Map对象  
        dataMap = new HashMap<String, Object>(); 
	}
	
	@Action(value="login",results={@Result(type="json",params={"root","dataMap"})})
	public String Login(){
		if(user.getUsername() !=null&&user.getPassword()!=null){
			System.out.println("indexAction-->login"+user);
			user = userService.login(user);
			if(user !=null){
				//保存当前登录用户信息
				session.put("Androidlogined", user);
				//向android发送登陆成功的数据
				System.out.println("action true");
				try {
					dataMap.clear();
					dataMap.put("message", "success");
					dataMap.put("logined", user);
				} catch (Exception e) {
					System.out.println(e);
				}
				return SUCCESS;
			}
			//登陆失败，向前台发送错误信息
			System.out.println("登陆失败");
			session.put("Androidmessage", "fail");
			try {
				dataMap.clear();
				dataMap.put("message", "fail");
			} catch (Exception e) {
				System.out.println(e);
			}
			return SUCCESS;
		}
		//传输数据有null值，向前台发送错误信息
		System.out.println("有null值");
		session.put("Androidmessage", "null");
		try {
			dataMap.clear();
			dataMap.put("message", "null");
		} catch (Exception e) {
			System.out.println(e);
		}
		return SUCCESS;
	}
	
	@Action(value="registered",results={@Result(type="json",params={"root","dataMap"})})
	public String Registered(){
		System.out.println("indexAction-->registered"+user);
		if(user.getUsername() !=null&&user.getPassword()!=null&&!user.getUsername().equals("")&&!user.getPassword().equals("")){
			//防止重复注册
			if(!userService.getUsers(user.getUsername())){
				//开始注册
				if(userService.registered(user)){
					//注册成功，向android发送成功数据
					System.out.println("action true");
					session.put("Androidmessage", "success");
					try {
						dataMap.clear();
						dataMap.put("message", "success");
					} catch (Exception e) {
						System.out.println(e);
					}
					return SUCCESS;
				}
				//注册失败，向android发送错误信息
				System.out.println("注册失败");
				session.put("Androidmessage", "fail");
				try {
					dataMap.clear();
					dataMap.put("message", "fail");
				} catch (Exception e) {
					System.out.println(e);
				}
				return SUCCESS;
			}
			//重复注册，向android发送错误信息
			System.out.println("重复注册");
			session.put("Androidmessage", "重复注册");
			try {
				dataMap.clear();
				dataMap.put("message", "repeatedRegistered");
			} catch (Exception e) {
				System.out.println(e);
			}
			return SUCCESS;
		}
		//传输数据有null值，向android发送错误信息
		System.out.println("有null值");
		session.put("Androidmessage", "null");
		try {
			dataMap.clear();
			dataMap.put("message", "null");
		} catch (Exception e) {
			System.out.println(e);
		}
		return SUCCESS;
	}
	
	@Action(value="editPassword",results={@Result(type="json",params={"root","dataMap"})})
	public String EditPassword(){
		if(user.getUsername() !=null&&user.getPassword()!=null&&oldPassword !=null){
			System.out.println("indexAction-->editPassword"+ user);
			//获取当前登录的用户
			User u = (User) session.get("Androidlogined");
			//验证原密码是否正确
			if(u.getPassword().equals(oldPassword)){
				//修改密码
				if(userService.editPassword(user)){
					System.out.println("anction success");
					//修改成功，更新session中的登陆用户信息
					user.setId(u.getId());
					user.setPassword(user.getPassword());
					session.put("Androidlogined", user);
					//向android发送修改成功的信息
					session.put("Androidmessage", "success");
					try {
						dataMap.clear();
						dataMap.put("message", "success");
						dataMap.put("logined", user);
					} catch (Exception e) {
						System.out.println(e);
					}
					return SUCCESS;
				}
				//修改密码失败，向android发送错误信息
				System.out.println("action fail");
				session.put("Androidmessage", "fail");
				try {
					dataMap.clear();
					dataMap.put("message", "fail");
				} catch (Exception e) {
					System.out.println(e);
				}
				return SUCCESS;
			}
			//原密码错误，向android发送错误信息
			System.out.println("原密码错误");
			session.put("Androidmessage", "原密码错误");
			try {
				dataMap.clear();
				dataMap.put("message", "OldPasswordMistake");
			} catch (Exception e) {
				System.out.println(e);
			}
			return SUCCESS;
		}
		//传输数据有null值，向android发送错误信息
		System.out.println("有null值");
		session.put("Androidmessage", "null");
		try {
			dataMap.clear();
			dataMap.put("message", "null");
		} catch (Exception e) {
			System.out.println(e);
		}
		return SUCCESS;
	}
	
	@Action(value="checkLogin",results={@Result(type="json",params={"root","dataMap"})})
	public String checkLogin(){
		User user = (User)session.get("Androidmessage");
		dataMap.clear();
		if(user != null){
			if(user.getUsername()!=null){
				dataMap.put("message", true);
				return SUCCESS;
			}
		}
		dataMap.put("message", false);
		return SUCCESS;
	}
	
	@Action(value="checkUsername",results={@Result(type="json",params={"root","dataMap"})})
	public String checkUsername(){
		dataMap.clear();
		if(userService.getUsers(user.getUsername())){
			dataMap.put("message", true);
			return SUCCESS;
		}
		dataMap.put("message", false);
		return SUCCESS;
	}
	
	@Action(value="outLogin",results={@Result(type="json",params={"root","dataMap"})})
	public String outLogin(){
		dataMap.clear();
		if(!user.getUsername().equals("")&&user.getUsername()!=null){
			session.remove("Androidlogined");
			dataMap.put("message", true);
			return SUCCESS;
		}
		dataMap.put("message", false);
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

}
