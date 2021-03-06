package com.db.db_teamproject.repository;

import com.db.db_teamproject.model.Password;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class InsertRepository {
	
	Password pw = new Password();
	
	public boolean insert(String query){
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean ret = true;
		// 연결
		try {
			
			// 접속 url과 사용자, 비밀번호
			String url = "jdbc:mysql://localhost:3306/COMPANY?serverTimezone=UTC";
			String user = "root";
			String pwd = pw.getPw();
			
			con = DriverManager.getConnection(url, user, pwd);
			log.info("DB와 정상적으로 연결되었습니다.");
			
			String sql = query;
			log.info("insert sql : " + sql);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (
				SQLException e){
			System.err.println("연결할 수 없습니다.");
			e.printStackTrace();
			ret = false; // insert가 정상 작동하지 않았음을 알려줌
		}
		
		// 해제
		try {
			log.info("DB 연결을 종료합니다.");
			if (con != null)
				con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return ret;
	}
}
