package com.chping.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chping.dao.userDAO;
import com.chping.entity.User;

@Repository("userDAO")
public class userDAOImpl extends baseDAO implements userDAO{

	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public User login(User user) {
		System.out.println("userDAO-->login"+user.getUsername()+user.getPassword());
		
	    String hqlString ="FROM User u WHERE u.username='"+user.getUsername()+
	    		"' and u.password='"+user.getPassword()+"'";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<User> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	return list.get(0);
	    }
		return null;
	}

	@Override
	public Boolean registered(User user) {
		System.out.println("userDAO-->registered"+user.getUsername()+user.getPassword());
		//查询数据库user用户数量
		String hqlString ="SELECT COUNT(*) FROM User";
		session = getSession();
	    long num = (long) session.createQuery(hqlString).uniqueResult();
	    //插入数据到数据库
		session.save(user);
		//执行HQL语句时，会隐形的调用flush()方法，而此时执行sava方法时，需要显性调用flush()方法。
		session.flush();
		
		//判断数据是否插入成功
		long num2 = (long) session.createQuery(hqlString).uniqueResult();
		if(num + 1 == num2){
			System.out.println("dao success");
			return true;
		}
	    System.out.println("dao fail");
		return false;
	}


	@Override
	public Boolean editPassword(User user) {
		System.out.println("userDAO-->editPassword"+user.getUsername()+user.getPassword());
		String hqlString ="UPDATE User u SET u.password='"+user.getPassword()+
				"' WHERE u.username='"+user.getUsername()+"'";
		session=getSession();
		Query query = session.createQuery(hqlString);
		int num = query.executeUpdate();
		if(num == 1){
			System.out.println("dao success");
			return true;
		}
		System.out.println("dao fail");
		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean getUsers(String username) {
		System.out.println("userDAO-->getUsers"+username);
		//1.hql语句
	    String hqlString ="FROM User u WHERE u.username='"+username+"'";
	    session=getSession();
	    //执行hql
	    Query query = session.createQuery(hqlString);
	    List<User> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	return true;
	    }
		return false;
	}

	
}
