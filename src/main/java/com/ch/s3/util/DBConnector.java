package com.ch.s3.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBConnector {
	
	public Connection getConnect() throws Exception{
		//1. 연결정보 4가지 
		String user = "hr";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		//2. 드라이버를 메모리에 로딩 
		Class.forName(driver);
		
		System.out.println("드라이버 로딩 성공");
		
		//3.
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("로그인성공");
		System.out.println(con);
		return con;
	}
	

}
