package com.db.db_teamproject.controller;

import com.db.db_teamproject.model.Employee;
import com.db.db_teamproject.service.InsertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class InsertController {

	private InsertService insertService = new InsertService();
	
	@GetMapping("/insertPage")
	private String insertPage(){
		return "/jsp/insert.jsp";
	}
	
	@PostMapping("/insert")
	private String insert(@ModelAttribute Employee employee){
		boolean insert = insertService.insert(employee);
		if(insert) return "/jsp/home.jsp";
		else return "/jsp/insertFail.jsp";
	}
}
