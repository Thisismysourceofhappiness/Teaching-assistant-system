package cn.itcast.web.servlet01;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 抽取工具类baseservlet_版本二
 * 目的，减少过多的if()else()语句
 */
public class StuServlet02 extends HttpServlet {
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
			
		}
		
	}

	public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端添加学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
		}
	
	public String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端删除学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	public String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端更新学生功能");
		//由于修改学生这个请求是通过Ajax实现的，是不需要进行转发的，直接响应数据即可
		response.getWriter().print("updateStuOK");
		return null;
	}
	
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端查询学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	

   
}