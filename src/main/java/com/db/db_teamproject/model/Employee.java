package com.db.db_teamproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class Employee {
	
	@NotEmpty(message = "Ssn은 반드시 입력해야 합니다!")
	private String ssn;
	
	private String fname;
	private String minit;
	private String lname;
	private String bdate;
	private String address;
	private String sex;
	private String salary;
	private String super_ssn;
	private String dno;
	
}
