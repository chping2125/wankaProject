package com.chping.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chping.entity.Product;
import com.chping.service.productService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototyep")
@ParentPackage("json-default")
@Namespace("/product")
@InterceptorRefs(value = { @InterceptorRef("fileUploadStack") })
public class productAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionMap;
	private Map<String, Object> dataMap; //json数据传输载体
	private int type;//商品的种类
	private String productId;
	private Product product;
	
	/*图片上传的参数*/
	private static final int BUFFER_SIZE = 16 * 1024;
	//类型为File的file属性：用来封装页面文件域对应的文件内容。
	private File file;
	//类型为String的fileFileName属性：用来封装该文件域对应的文件的文件名
	private String fileFileName;
	//类型为String的fileContentType属性：用来封装该文件域应用的文件的文件类型。
	private String fileContentType;
	
	@Autowired
	private productService productService;
	
	public productAction() {
		sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("message", null);
		//初始化Map对象  
        dataMap = new HashMap<String, Object>();
	}
	
	@Action(value="add",results={@Result(name="success",location="/website/CMS/addProduct.jsp"),
									@Result(name="error",location="/website/CMS/addProduct.jsp")})
	public String addProduct(){
		System.out.println("action addProducts:"+product);
		if(product.getName() != null && product.getPrice() != null){
			//获取图片的URL
			String image = "images/productImg/" + fileFileName;
			System.out.println("imageURL:"+image);
			product.setImage(image);
			
			if(productService.addProduct(product)){
				sessionMap.put("message", "productSuccess");
				try {
					dataMap.clear();
					dataMap.put("message", true);
				} catch (Exception e) {
					System.out.println(e);
				}
				//保存图片到服务器
				saveImg();
				sessionMap.put("message", "success");
				System.out.println("action success");
				return SUCCESS;
			}
			sessionMap.put("message", "error");
			System.out.println("action error");
			return ERROR;
		}
		sessionMap.put("message", "error");
		System.out.println("action error");
		return ERROR;
	}
	
	@Action(value="getTypePros",results={@Result(type="json",params={"root","dataMap"})})
	public String getByTypeToProducts(){
		System.out.println("action getByTypeToProducts:"+type);
		if(type >=1 && type <= 8){
			List<Product> products = productService.getProductsByType(type);
			if(products != null){
				System.out.println("action success");
				sessionMap.put("products", products);
				dataMap.put("products", products);
				return SUCCESS;
			}
		}else {
			type = 1;
			List<Product> products = productService.getProductsByType(type);
			if(products != null){
				System.out.println("action success");
				sessionMap.put("products", products);
				dataMap.put("products", products);
				return SUCCESS;
			}
		}
		System.out.println("action fail or null");
		sessionMap.put("products", null);
		return SUCCESS;
	}
	
	@Action(value="getProById",results={@Result(type="json",params={"root","dataMap"})})
	public String getProducts(){
		System.out.println("action getProducts:"+type);
		if(productId != null&&productId !=""){
			Product product = productService.getProductById(productId);
			if(product != null){
				System.out.println("action success");
				sessionMap.put("products", product);
				dataMap.put("products", product);
				return SUCCESS;
			}
		}
		System.out.println("action fail or null");
		sessionMap.put("products", null);
		dataMap.put("products", null);
		return SUCCESS;
	}
	
	@Action(value="getProByName",results={@Result(type="json",params={"root","dataMap"})})
	public String getProductByName(){
		System.out.println("action getProducts:"+type);
		String nameString = product.getName();
		if(nameString != null&&nameString !=""){
			List<Product> list = productService.getProductByName(nameString);
			if(product != null){
				System.out.println("action success");
				sessionMap.put("products", product);
				dataMap.put("newProList", list);
				return SUCCESS;
			}
		}
		System.out.println("action fail or null");
		sessionMap.put("newProList", null);
		return SUCCESS;
	}
	
	@Action(value="/jumpProduct",results={@Result(name="success",location="/website/product.jsp"),
										@Result(name="error",location="/website/index.jsp")})
	public String jumpProduct(){
		System.out.println("action jumpProduct:"+productId);
		if(productId != null&&productId !=""){
			Product p = productService.getProductById(productId);
			if (productId.equals(p.getPid())) {
				sessionMap.put("product", null);
				sessionMap.put("product", p);
				System.out.println("action success");
				return SUCCESS;
			}
			System.out.println("未知异常");
			return ERROR;
		}
		System.out.println("productId null");
		return ERROR;
	}
	
	/**
	 * 本地储存文件*/
	public void saveImg(){
		System.out.println("File: " + file);
		System.out.println("FileName: " + fileFileName);  
        System.out.println("ContentType: " + fileContentType); 
        try {  
    		InputStream in = null;  
    		OutputStream out = null;  
    		try {  
    			in = new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);  
    			out = new BufferedOutputStream(new FileOutputStream(
    					new File(ServletActionContext.getServletContext()
    							.getRealPath("/website/images/productImg") + "/" + fileFileName)),BUFFER_SIZE);  
    			byte[] buffer = new byte[BUFFER_SIZE];  
    			while (in.read(buffer) > 0) {  
    				out.write(buffer);  
    			}  
    		} finally {  
    			if (null != in) {  
    				in.close(); 
    			}  
    			if (null != out) {  
    				out.close();
    			}
    		} 
    	} catch (Exception e) {  
    		e.printStackTrace();
    	} 
	}
	
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
}
