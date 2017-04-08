package com.chping.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chping.entity.Cart;
import com.chping.entity.CartProduct;
import com.chping.entity.Product;
import com.chping.entity.User;
import com.chping.service.cartService;
import com.chping.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/cart")
public class cartAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String checked;//需要删除的产品id
	private String productId;//产品ID顺序，用来确定产品数量的改变
	private String productNum;//产品数量
	private String userId;
	private String jumppage;
	private Map<String, Object> sessionMap;//session载体
	private Map<String, Object> jsonMap;//异步json返回载体
	@Autowired
	private cartService cartService;
	@Autowired
	private productService productService;
	
	public cartAction() {
		sessionMap = ActionContext.getContext().getSession();
		//初始化Map对象  
        jsonMap = new HashMap<String, Object>(); 
	}
	
	@Action(value="editCart",results={@Result(name="success",type="redirect",location="/logined/getCart"),
									@Result(name="error",type="redirect",location="/logined/getCart")})
	public String EditCart(){
		System.out.println("action editCart");
		System.out.println(productId);
		System.out.println(productNum);
		System.out.println(checked);
		if(productId != null&&productNum != null){
			//1.根据传过来 的id去删除购物车内的信息
			if(checked != null){
				delCart();
			}
			//2.更新数据库购物车商品数量
			if(checked == null){
				//如果checked为空时会报空指针异常
				setChecked("000000");
				updateCart();
			}else {
				updateCart();
			}
			System.out.println("action success");
			return SUCCESS;
		}
		System.out.println("action error");
		return ERROR;
	}
	
	@Action(value="addCart",results={@Result(type="json",params={"root","jsonMap"})})
	public String addCart(){
		System.out.println("action-->addCart:"+productNum+","+productId);
		jsonMap.clear();
		Product product;
		if(productId == null){
			product = (Product) sessionMap.get("product");
		}else {
			product =productService.getProductById(productId);
		}
		User user = (User) sessionMap.get("Androidmessage");
		if (user == null) {
			System.out.println("user null");
			jsonMap.put("message", "nologin");
			return SUCCESS;
		}
		if(product != null&&user !=null){
			//防止重复添加同一商品
			Cart cart = cartService.getCart(user.getId(),product.getPid());
			if(cart == null){
				if(cartService.addCart(user.getId(),product,productNum)){
					System.out.println("action success");
					//向前台和session中分别添加购物车的数量和总价
					int num = (int) sessionMap.get("loginedCartNum") +Integer.parseInt(productNum);
					int total = (int) sessionMap.get("loginedCartTotal") +Integer.parseInt(product.getPrice())*Integer.parseInt(productNum);
					sessionMap.put("loginedCartNum", num);
					sessionMap.put("loginedCartTotal", total);
					
					jsonMap.put("message", "success");
					jsonMap.put("num", num);
					jsonMap.put("total", total);
					return SUCCESS;
				}
			}
			System.out.println("action success");
			jsonMap.put("message", "already");
			return SUCCESS;
		}
		System.err.println("action fail");
		jsonMap.put("message", "fail");
		return ERROR;
	}
	
	@Action(value="getCart",results={@Result(type="json",params={"root","jsonMap"})})
	public String getCart(){
		System.out.println("anction getCart");
		//先置空购物车
		sessionMap.put("loginedCartProduct", null);
		sessionMap.put("loginedCartNum", null);
		sessionMap.put("loginedCartTotal", null);
		Cart cart = new Cart();
		int productNum = 0;//商品数量
		int productTotal = 0;//商品的价格
		List<CartProduct> cplist= new ArrayList<CartProduct>();//每一件商品的信息
		List<Cart> clist= cartService.getCart(userId,1);
		if(clist != null){
			for (int i = 0; i < clist.size(); i++) {
				cart = clist.get(i);
				CartProduct cProduct = new CartProduct(cart,productService.getProductById(cart.getProductId()));
				cplist.add(cProduct);
				productTotal += Integer.parseInt(cart.getTotal());
				productNum += Integer.parseInt(cart.getNumber());
			}
		}else {
			productTotal = 0;
			productNum = 0;
		}
		System.out.println(productNum+"件商品，共"+productTotal);
		System.out.println(cplist);
		//将购物车内信息加到session中
		sessionMap.put("loginedCartProduct", cplist);
		jsonMap.put("loginedCartProduct", cplist);
		jsonMap.put("loginedCartNum", productNum);
		sessionMap.put("loginedCartNum", productNum);
		sessionMap.put("loginedCartTotal", productTotal);
		return SUCCESS;
	}
	
	/**
	 * 删除购物车信息
	 * */
	public Boolean delCart(){
		String[] chkValues = this.getChecked().split(", ");
		for (int i = 0; i < chkValues.length; i++) {
			System.out.println(chkValues[i]);
			if(cartService.delCartById(chkValues[i])){
				System.out.println(chkValues[i]+" del success");
			}else {
				System.out.println("第"+i+"次delete失败，错误ID："+chkValues[i]);
				return false;
			}
		}
		return true;
	}
	/**
	 * 更新购物车信息
	 * */
	@SuppressWarnings({ "unchecked"})
	public Boolean updateCart(){
		String price = new String();//储存商品的单价，用于更新购物车总价格
		//1.获取要删除的购物车ID、购物车ID、购物车数量
		String[] chkValues = this.getChecked().split(", ");
		String[] productIdValue = this.getProductId().split(", ");
		String[] productNumValue = this.getProductNum().split(", ");
		for (int j = 0; j < productIdValue.length; j++) {
			//3.1更新之前查一下有没有刚删除的购物车信息
			for (int i = 0; i < chkValues.length; i++) {
				//3.2比对要更新的购物车ID是否已经删除
				System.out.println("productIdValue:"+productIdValue[j]);
				System.out.println("chkValues"+chkValues[i]);
				System.out.println(productIdValue[j].equals(chkValues[i]));
				
				if(productIdValue[j].equals(chkValues[i])){
					//说明此时已经该购物车信息已经删除了，进行下一条购物车信息的更新
					break;
				}
				//3.3如果比对到chkValues最后一个还不相同，则表示该购物车没有删除
				if(i == chkValues.length-1){
					System.out.println("update:"+productIdValue[j]);
					//3.4更新总价格
					CartProduct cartProduct = new CartProduct();
					List<CartProduct> cplist = (List<CartProduct>) sessionMap.get("loginedCartProduct");
					for (int k = 0; k < cplist.size(); k++) {
						cartProduct = cplist.get(k);
						//3.4.1根据传过来的购物车ID匹配到购物车信息
						if(productIdValue[j].equals(cartProduct.getCart().getId())){
							//3.4.2获取商品单价
							price = cartProduct.getProduct().getPrice();
						}
								
					}
					
					//3.4更新数据
					if(cartService.upDate(productIdValue[j],productNumValue[j],price) != 0){
						System.out.println("cartID:"+productIdValue[j]+" success");
					}else {
						System.out.println("第"+j+"次update失败，错误ID："+productIdValue[j]);
						return false;
					}
				}
			}
		}
		return true;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJumppage() {
		return jumppage;
	}

	public void setJumppage(String jumppage) {
		this.jumppage = jumppage;
	}

}
