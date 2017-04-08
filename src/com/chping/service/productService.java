package com.chping.service;

import java.util.List;

import com.chping.entity.Product;

public interface productService {

	/**
	 *获取首页商品信息
	 *@param 1：热门商品 2：新品上市
	 *@return  product实体list
	 **/
	public List<Product> getIndexProduct(int tag);
	
	/**
	 *根据ID获取商品信息
	 *@param productId 商品ID
	 *@return  product实体l
	 **/
	public Product getProductById(String productId);
	
	/**
	 *根据ID获取商品信息
	 *@param productName 商品名称
	 *@return  product实体
	 **/
	public List<Product> getProductByName(String productName);
	
	/**
	 *根据type获取商品
	 *@param type 商品类型
	 *@return  商品列表
	 **/
	public List<Product> getProductsByType(int type);
	
	/**
	 *添加商品
	 *@param product 实体
	 *@return  true/false
	 **/
	public Boolean addProduct(Product product);
	
	/**
	 *获取新产品商品
	 *@param index 新品数量
	 *@return  productList
	 **/
	public List<Product> getProductList(int index,int pageNum,int pageTotal);
}
