package com.db.db_teamproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class Employee {
	
	// @NotEmpty(message = "Ssn은 반드시 입력해야 합니다!")
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
	// INSERT INTO EMPLOYEE VALUES ('Test', 'T', 'test', '111111111', '1998-11-07', 'Seoul, Mapo', 'M', 90000, '333445555', 5);
	@Override
	public String toString() {
		return "(" +
				change(fname) + ", " +
				change(minit) + ", " +
				change(lname) + ", " +
				change(ssn) + ", " +
				change(bdate) + ", " +
				change(address) + ", " +
				change(sex) + ", " +
				salary + ", " +
				change(super_ssn) + ", " +
				dno + ")"
				;
	}
	
	public String change(String str){
		return "'" + str + "'";
	}
}
