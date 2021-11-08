package com.db.db_teamproject.controller;

import com.db.db_teamproject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class InsertController {

	@GetMapping("/insertPage")
	private String insertPage(){
		return "/jsp/insert.jsp";
	}
	
	@PostMapping("/insert")
	private String insert(@Valid @ModelAttribute Employee employee){
		
		return "YES!";
	}
}
