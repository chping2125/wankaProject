package com.chping.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chping.dao.indexPageDAO;
import com.chping.dao.productDAO;
import com.chping.entity.Product;
import com.chping.service.productService;

@Service("productService")
public class productServiceImpl implements productService {

	@Autowired
	private productDAO dao;
	@Autowired
	private indexPageDAO indexPageDAO;
	
	@Override
	public List<Product> getIndexProduct(int tag) {
		System.out.println("productService-->getIndexProduct:"+tag);
		List<Product> list = dao.getIndexProduct(tag);
		if(list.size() != 0){
			List<Product> list2 = new ArrayList<Product>();
			for (int i = 0; i < 4; i++) {
				list2.add(list.get(i));
			}
			System.out.println("service success");
			return list2;
		}
		System.out.println("service fail or hotProduct null");
		return null;
	}
	@Override
	public Product getProductById(String productId) {
		System.out.println("productService-->getProductById:"+productId);
		Product p = dao.getProductById(productId);
		if(p != null){
			System.out.println("service success");
			return p;
		}
		System.out.println("service fail");
		return null;
	}
	@Override
	public List<Product> getProductsByType(int type) {
		System.out.println("productService-->getProductsByType:"+type);
		List<Product> list = dao.getProductsByType(type);
		if(list != null){
			System.out.println("service success");
			return list;
		}
		System.out.println("service fail");
		return null;
	}
	@Override
	public Boolean addProduct(Product product) {
		System.out.println("productService-->addProduct:"+product);
		
		if(dao.addProduct(product)){
			System.out.println("service success");
			return true;
		}
		System.out.println("service fail");
		return false;
	}
	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> list = dao.getProductsByName(productName);
		
		return list;
	}
	@Override
	public List<Product> getProductList(int index,int pageNum,int pageTotal) {
		List<Product> list = indexPageDAO.getNewPro();
		List<Product> newlist = new ArrayList<Product>();
		
		if(index != 0){
	    	for(int i=0;i<index;i++){
	    		newlist.add(list.get(i));
	    	}
	    	return newlist;
		}
		if(pageNum !=0 && pageTotal !=0){
			if(pageNum*pageTotal<=list.size()){
				for(int i=pageNum*pageTotal-1;i<pageNum*pageTotal-1+pageTotal;i++){
		    		newlist.add(list.get(i));
		    	}
			}
	    	return newlist;
		}
		return list;
	}

}
