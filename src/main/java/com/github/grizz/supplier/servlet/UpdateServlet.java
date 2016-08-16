package com.github.grizz.supplier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.grizz.supplier.service.SListService;

/**
 * 单条查找
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面的值
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		//向页面跳转
		SListService slistService = new SListService();
		//查询消息列表并传给页面
		req.setAttribute("supplier", slistService.selectOneList(id));
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/update.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
