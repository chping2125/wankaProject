package com.chping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.chping.dao.indexPageDAO;
import com.chping.entity.Nav;
import com.chping.entity.News;
import com.chping.entity.Product;
import com.chping.entity.Type;

@Repository("productType")
public class indexPageDAOImpl extends baseDAO implements indexPageDAO{

	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Type> getType() {
		System.out.println("productTypeDAO");
		
	    String hqlString ="FROM Type t";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Type> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	return list;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nav> getNav() {
		System.out.println("productTypeDAO-->getNav");
	    String hqlString ="FROM Nav";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Nav> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	return list;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getStartPro() {
		System.out.println("productTypeDAO-->getStartPro");
	    String hqlString ="FROM Product p WHERE p.stP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=0;i<8;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getNewPro() {
		System.out.println("productTypeDAO-->getNewPro");
	    String hqlString ="FROM Product p WHERE p.newP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	return list;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getNewPro2() {
		System.out.println("productTypeDAO-->getNewPro");
	    String hqlString ="FROM Product p WHERE p.newP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=list.size()-1;i>list.size()-4;i--){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> getNews() {
		System.out.println("productTypeDAO-->getNews");
	    String hqlString ="FROM News";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<News> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<News> newlist = new ArrayList<News>();
	    	for(int i=0;i<5;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getalLovePro() {
		System.out.println("productTypeDAO-->getalLovePro");
	    String hqlString ="FROM Product p WHERE p.alP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=0;i<4;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getalLovePro2() {
		System.out.println("productTypeDAO-->getalLovePro2");
	    String hqlString ="FROM Product p WHERE p.alP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=list.size()-1;i>list.size()-6;i--){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getHotPro() {
		System.out.println("productTypeDAO-->getHotPro");
	    String hqlString ="FROM Product p WHERE p.hot=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=0;i<4;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getSalePro() {
		System.out.println("productTypeDAO-->getSalePro");
	    String hqlString ="FROM Product p WHERE p.saleP=1";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    List<Product> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	List<Product> newlist = new ArrayList<Product>();
	    	for(int i=0;i<4;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
	    }
		return null;
	}

}
