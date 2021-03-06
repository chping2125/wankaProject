package com.chping.service;

import com.chping.entity.User;

public interface userService {

	/**
	 * 登陆
	 * @param user 登陆对象实体
	 * @return 登陆的对象实体
	 * */
	public User login(User user);
	
	/**
	 * 注册
	 * @param user 注册实体
	 * @return true/false
	 * */
	public Boolean registered(User user);
	
	/**
	 * 判断该用户是否存在
	 * @param username 待检测用户名
	 * @return true/false
	 * */
	public Boolean getUsers(String username);
	
	/**
	 * 根据用户名获取用户密码
	 * @param user 修改实体
	 * @return true/false
	 * */
	public Boolean editPassword(User user);
	
}
