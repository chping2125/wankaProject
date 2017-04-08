package com.chping.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chping.dao.userDAO;
import com.chping.entity.User;
import com.chping.service.userService;

@Service("userService")
public class userServiceImpl implements userService {
	@Autowired
	private userDAO dao;

	@Override
	public User login(User user) {
		System.out.println("userService-->login"+user.getUsername()+user.getPassword());
		if(user != null){
			user = dao.login(user);
			if(user != null){
				System.out.println("service success");
				return user;
			}
		}
		System.out.println("service error");
		return null;
	}

	@Override
	public Boolean registered(User user) {
		System.out.println("userService-->registered"+user.getUsername()+user.getPassword());
		if(user != null){
			if(dao.registered(user)){
				System.out.println("service success");
				return true;
			}
		}
		System.out.println("service error");
		return false;
	}

	@Override
	public Boolean editPassword(User user) {
		System.out.println("userService-->editPassword"+user.getUsername()+user.getPassword());
		if(user != null){
			if(dao.editPassword(user)){
				System.out.println("service success");
				return true;
			}
		}
		System.out.println("service fail");
		return false;
	}

	@Override
	public Boolean getUsers(String username) {
		System.out.println("userService-->getUsers"+username);
		if(username != null){
			if(dao.getUsers(username)){
				System.out.println("service success");
				return true;
			}
		}
		System.out.println("service fail");
		return false;
	}


}
