package com.github.grizz.supplier.service;

import com.github.grizz.supplier.dao.SupplierDao;

/**
 * 维护相关的功能
 */
public class MaintainService {
	
	//插入
	public void insertOne(String id,String name,String code,String jtype,String zhuangtai,String ps,String report,String dboss,String xboss) {
		SupplierDao supplierDao = new SupplierDao();
		supplierDao.insertOne(id,name,code,jtype,zhuangtai,ps,report,dboss,xboss);
	}

	//删除
	public void updateOne(String id,String name,String code,String jtype,String zhuangtai,String ps,String report,String dboss,String xboss) {
		SupplierDao supplierDao = new SupplierDao();
		supplierDao.updateOne(id,name,code,jtype,zhuangtai,ps,report,dboss,xboss);
	}
}
