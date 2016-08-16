package com.github.grizz.supplier.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.github.grizz.supplier.bean.PageBean;
import com.github.grizz.supplier.bean.Supplier;
import com.github.grizz.supplier.db.DBAccess;
/**
 * 和Supplier表相关的数据库操作
 */
public class SupplierDao {
	
	/**
	 * 单条查找 
	 */
	public Supplier selectOneList(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Supplier supplier = new Supplier();
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行sql语句		
			supplier = sqlSession.selectOne("Supplier.selectOneList", id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return supplier;
	}
	
	/**
	 * 新增单条数据
	 */
	public void insertOne(String id,String name,String code,String jtype,String zhuangtai,String ps,String report,String dboss,String xboss) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Supplier supplier = new Supplier();
			supplier.setId(Integer.valueOf(id));
			supplier.setName(name);
			supplier.setCode(code);			
			supplier.setJtype(jtype);
			supplier.setZhuangtai(zhuangtai);
			supplier.setPs(ps);
			supplier.setReport(report);
			supplier.setDboss(dboss);
			supplier.setXboss(xboss);
			
			
			//通过sqlSession执行sql语句
			sqlSession.insert("Supplier.insertOne", supplier);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	

	/**
	 * 单条修改
	 */
	public void	updateOne(String id,String name,String code,String jtype,String zhuangtai,String ps,String report,String dboss,String xboss) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Supplier supplier = new Supplier();
			supplier.setId(Integer.valueOf(id));
			supplier.setName(name);
			supplier.setCode(code);			
			supplier.setJtype(jtype);
			supplier.setZhuangtai(zhuangtai);
			supplier.setPs(ps);
			supplier.setReport(report);
			supplier.setDboss(dboss);
			supplier.setXboss(xboss);
			//通过sqlSession执行sql语句
			sqlSession.update("Supplier.updateOne", supplier);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	/**
	 * 分页展示列表
	 */
	public PageBean<Supplier> querySListFenye(int pc, int ps, String name, String code) {
		DBAccess dbAccess = new DBAccess();

		PageBean<Supplier> pb = new PageBean<Supplier>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();

			pb.setPc(pc);
			pb.setPs(ps);
			pb.setNameSearch(name);
			pb.setCodeSearch(code);
			int tr = (Integer) sqlSession.selectOne("Supplier.selectCount");
			pb.setTr(tr);
			if (pb.getPc() > pb.getTp()) {
				pb.setPc(pb.getTp());
			}
//			pb.setPc(1);
			List<Supplier> beanList = null;
			beanList = sqlSession.selectList(
					"Supplier.selectAllUsersFenye", pb);
			sqlSession.commit();
			pb.setBeanList(beanList);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return pb;
	}

}
