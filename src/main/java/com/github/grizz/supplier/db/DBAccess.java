package com.github.grizz.supplier.db;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库访问类 
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库信息
		Reader reader = Resources.getResourceAsReader("com/github/grizz/supplier/config/Configuration.xml");
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory qlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = qlSessionFactory.openSession();
		return sqlSession;
	}
}
