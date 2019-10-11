package cn.itcast.web.servlet02;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//工具类BaseServlet
//抽取重复代码作为父类
public class BaseSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收method参数
		String md=request.getParameter("method");
		//定义一个path变量，存储当前功能执行完毕后，转发的一个路径
		String path=null;
		//通过判断method不同的取值，执行服务端不同的功能
		if(null!=md) {
		//调用api接口获取当前的字节码模块
		Class clazz=this.getClass();
		try{
			//查看当前模块中是否有相应的方法，方法名称和md中的内容一致，方法的参数为HttpServletRequest和HttpServletResponse，返回一个方法值
			Method method=clazz.getMethod(md, HttpServletRequest.class,HttpServletResponse.class);
		    if(null!=method) {
			//反射，找到对应方法执行当前方法,本质上就是执行addStu,delStu等方法
			path=(String)method.invoke(this, request,response);
		    }
		    if(null!=path) {
			//进行统一的转发
			request.getRequestDispatcher(path).forward(request,response);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}		
		}else {
			execute(request,response);
		}
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//设置响应内容格式和编码
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("您需要提交method的键值对数据");
		
		return null;
		
		
	}
}	
