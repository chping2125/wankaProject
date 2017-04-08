package com.chping.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class baseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//事务必须是开启的(Required)，否则获取不到
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
