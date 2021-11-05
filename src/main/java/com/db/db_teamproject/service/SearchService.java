package com.db.db_teamproject.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SearchService {
	
	private Map<String, String> searchParams;
	
	public SearchService(Map<String, String> searchParams) {
		this.searchParams = searchParams;
	}
	
	public String makeSearchQuery(){
		// 여기서 db에 접근해서 결과를 구한 뒤 model에 담아서 search 페이지 호출하면 됨
		String q = "";
		for(String key : searchParams.values()){
			String temp = "";
			if(key.equals("NAME")) temp = "e.fname, e.lname";
			else if(key.equals("SSN")) temp = "e.ssn";
			else if(key.equals("BDATE")) temp = "e.bdate";
			else if(key.equals("ADDRESS")) temp = "e.address";
			else if(key.equals("SEX")) temp = "e.sex";
			else if(key.equals("SUPERVISOR")) temp = "s.fname, s.lname";
			else if(key.equals("DEPARTMENT")) temp = "d.dname";
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
