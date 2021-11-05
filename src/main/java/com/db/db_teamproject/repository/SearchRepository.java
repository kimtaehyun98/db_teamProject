package com.db.db_teamproject.repository;

import com.db.db_teamproject.model.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@Slf4j
public class SearchRepository {

	public void search(String select){
		
		Password pw = new Password();
		
		Connection con = null;
		Statement stmt = null;
		
		// 연결
		try {
			
			// 접속 url과 사용자, 비밀번호
			String url = "jdbc:mysql://localhost:3306/COMPANY?serverTimezone=UTC";
			String user = "root";
			String pwd = pw.getPw();
			
			con = DriverManager.getConnection(url, user, pwd);
			log.info("DB와 정상적으로 연결되었습니다.");
			
			// 기존 Table 출력
			stmt = con.createStatement();
			
			// 전체 쿼리
			// select e.fname, e.lname, e.ssn, e.bdate, e.address, e.sex, e.salary, s.fname as s_fname, s.lname as s_lname, d.dname
			// from employee e, department d, employee s
			// where e.dno=d.dnumber and e.super_ssn=s.ssn;
			String sql = "SELECT " + select + " FROM EMPLOYEE as e, DEPARTMENT as d, EMPLOYEE as s WHERE e.Dno=d.Dnumber AND e.super_ssn=s.ssn";
			log.info("최종 sql : " + sql);
			
			// 쿼리 수행
			ResultSet rs = stmt.executeQuery(sql);
			
			// 쿼리 결과 출력
			while(rs.next()){
				/*String dnumber = rs.getString(1);
				String dlocation = rs.getString(2);
				
				System.out.println(dnumber + " " + dlocation);*/
			}
			
		} catch (SQLException e){
			System.err.println("연결할 수 없습니다.");
			e.printStackTrace();
		}
		
		// 해제
		try {
			log.info("DB 연결을 종료합니다.");
			if (con != null)
				con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
