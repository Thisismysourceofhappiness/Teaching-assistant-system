package cn.itcast.web.servlet02;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//������BaseServlet
//��ȡ�ظ�������Ϊ����
public class BaseSerlvet extends HttpServlet {
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
		}else {
			execute(request,response);
		}
	}
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//������Ӧ���ݸ�ʽ�ͱ���
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("����Ҫ�ύmethod�ļ�ֵ������");
		
		return null;
		
		
	}
}	
