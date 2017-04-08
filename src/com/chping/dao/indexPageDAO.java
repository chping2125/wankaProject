package com.chping.dao;

import java.util.List;

import com.chping.entity.Nav;
import com.chping.entity.News;
import com.chping.entity.Product;
import com.chping.entity.Type;

public interface indexPageDAO {
	
	/**
	 * 获取首页商品类型
	 * */
	public List<Type> getType();
	
	/**
	 * 获取首页导航条信息
	 * */
	public List<Nav> getNav();
	
	/**
	 * 获取首页明星单品
	 * */
	public List<Product> getStartPro();
	
	/**
	 * 获取首页新品left
	 * */
	public List<Product> getNewPro();
	
	/**
	 * 获取首页新品right
	 * */
	public List<Product> getNewPro2();
	
	/**
	 * 获取首页新闻
	 * */
	public List<News> getNews();
	
	/**
	 * 获取首页大家都喜欢产品left
	 * */
	public List<Product> getalLovePro();
	
	/**
	 * 获取首页大家都喜欢产品right
	 * */
	public List<Product> getalLovePro2();
	
	/**
	 * 获取首页热评商品
	 * */
	public List<Product> getHotPro();
	
	/**
	 * 获取首页热评商品
	 * */
	public List<Product> getSalePro();
}
