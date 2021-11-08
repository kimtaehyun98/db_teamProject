package com.db.db_teamproject.repository;

import com.db.db_teamproject.model.Search;
import com.db.db_teamproject.model.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
@Slf4j
public class SearchRepository {

		public ArrayList<Search> search(String query, ArrayList<Boolean> check){
		
		Password pw = new Password();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Search> searches = new ArrayList<>();
		
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
			// SELECT e.fname as e_fname, e.lname as e_lname, e.ssn as e_ssn, e.bdate as e_bdate, e.address as e_address, e.sex as e_sex, e.salary as e_salary, s.fname as s_fname, s.lname as s_lname, d.dname
			// FROM (EMPLOYEE e LEFT OUTER JOIN DEPARTMENT d ON e.Dno=d.Dnumber) LEFT OUTER JOIN EMPLOYEE s on e.super_ssn=s.ssn
			String sql = query;
			log.info("최종 sql : " + sql);
			
			// 쿼리 수행
			rs = stmt.executeQuery(sql);
			
			// 쿼리 결과 출력
			while(rs.next()){
				Search search = new Search();
				if(check.get(0)){
					search.setName(checkNull(rs.getString("e_fname")) + " "+ checkNull(rs.getString("e_minit")) + " " + checkNull(rs.getString("e_lname")));
				}
				if(check.get(1)){
					search.setSsn(checkNull(rs.getString("e_ssn")));
				}
				if(check.get(2)){
					search.setBDate(checkNull(rs.getString("e_bdate")));
				}
				if(check.get(3)){
					search.setAddress(checkNull(rs.getString("e_address")));
				}
				if(check.get(4)){
					search.setSex(checkNull(rs.getString("e_sex")));
				}
				if(check.get(5)){
					search.setSalary(checkNull(rs.getString("e_salary")));
				}
				if(check.get(6)){
					search.setSupervisor(checkNull(rs.getString("s_fname")) + " " + checkNull(rs.getString("s_lname")));
				}
				if(check.get(7)){
					search.setDepartment(checkNull(rs.getString("dname")));
				}
				searches.add(search);
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
		
		return searches;
	}

	public String checkNull(String str){
		if(str == null) return " ";
		else return str;
	}
}
