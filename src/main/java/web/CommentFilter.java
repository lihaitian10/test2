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


public class CommentFilter implements Filter{
	
	private FilterConfig config;
	
	/**
	 * ��������֮�󣬻���������������ʵ��
	 * ��ֻ�ᴴ��һ������
	 */
	public CommentFilter() {
		System.out.println("CommentFilter()");
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
		System.out.println("doFilter begin...");
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
		String illegal = 
				config.getInitParameter("illegal");
		
		if(content.indexOf(illegal) != -1){
			//�ж����󣬷��ؽ��
			out.println("�������ݷǷ�");
		}else{
			//����������
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("doFilter end.");
		
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
