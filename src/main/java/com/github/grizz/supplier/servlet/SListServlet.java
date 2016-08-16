package com.github.grizz.supplier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.grizz.supplier.bean.PageBean;
import com.github.grizz.supplier.bean.Supplier;
import com.github.grizz.supplier.service.SListService;
/**
 * 分页展示控制层
 */
@SuppressWarnings("serial")
public class SListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String code = req.getParameter("code");
		SListService slistService = new SListService();		
		int pc = getPc(req);		
		int ps = getPs(req);
		if (pc <= 0) {
			pc = 1;
		}
		PageBean<Supplier> pb = null;
		try {
			pb = slistService.querySListFenye(pc, ps, name, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("pb", pb);
		
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/slist.jsp").forward(req, resp);
	        
	}

	//获取当前页
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}
	
	//获取每页显示条数
	private int getPs(HttpServletRequest request) {
		String value = request.getParameter("ps");
		if (value == null || value.trim().isEmpty()) {
			return 4;
		}
		return Integer.parseInt(value);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
