package cn.itcast.web.servlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuServlet03 extends BaseSerlvet {
	public String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з�������ѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
		}
	
	public String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з����ɾ��ѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	public String updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з���˸���ѧ������");
		//�����޸�ѧ�����������ͨ��Ajaxʵ�ֵģ��ǲ���Ҫ����ת���ģ�ֱ����Ӧ���ݼ���
		response.getWriter().print("updateStuOK");
		return null;
	}
	
	public String findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ִ�з���˲�ѯѧ������");
		//ת����success.jspҳ��
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
		return "/success.jsp";
	}
	
	
}
