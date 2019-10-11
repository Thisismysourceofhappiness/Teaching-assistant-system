package cn.itcast.web.servlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuServlet03 extends BaseSerlvet {
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
