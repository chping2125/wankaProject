package com.chping.dao;

import java.util.List;

import com.chping.entity.Cart;

public interface cartDAO {

	/**
	 * 根据Id删除购物车内的一条信息
	 * @param cartId 待删除的id
	 * @return true/false
	 * */
	public Boolean delCartById(String cartId);
	
	/**
	 * 根据购物车Id更新购物车商品数量
	 * @param cartId 待更新的id
	 * @param cartNum 待更新的商品数量
	 * @param cartTotal 待更新的商品总价
	 * @return true/false
	 * */
	public int upDate(String cartId,String cartNum,String cartTotal);
	
	/**
	 *添加购物车信息
	 *@param cart 实体
	 **/
	public Boolean addCart(Cart cart);
	
	/**
	 * 根据用户id获取该用户购物车内的信息
	 * @param userId 该用户的ID/该产品ID
	 * @param tag 1:通过userID查询,2:通过productID查询
	 * @return cart实体
	 * */
	public List<Cart> getCart(String Id,int tag);
	
	/**
	 * 根据用户id和产品ID获取购物车信息
	 * @param userId 该用户的ID
	 * @param productId 该产品ID
	 * @return cart实体
	 * */
	public Cart getCart(String userId,String productId);	
	
}
