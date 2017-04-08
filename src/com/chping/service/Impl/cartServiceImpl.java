package com.chping.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chping.dao.cartDAO;
import com.chping.entity.Cart;
import com.chping.entity.Product;
import com.chping.service.cartService;

@Service("cartService")
public class cartServiceImpl implements cartService {

	@Autowired
	private cartDAO dao; 
	
	@Override
	public Boolean delCartById(String cartId) {
		System.out.println("service-->cartId:"+cartId);
		if(cartId != null){
			if(dao.delCartById(cartId)){
				System.out.println("service success");
				return true;
			}
		}
		System.out.println("service error");
		return false;
	}

	@Override
	public int upDate(String cartId, String cartNum,String cartPrice) {
		System.out.println("service-->upData:"+cartId+","+cartNum);
		if(cartId != null&&cartNum != null&&cartPrice != null){
			int total = Integer.parseInt(cartNum)*Integer.parseInt(cartPrice);
			int num = dao.upDate(cartId,cartNum,total+"");
			if(num != 0){
				System.out.println("service success");
				return num;
			}
		}
		System.out.println("service error");
		return 0;
	}

	@Override
	public Boolean addCart(String useId, Product product, String productNum) {
		System.out.println("service-->addCart:"+useId+","+product+","+productNum);
		if(useId != null&&product != null&&productNum != null){
			int total = Integer.parseInt(productNum)*Integer.parseInt(product.getPrice());
			Cart cart = new Cart(useId,product.getPid(),productNum,total+"");
			if(dao.addCart(cart)){
				System.out.println("service success");
				return true;
			}
		}
		System.out.println("service error");
		return false;
	}
	
	@Override
	public List<Cart> getCart(String Id,int tag) {
		System.out.println("cartService-->getCart:"+Id+","+tag);
		if(Id != null){
			List<Cart> list = dao.getCart(Id,tag);
			if(list != null){
				System.out.println("service success");
				return list;
			}
		}
		System.out.println("service error or null");
		return null;
	}

	@Override
	public Cart getCart(String userId, String productId) {
		System.out.println("cartService-->getCart:"+userId+","+productId);
		if(userId != null&& productId !=null){
			Cart list = dao.getCart(userId,productId);
			if(list != null){
				System.out.println("service success");
				return list;
			}
		}
		System.out.println("service error or null");
		return null;
	}

}
