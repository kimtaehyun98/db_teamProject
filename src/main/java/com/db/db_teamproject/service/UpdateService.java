package com.db.db_teamproject.service;

import com.db.db_teamproject.model.Update;
import com.db.db_teamproject.repository.UpdateRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class UpdateService {
	
	UpdateRepository updateRepository = new UpdateRepository();
	
	// 예시 SQL : UPDATE EMPLOYEE SET SALARY = 70000 WHERE Ssn = 111111111;
	private String updateQuery = "UPDATE EMPLOYEE SET ";
	
	public void update(Update updateInfo){
		updateRepository.update(makeUpdateQuery(updateInfo));
	}
	
	private ArrayList<String> makeUpdateQuery(Update updateInfo){
		String uq = updateQuery + updateInfo.getUpdateCategory().toUpperCase() + "=" + change(updateInfo.getUpdateText()) + " WHERE Ssn = ";
		ArrayList<String> queries = new ArrayList<>();
		for(String ssn : updateInfo.getSsn()){
			queries.add(uq + ssn);
		}
		return queries;
	}
	
	private String change(String str){
		return "'" + str + "'";
	}
}
