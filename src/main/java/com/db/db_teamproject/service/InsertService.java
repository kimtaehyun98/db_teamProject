package com.db.db_teamproject.service;

import com.db.db_teamproject.model.Employee;
import com.db.db_teamproject.repository.InsertRepository;

public class InsertService {

	InsertRepository insertRepository = new InsertRepository();
	
	public boolean insert(Employee employee){
		return insertRepository.insert(makeInsertQuery(employee));
	}
	
	private String makeInsertQuery(Employee employee){
		return "INSERT INTO EMPLOYEE VALUES " + employee.toString();
	}
}
