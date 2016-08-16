package com.github.grizz.supplier.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.grizz.supplier.service.MaintainService;

/**
 * 单挑增加控制层 
 */
@SuppressWarnings("serial")
public class InsertOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面的值
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String code = req.getParameter("code");
		String jtype = req.getParameter("jtype");
		String zhuangtai = req.getParameter("zhuangtai");
		String pss = req.getParameter("pss");
		String report = req.getParameter("report");
		String dboss = req.getParameter("dboss");
		String xboss = req.getParameter("xboss");
		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(id,name,code,jtype,zhuangtai,pss,report,dboss,xboss);
	
		//向页面跳转
		req.getRequestDispatcher("/SList.action").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
