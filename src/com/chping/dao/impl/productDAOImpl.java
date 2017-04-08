package com.chping.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.chping.dao.productDAO;
import com.chping.entity.Product;

@Repository("productDAO")
public class productDAOImpl extends baseDAO implements productDAO {
	
	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getIndexProduct(int tag) {
		System.out.println("productdao-->getIndexProduct:"+tag);
		session = getSession();
		String hql = "";
		if(tag == 1 ){
			hql = "FROM Product p WHERE p.hot = 1";
		}else {
			hql = "FROM Product p WHERE p.newP = 1";
		}
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		System.out.println(list);
		if(list.size() != 0){
			System.out.println("dao success");
			return list;
		}
		System.out.println("dao fail or hotProduct null");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Product getProductById(String productId) {
		System.out.println("productdao-->getProductById:"+productId);
		session = getSession();
		String hql = "FROM Product p WHERE p.pid='"+productId+"'";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		System.out.println(list);
		if(list.size() != 0){
			System.out.println("dao success");
			return list.get(0);
		}
		System.out.println("dao fail");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByType(int type) {
		System.out.println("productdao-->getProductsByType:"+type);
		session = getSession();
		String hql = "FROM Product p WHERE p.type='"+type+"'";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		System.out.println(list);
		if(list.size() != 0){
			System.out.println("dao success");
			return list;
		}
		System.out.println("dao fail");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean addProduct(Product product) {
		System.out.println("productdao-->addProduct:"+product);
		//查询数据库中有无该产品
		String hqlString ="FROM Product p WHERE p.pid = '"+product.getPid()+"'";
		session = getSession();
		Query query = session.createQuery(hqlString);
		List<Product> list = query.list();
		System.out.println(list.size());
		if(list.size() != 0 ){
			session.merge(product);
			
			System.out.println("dao success");
			return true;
		}else{
			//没有则直接插入
			//查询数据库产品数量
			hqlString ="SELECT COUNT(*) FROM Product";
			
		    long num = (long) session.createQuery(hqlString).uniqueResult();
		    //插入数据到数据库
			session.save(product);
			//执行HQL语句时，会隐形的调用flush()方法，而此时执行sava方法时，需要显性调用flush()方法。
			session.flush();
			
			//判断数据是否插入成功
			long num2 = (long) session.createQuery(hqlString).uniqueResult();
			if(num + 1 == num2){
				System.out.println("dao success");
				return true;
			}
		}
	    System.out.println("dao fail");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByName(String name) {
		System.out.println("productdao-->getProductsByType:"+name);
		session = getSession();
		String hql = "FROM Product p WHERE p.name like '%"+name+"%'";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		System.out.println(list);
		if(list.size() != 0){
			System.out.println("dao success");
			return list;
		}
		System.out.println("dao fail");
		return null;
	}

}
