package com.db.db_teamproject.controller;

import com.db.db_teamproject.repository.DeleteRepository;
import com.db.db_teamproject.service.DeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

@Controller
@Slf4j
public class DeleteController {
	
	private ArrayList<String> deleteEmployeeSsn = new ArrayList<>();
	private DeleteService deleteService = new DeleteService();
	private DeleteRepository deleteRepository = new DeleteRepository();
	
	@PostMapping("/delete")
	private String delete(HttpServletRequest req){
		// delete 할 employee SSN을 request 객체로부터 받아오기
		Enumeration<String> e = req.getParameterNames();
		while ( e.hasMoreElements() ){
			String name = (String) e.nextElement();
			String[] values = req.getParameterValues(name);
			deleteEmployeeSsn.add(values[0]);
		}
		// 서비스 객체 불러서 query 만들기
		ArrayList<String> queries = deleteService.makeDeleteQuery(deleteEmployeeSsn);
		deleteRepository.delete(queries);
		
		return "/jsp/home.jsp";
	}
}
