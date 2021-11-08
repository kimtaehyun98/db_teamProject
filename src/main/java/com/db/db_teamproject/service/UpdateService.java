package com.db.db_teamproject.service;

import com.db.db_teamproject.model.Update;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class UpdateService {
	
	// 예시 SQL : UPDATE EMPLOYEE SET SALARY = 70000 WHERE Ssn = 111111111;
	private String updateQuery = "UPDATE EMPLOYEE SET ";
	
	public ArrayList<String> makeUpdateQuery(ArrayList<String>arr, Update updateInfo){
		String uq = updateQuery + updateInfo.getUpdateCategory().toUpperCase() + "=" + change(updateInfo.getUpdateText()) + " WHERE Ssn = ";
		ArrayList<String> queries = new ArrayList<>();
		for(String ssn : arr){
			queries.add(uq + ssn);
		}
		return queries;
	}
	
	private String change(String str){
		return "'" + str + "'";
	}
}
