package com.github.grizz.supplier.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import com.github.grizz.supplier.bean.PageBean;
import com.github.grizz.supplier.bean.Supplier;
import com.github.grizz.supplier.service.SListService;
/**
 * excel输出控制层
 */
@SuppressWarnings("serial")
public class OutputServlet extends HttpServlet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
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

		String templateFileName = "C:/Users/magsh/Desktop/templates/supplier.xls";
        String destFileName = "C:/Users/magsh/Desktop/templates/supilier_output.xls";
        Map beans = new HashMap();
        beans.put("list", pb.getBeanList());
        XLSTransformer transformer = new XLSTransformer();
				try {
					transformer.transformXLS(templateFileName, beans, destFileName);
				} catch (ParsePropertyException e) {
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				}
			
		
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/slist.jsp").forward(req, resp);
	        
	}

	
	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}
	
	private int getPs(HttpServletRequest request) {
		String value = request.getParameter("ps");
		if (value == null || value.trim().isEmpty()) {
			return 4;
		}
		return Integer.parseInt(value);
	}
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面的值
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		//向页面传值
		req.setAttribute("command", command);
		req.setAttribute("description", description);
		ListService listService = new ListService();
		//查询消息列表并传给页面
		req.setAttribute("messageList", listService.queryMessageList(command, description));
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}*/
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
