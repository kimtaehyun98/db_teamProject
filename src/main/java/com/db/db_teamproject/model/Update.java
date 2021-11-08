package com.db.db_teamproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Update {
	public Update(String updateCategory, String updateText) {
		this.updateCategory = updateCategory;
		this.updateText = updateText;
	}
	
	private String updateCategory;
	private String updateText;
}
