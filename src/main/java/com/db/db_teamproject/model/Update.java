package com.db.db_teamproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Update {
	public Update(String updateCategory, String updateText) {
		this.updateCategory = updateCategory;
		this.updateText = updateText;
	}
	
	private String update; // delete or update
	private ArrayList<String> ssn;
	private String updateCategory;
	private String updateText;
}
