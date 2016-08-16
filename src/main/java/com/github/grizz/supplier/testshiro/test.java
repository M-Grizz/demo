package com.github.grizz.supplier.testshiro;
import java.util.Arrays;

public class test {
	
	/**
	 * shiro示例 
	 */
	public static void main(String[] args) {
		BaseTest baseTest = new BaseTest();
		baseTest.login("classpath:shiro.ini", "wang", "123");
	        //判断拥有角色：role1
	        if(baseTest.subject().hasRole("admin")) {
	        	System.out.println("has admin");
	        }
	        //判断拥有角色：role1 and role2
	        baseTest.subject().hasAllRoles(Arrays.asList("role1", "role2"));
	        //判断拥有角色：role1 and role2 and !role3
	        baseTest.subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
	}
}
