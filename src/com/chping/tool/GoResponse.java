package com.chping.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GoResponse extends ActionSupport {
	private static final long serialVersionUID = 8874906760794423255L;

	/**
	 * 向客户端发送JSON数据
	 * @param theStr json字符串
	 * @param i 发送类型1：json格式   其他：xml格式
	 * */
	public static void goResponse(String theStr,int i){
		HttpServletResponse response = ServletActionContext.getResponse();;
		PrintWriter out = null  ;
		if(response!=null)
		{   
			if(i==1) 
				response.setContentType("application/json;charset=UTF-8");
			else 
				response.setContentType("text/xml;charset=UTF-8");
			
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(out!=null){
				out.print(theStr);
				out.flush();
				out.close();
			}
			return;
		}
	}
}
