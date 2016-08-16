package com.github.grizz.supplier.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.github.grizz.supplier.bean.PageBean;
import com.github.grizz.supplier.bean.Supplier;
import com.github.grizz.supplier.dao.SupplierDao;

/**
 * 列表相关的业务功能
 */
public class SListService {

	//分页查找
	public PageBean<Supplier> querySListFenye(int pc, int ps, String name,
			String code) {
		SupplierDao supplierierDao = new SupplierDao();
		
		// 获取当前用户权限加以控制
		Subject subject = SecurityUtils.getSubject();
		
		//输出角色
		System.out.println(subject.getPrincipal());
		//权限为admin、user、游客是返回的列表
		if (subject.hasRole("admin")) {
			return supplierierDao.querySListFenye(pc, ps, name, code);
		} else if (subject.hasRole("user")) {
			return supplierierDao.querySListFenye(pc, ps, subject.getPrincipal().toString(), code);
		} else {
			return null;
		}
	}

	// 查找单条数据
	public Supplier selectOneList(String id) {
		SupplierDao supplierDao = new SupplierDao();
		return supplierDao.selectOneList(Integer.valueOf(id));
	}

}
