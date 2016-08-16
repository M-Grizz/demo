package com.github.grizz.supplier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.grizz.supplier.bean.Supplier;
import com.github.grizz.supplier.service.SListService;
/**
 * 联系人展现控制层
 */
@SuppressWarnings("serial")
public class BossServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		SListService slistService = new SListService();		
		Supplier supplier = new Supplier();
		try {
			supplier = slistService.selectOneList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("supplier", supplier);

		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/bossinf.jsp").forward(req, resp);
	        
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
