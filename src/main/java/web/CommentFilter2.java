package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommentFilter2 implements Filter{
	
	private FilterConfig config;
	
	/**
	 * ��������֮�󣬻���������������ʵ��
	 * ��ֻ�ᴴ��һ������
	 */
	public CommentFilter2() {
		System.out.println("CommentFilter2()");
	}

	/**
	 * �������ٹ�����ʵ��֮ǰ�������
	 * destroy������ֻ��ִ��һ�Σ�
	 */
	public void destroy() {
		System.out.println("destroy()");
	}

	/**
	 * ��ʼ��֮�����������doFilter��������������
	 * FilterChain���󣨹�������������������˸ö���
	 * ��doFilter��������������������ã�����������
	 * ����Ĺ���������servlet��,�����ж����󣬷��ؽ����
	 */
	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("doFilter2 begin...");
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String content = 
				request.getParameter("content");
		
		//��ȡ��ʼ������
		String size = 
				config.getInitParameter("size");
		
		if(content.length() > Integer.parseInt(size)){
			//�ж����󣬷��ؽ��
			out.println("������������");
		}else{
			//����������
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("doFilter2 end.");
		
	}

	/**
	 * ʵ����֮�󣬻�������ʼ����
	 * (init����ֻ�����һ��)��
	 * ע: FilterConfig�������ڶ�ȡ��ʼ��������
	 * 	
	 */
	public void init(FilterConfig arg0) 
			throws ServletException {
		
		config = arg0;
		
		System.out.println("init()");
	}

}
