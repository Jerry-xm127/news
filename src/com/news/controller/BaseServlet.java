package com.news.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5446672734865579858L;

	@SuppressWarnings("unchecked")
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String methodName = request.getParameter("method");
        @SuppressWarnings("rawtypes")
		Class c = this.getClass();//获取当前类
        Method method = null;
        try {
            method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
        } catch (Exception e){
            throw new RuntimeException("您要调用的方法：" + methodName +
                    "(HttpServletRequest,HttpServletResponse)，它不存在！");
        }
        try{
            method.invoke(this,request, response);
        }catch(Exception e){
            System.out.println("您调用的方法：" + methodName + ",　它内部抛出了异常！");
            throw new RuntimeException(e);
        }
    }
}