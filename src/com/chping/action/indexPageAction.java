package com.chping.action;

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

import com.chping.dao.indexPageDAO;
import com.chping.entity.Nav;
import com.chping.entity.News;
import com.chping.entity.Product;
import com.chping.entity.Type;
import com.chping.service.productService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@ParentPackage("json-default")
@Namespace("/go")
public final class indexPageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> dataMap; //json数据传输载体
	@Autowired
	private indexPageDAO indexPageDAO;
	@Autowired
	private productService service;
	
	private int pageNum;
	private int pageTotal;
	
	public indexPageAction() {
		//初始化Map对象  
        dataMap = new HashMap<String, Object>(); 
	}
	
	@Action(value="get_indexPro",results={@Result(type="json",params={"root","dataMap"})})
	public String getIndexPro(){
		
		return SUCCESS;
	}
	
	@Action(value="getType",results={@Result(type="json",params={"root","dataMap"})})
	public String getType(){
		List<Type> typeList = indexPageDAO.getType();
		System.out.println("action -->typeList:"+typeList);
		dataMap.clear();
		if(typeList.size() !=0 ){
			dataMap.put("typeList", typeList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getNav",results={@Result(type="json",params={"root","dataMap"})})
	public String getNav(){
		List<Nav> navList = indexPageDAO.getNav();
		System.out.println("action -->navList:"+navList);
		dataMap.clear();
		if(navList.size() !=0 ){
			dataMap.put("navList", navList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getStartPro",results={@Result(type="json",params={"root","dataMap"})})
	public String getStartPro(){
		List<Product> startProList = indexPageDAO.getStartPro();
		System.out.println("action -->startProList:"+startProList);
		dataMap.clear();
		if(startProList.size() !=0 ){
			dataMap.put("startProList", startProList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getNewPro",results={@Result(type="json",params={"root","dataMap"})})
	public String getNewPro(){
		System.out.println("11111111111");
		List<Product> newProList = service.getProductList(4,0,0);
		System.out.println("action -->newProList:"+newProList);
		dataMap.clear();
		if(newProList.size() !=0 ){
			dataMap.put("newProList", newProList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getNewProL",results={@Result(type="json",params={"root","dataMap"})})
	public String getNewProL(){
		List<Product> newProList2 = indexPageDAO.getNewPro2();
		System.out.println("action -->newProList2:"+newProList2);
		dataMap.clear();
		if(newProList2.size() !=0 ){
			dataMap.put("newProList2", newProList2);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getNewProList",results={@Result(type="json",params={"root","dataMap"})})
	public String getNewProList(){
		List<Product> newProList = service.getProductList(0,pageNum,pageTotal);
		System.out.println("action -->newProList:"+newProList);
		dataMap.clear();
		if(newProList.size() !=0 ){
			dataMap.put("newProList", newProList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getNews",results={@Result(type="json",params={"root","dataMap"})})
	public String getNews(){
		List<News> newList = indexPageDAO.getNews();
		System.out.println("action -->newList:"+newList);
		dataMap.clear();
		if(newList.size() !=0 ){
			dataMap.put("newList", newList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getalLovePro",results={@Result(type="json",params={"root","dataMap"})})
	public String getalLovePro(){
		List<Product> alLoveList = indexPageDAO.getalLovePro();
		System.out.println("action -->alLoveList:"+alLoveList);
		dataMap.clear();
		if(alLoveList.size() !=0 ){
			dataMap.put("alLoveList", alLoveList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getalLoveProL",results={@Result(type="json",params={"root","dataMap"})})
	public String getalLoveProL(){
		List<Product> alLoveList2 = indexPageDAO.getalLovePro2();
		System.out.println("action -->alLoveList2:"+alLoveList2);
		dataMap.clear();
		if(alLoveList2.size() !=0 ){
			dataMap.put("alLoveList2", alLoveList2);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getHotPro",results={@Result(type="json",params={"root","dataMap"})})
	public String getHotPro(){
		List<Product> hotProList = indexPageDAO.getHotPro();
		System.out.println("action -->hotProList:"+hotProList);
		dataMap.clear();
		if(hotProList.size() !=0 ){
			dataMap.put("hotProList", hotProList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	@Action(value="getSalePro",results={@Result(type="json",params={"root","dataMap"})})
	public String getSalePro(){
		List<Product> saleProList = indexPageDAO.getSalePro();
		System.out.println("action -->saleProList:"+saleProList);
		dataMap.clear();
		if(saleProList.size() !=0 ){
			dataMap.put("saleProList", saleProList);
			dataMap.put("message", "success");
			System.out.println("action success");
			return SUCCESS;
		}
		dataMap.put("message", "error");
		System.out.println("action error");
		return SUCCESS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
}
