package cn.itcast.web.servlet01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收method参数
		String md=request.getParameter("method");
		//定义一个path变量，存储当前功能执行完毕后，转发的一个路径
		String path=null;
		//通过判断method不同的取值，执行服务端不同的功能
		if(null!=md) {
			if("addStu".equals(md)) {
				path=addStu(request, response);
			}
			else if("delStu".equals(md)) {
				path=delStu(request, response);
			}
			else if("updateStu".equals(md)) {
				path=updateStu(request, response);
			}
			else if("findStu".equals(md)) {
				path=findStu(request, response);
			}
			else {
				
			}
			if(null!=path) {
				//进行统一的转发
				request.getRequestDispatcher(path).forward(request,response);
			}
		}
		
	}

	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端添加学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
		}
	
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端删除学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	protected String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端更新学生功能");
		//由于修改学生这个请求是通过Ajax实现的，是不需要进行转发的，直接响应数据即可
		response.getWriter().print("updateStuOK");
		return null;
	}
	
	protected String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行服务端查询学生功能");
		//转发到success.jsp页面
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	

}
