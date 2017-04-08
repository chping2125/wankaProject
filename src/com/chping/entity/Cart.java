package com.chping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="cart")
@Scope("prototype")
public class Cart {
	private String id;
	private String userId;
	private String productId;
	private String number;
	private String total;
	private String res1; //预留字段1
	private String res2; //预留字段2
	private String res3; //预留字段3
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(String id, String userId, String productId,
			String number, String total) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.number = number;
		this.total = total;
	}

	public Cart(String userId, String productId, String number, String total) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.number = number;
		this.total = total;
	}

	public Cart(String id, String userId, String productId,
			String number, String total, String res1, String res2, String res3) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.number = number;
		this.total = total;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
	}

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="userId",nullable = false, length=100)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="productId",nullable = false, length=100)
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name="number",nullable = false, length=50)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="total",nullable = false, length=50)
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Column(name = "res1", length = 500)
	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	@Column(name = "res2", length = 500)
	public String getRes2() {
		return res2;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	@Column(name = "res3", length = 500)
	public String getRes3() {
		return res3;
	}

	public void setRes3(String res3) {
		this.res3 = res3;
	}

	@Override
	public String toString() {
		return "cart [id=" + id + ", userId=" + userId + ", productId="
				+ productId + ", number=" + number + ", total=" + total
				+ ", res1=" + res1 + ", res2=" + res2 + ", res3=" + res3 + "]";
	}
	
}
