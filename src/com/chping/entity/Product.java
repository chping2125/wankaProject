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
@Table(name="product")
@Scope("prototype")
public class Product {
	private String pid;
	private String name;
	private int type;//商品类型1：智能生活 2手机个性化配件 3充电和移动电源 4耳机与音箱 5电脑与家电配件 6Apple配件 7 玩咖生活方式 8 增值业务
	private String image;
	private String price;
	private String originPrice;
	private int hot;//热门商品 1：是 0：不是
	private int newP;//热门商品 1：是 0：不是
	private int stP;//明星商品 1：是 0：不是
	private int alP;//大家都喜欢商品 1：是 0：不是
	private int saleP;//折扣商品 1：是 0：不是
	private String content;
	private String res1; //是否包邮1：是0：不是
	private String res2; //星星等级12345
	private String res3; //预留字段3
	
	public Product() {
		
	}

	public Product(String pid, String name, String image, String price,
			String content) {
		super();
		this.pid = pid;
		this.name = name;
		this.image = image;
		this.price = price;
		this.content = content;
	}
	
	public Product(String pid, String name, int type, String image,
			String price, int hot, int newP, String content) {
		super();
		this.pid = pid;
		this.name = name;
		this.type = type;
		this.image = image;
		this.price = price;
		this.hot = hot;
		this.newP = newP;
		this.content = content;
	}



public Product(String pid, String name, int type, String image,
			String price, String originPrice, int hot, int newP, int stP,
			int alP, int saleP, String content, String res1, String res2,
			String res3) {
		super();
		this.pid = pid;
		this.name = name;
		this.type = type;
		this.image = image;
		this.price = price;
		this.originPrice = originPrice;
		this.hot = hot;
		this.newP = newP;
		this.stP = stP;
		this.alP = alP;
		this.saleP = saleP;
		this.content = content;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
	}

		@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pid", unique = true, nullable = false, length = 100)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name="name",nullable = false, length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="type", length=10)
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name="image",nullable = false, length=200)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="price",nullable = false, length=100)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Column(name="originPrice",nullable = false, length=100)
	public String getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(String originPrice) {
		this.originPrice = originPrice;
	}
	
	@Column(name="hot",length=10)
	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}
	
	@Column(name="newP",length=10)
	public int getNewP() {
		return newP;
	}

	public void setNewP(int newP) {
		this.newP = newP;
	}
	
	@Column(name="stP",length=10)
	public int getStP() {
		return stP;
	}

	public void setStP(int stP) {
		this.stP = stP;
	}

	@Column(name="saleP",length=10)
	public int getSaleP() {
		return saleP;
	}

	public void setSaleP(int saleP) {
		this.saleP = saleP;
	}

	@Column(name="alP",length=10)
	public int getAlP() {
		return alP;
	}

	public void setAlP(int alP) {
		this.alP = alP;
	}

	@Column(name="content",nullable = false, length=500)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Product [pid=" + pid + ", name=" + name + ", type=" + type
				+ ", image=" + image + ", price=" + price + ", originPrice="
				+ originPrice + ", hot=" + hot + ", newP=" + newP + ", stP="
				+ stP + ", alP=" + alP + ", saleP=" + saleP + ", content="
				+ content + ", res1=" + res1 + ", res2=" + res2 + ", res3="
				+ res3 + "]";
	}

}
