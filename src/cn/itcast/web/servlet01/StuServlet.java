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
		//����method����
		String md=request.getParameter("method");
		//����һ��path�������洢��ǰ����ִ����Ϻ�ת����һ��·��
		String path=null;
		//ͨ���ж�method��ͬ��ȡֵ��ִ�з���˲�ͬ�Ĺ���
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
				//����ͳһ��ת��
				request.getRequestDispatcher(path).forward(request,response);
			}
		}
		
	}

	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з�������ѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
		}
	
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з����ɾ��ѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	protected String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з���˸���ѧ������");
		//�����޸�ѧ�����������ͨ��Ajaxʵ�ֵģ��ǲ���Ҫ����ת���ģ�ֱ����Ӧ���ݼ���
		response.getWriter().print("updateStuOK");
		return null;
	}
	
	protected String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з���˲�ѯѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	

}
