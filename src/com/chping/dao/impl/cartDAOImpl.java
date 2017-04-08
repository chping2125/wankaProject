package com.chping.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.chping.dao.cartDAO;
import com.chping.entity.Cart;

@Repository("cartDAO")
public class cartDAOImpl extends baseDAO implements cartDAO {

	private Session session;
	@Override
	public Boolean delCartById(String cartId) {
		System.out.println("cartDAO-->cartId"+cartId);
		
	    String hqlString ="DELETE FROM Cart c WHERE c.id='"+cartId+"'";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    int num = query.executeUpdate();
	    System.out.println("dao返回结果"+num);
	    if(num != 0){
	    	System.out.println("dao success");
	    	return true;
	    }
	    System.out.println("dao error");
		return false;
	}
	@Override
	public int upDate(String cartId, String cartNum,String cartTotal) {
		System.out.println("cartDAO-->upData:"+cartId+","+cartNum+","+cartTotal);
		
	    String hqlString ="UPDATE Cart c SET c.number='"+cartNum+"',c.total='"+cartTotal+"' "
	    		+ "WHERE c.id ='"+cartId+"'";
	    session=getSession();
	    Query query = session.createQuery(hqlString);
	    int num = query.executeUpdate();
	    System.out.println("dao返回结果"+num);
	    if(num != 0){
	    	System.out.println("dao success");
	    	return num;
	    }
	    System.out.println("dao error");
		return 0;
	}
	@Override
	public Boolean addCart(Cart cart) {
		System.out.println("dao-->addCart:"+cart);
		
		//查询数据库购物车数量
		session = getSession();
		String hqlString ="SELECT COUNT(*) FROM Cart";
	    long num = (long) session.createQuery(hqlString).uniqueResult();
	    //插入数据到数据库
		session.save(cart);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> getCart(String Id,int tag) {
		System.out.println("cartDAO-->getCart:"+Id+","+tag);
		session=getSession();
		String hqlString = "";
		if(tag == 1){
			hqlString ="FROM Cart c WHERE c.userId='"+Id+"'";
		}else if(tag== 2){
			hqlString ="FROM Cart c WHERE c.productId='"+Id+"'";
		}else{
			System.out.println("tag fail "+tag);
			return null;
		}
	    
	    Query query = session.createQuery(hqlString);
	    List<Cart> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() != 0){
	    	System.out.println("dao success");
	    	return list;
	    }
	    System.out.println("dao null or error");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Cart getCart(String userId, String productId) {
		System.out.println("cartDAO-->getCart:"+userId+","+productId);
		session=getSession();
		String hqlString = "FROM Cart c WHERE c.userId='"+userId+"' and c.productId = '"+productId+"'";
	    Query query = session.createQuery(hqlString);
	    List<Cart> list =  query.list();
	    System.out.println("dao返回结果"+list);
	    if(list.size() == 1){
	    	System.out.println("dao success");
	    	return list.get(0);
	    }
	    System.out.println("dao fail");
		return null;
	}
}
