package com.github.grizz.supplier.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;

import com.alibaba.druid.pool.DruidDataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

/**
 * 分页展示控制层
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		//设置编码
//		req.setCharacterEncoding("UTF-8");
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//	
//        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//
//        //设置authenticator
//        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
//        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//        securityManager.setAuthenticator(authenticator);
//
//        //设置authorizer
//        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
//        authorizer.setPermissionResolver(new WildcardPermissionResolver());
//        securityManager.setAuthorizer(authorizer);
//
//        //设置Realm
//        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/pytest");
//        ds.setUsername("root");
//        ds.setPassword("tiger");
//
//        
//        JdbcRealm jdbcRealm = new JdbcRealm();
//        jdbcRealm.setDataSource(ds);
//        jdbcRealm.setPermissionsLookupEnabled(true);
//        securityManager.setRealms(Arrays.asList((Realm) jdbcRealm));
//
//        //将SecurityManager设置到SecurityUtils 方便全局使用
//        SecurityUtils.setSecurityManager(securityManager);
//
//        Subject subject = SecurityUtils.getSubject();
//
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        subject.login(token);
//
//        System.out.println(subject.getPrincipal());
//        System.out.println(subject.hasRole("admin"));
//
//		//向页面跳转
//		req.getRequestDispatcher("index.jsp").forward(req, resp);
	        
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
