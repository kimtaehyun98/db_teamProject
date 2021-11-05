package com.db.db_teamproject.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

@Slf4j
@Getter
public class SearchService {
	
	private Map<String, String> searchParams;
	
	public SearchService(Map<String, String> searchParams) {
		this.searchParams = searchParams;
	}
	
	private ArrayList<Boolean> check = new ArrayList<>();
	private ArrayList<String> header = new ArrayList<>();
	
	public String makeSearchQuery(){
		// 여기서 db에 접근해서 결과를 구한 뒤 model에 담아서 search 페이지 호출하면 됨
		for(int i = 0; i < 8; i++) check.add(false);
		String q = "";
		for(String key : searchParams.values()){
			String temp = "";
			if(key.equals("NAME")) {
				temp = "e.fname as e_fname, e.lname as e_lname";
				check.set(0, true);
				header.add("NAME");
			}
			else if(key.equals("SSN")) {
				temp = "e.ssn as e_ssn";
				check.set(1,true);
				header.add("SSN");
			}
			else if(key.equals("BDATE")) {
				temp = "e.bdate as e_bdate";
				check.set(2,true);
				header.add("BDATE");
			}
			else if(key.equals("ADDRESS")){
				temp = "e.address as e_address";
				check.set(3,true);
				header.add("ADDRESS");
			}
			else if(key.equals("SEX")) {
				temp = "e.sex as e_sex";
				check.set(4,true);
				header.add("SEX");
			}
			else if(key.equals("SALARY")) {
				temp = "e.salary as e_salary";
				check.set(5,true);
				header.add("SALARY");
			}
			else if(key.equals("SUPERVISOR")) {
				temp = "s.fname as s_fname, s.lname as s_lname";
				check.set(6,true);
				header.add("SUPERVISOR");
			}
			else if(key.equals("DEPARTMENT")) {
				temp = "d.dname";
				check.set(7,true);
				header.add("DEPARTMENT");
			}
			if(!temp.equals("")) q += temp + ", ";
		}
		// 맨 마지막 ", " 빼주기
		if(q.length() > 0) {
			q = q.substring(0,q.length()-2);
		}
		log.info(q);
		return q;
	}
}
