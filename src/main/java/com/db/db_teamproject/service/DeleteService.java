package com.db.db_teamproject.service;

import java.util.ArrayList;

public class DeleteService {
	
	private String deleteQuery = "DELETE FROM EMPLOYEE WHERE ssn=";
	
	public ArrayList<String> makeDeleteQuery(ArrayList<String>arr){
		ArrayList<String> queries = new ArrayList<>();
		for(String ssn : arr){
			queries.add(deleteQuery + ssn);
		}
		return queries;
	}
}
