package com.chping.entity;

/**
 * @author chengping
 *
 */

public class CartProduct {
	private Cart cart;
	private Product product;
	
	public CartProduct() {
		super();
	}

	public CartProduct(Cart cart, Product product) {
		super();
		this.cart = cart;
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartProduct [cart=" + cart + ", product=" + product + "]";
	}
	
}
