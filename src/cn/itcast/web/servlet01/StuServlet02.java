package cn.itcast.web.servlet01;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ��ȡ������baseservlet_�汾��
 * Ŀ�ģ����ٹ����if()else()���
 */
public class StuServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����method����
		String md=request.getParameter("method");
		//����һ��path�������洢��ǰ����ִ����Ϻ�ת����һ��·��
		String path=null;
		//ͨ���ж�method��ͬ��ȡֵ��ִ�з���˲�ͬ�Ĺ���
		if(null!=md) {
			//����api�ӿڻ�ȡ��ǰ���ֽ���ģ��
			Class clazz=this.getClass();
			try{
				//�鿴��ǰģ�����Ƿ�����Ӧ�ķ������������ƺ�md�е�����һ�£������Ĳ���ΪHttpServletRequest��HttpServletResponse������һ������ֵ
				Method method=clazz.getMethod(md, HttpServletRequest.class,HttpServletResponse.class);
			if(null!=method) {
				//���䣬�ҵ���Ӧ����ִ�е�ǰ����,�����Ͼ���ִ��addStu,delStu�ȷ���
				path=(String)method.invoke(this, request,response);
			}
			if(null!=path) {
				//����ͳһ��ת��
				request.getRequestDispatcher(path).forward(request,response);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

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