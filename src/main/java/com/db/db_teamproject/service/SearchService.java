package com.db.db_teamproject.service;

import com.db.db_teamproject.model.Search;
import com.db.db_teamproject.repository.SearchRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Getter
public class SearchService {
	
	private SearchRepository searchRepository = new SearchRepository();
	private Map<String, String> searchParams;
	
	private ArrayList<Boolean> check;
	private ArrayList<String> header;
	
	private String mainCategory;
	private String subCategory;
	private String inputText;
	
	public ArrayList<Search> search(Map<String,String> params){
		searchParams = params;
		return searchRepository.search(makeSearchQuery(),check);
	}
	
	public String makeSearchQuery(){
		// 여기서 db에 접근해서 결과를 구한 뒤 model에 담아서 search 페이지 호출하면 됨
		check = new ArrayList<>();
		header = new ArrayList<>();
		for(int i = 0; i < 8; i++) check.add(false);
		String q = "";
		boolean mc = true;
		for(String key : searchParams.keySet()){
			String temp = "";
			if(key.equals("name")) {
				temp = "e.fname as e_fname, e.lname as e_lname";
				check.set(0, true);
				header.add("NAME");
			}
			else if(key.equals("ssn")) {
				temp = "e.ssn as e_ssn";
				check.set(1,true);
				header.add("SSN");
			}
			else if(key.equals("bdate")) {
				temp = "e.bdate as e_bdate";
				check.set(2,true);
				header.add("BDATE");
			}
			else if(key.equals("address")){
				temp = "e.address as e_address";
				check.set(3,true);
				header.add("ADDRESS");
			}
			else if(key.equals("sex")) {
				temp = "e.sex as e_sex";
				check.set(4,true);
				header.add("SEX");
			}
			else if(key.equals("salary")) {
				temp = "e.salary as e_salary";
				check.set(5,true);
				header.add("SALARY");
			}
			else if(key.equals("supervisor")) {
				temp = "s.fname as s_fname, s.lname as s_lname";
				check.set(6,true);
				header.add("SUPERVISOR");
			}
			else if(key.equals("department")) {
				temp = "d.dname";
				check.set(7,true);
				header.add("DEPARTMENT");
			}
			else if(key.equals("mainCategory")) {
				mainCategory = searchParams.get(key);
			}
			else if(key.equals("subCategory")) {
				subCategory = searchParams.get(key);
			}
			else if(key.equals("inputText")) {
				inputText = searchParams.get(key);
			}
			if(!temp.equals("")) q += temp + ", ";
		}
		// 맨 마지막 ", " 빼주기
		if(q.length() > 0) {
			q = q.substring(0,q.length()-2);
		}
		// log.info(q);
		
		String where = "";
		// mainCategory가 존재한다면 다르게 처리
		if(!mainCategory.equals("none")){
			where = categorySearch();
		}
		
		q = "SELECT " + q + " FROM (EMPLOYEE e LEFT OUTER JOIN DEPARTMENT d ON e.Dno=d.Dnumber) LEFT OUTER JOIN EMPLOYEE s on e.super_ssn=s.ssn" + where;
		return q;
	}
	
	private String categorySearch(){
		String w = " WHERE ";
		if(mainCategory.equals("department")) {
			w += "d.dname=" + change(subCategory);
		}
		else if(mainCategory.equals("sex")) {
			w += "e.sex=" + change(subCategory);
		}
		else if(mainCategory.equals("salary")) {
			w += "e.salary>" + inputText;
		}
		else if(mainCategory.equals("bdate")) {
			if(inputText.length() != 2) inputText = "0" + inputText;
			w += "e.bdate LIKE " + "'_____" + inputText + "%'";
		}
		else if(mainCategory.equals("supervisor")) {
			w += "s.fname=" + change(inputText);
		}
		return w;
	}
	
	private String change(String str){
		return "'" + str + "'";
	}
}
