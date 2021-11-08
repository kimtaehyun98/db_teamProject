package com.db.db_teamproject.controller;

import com.db.db_teamproject.model.Update;
import com.db.db_teamproject.repository.DeleteRepository;
import com.db.db_teamproject.repository.UpdateRepository;
import com.db.db_teamproject.service.DeleteService;
import com.db.db_teamproject.service.UpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;

@Controller
@Slf4j
public class UpdateController {
	
	private ArrayList<String> updateEmployeeSsn = new ArrayList<>();
	private DeleteService deleteService = new DeleteService();
	private UpdateService updateService = new UpdateService();
	private DeleteRepository deleteRepository = new DeleteRepository();
	private UpdateRepository updateRepository = new UpdateRepository();
	
	@PostMapping("/updates")
	private String updates(HttpServletRequest req){
		// update 할 employee SSN을 request 객체로부터 받아오기
		Enumeration<String> e = req.getParameterNames();
		while ( e.hasMoreElements() ){
			String name = (String) e.nextElement();
			if(name.equals("update") || name.equals("updateCategory") || name.equals("updateText")) continue;
			String[] values = req.getParameterValues(name);
			updateEmployeeSsn.add(values[0]);
		}
		String[] deleteOrUpdate = req.getParameterValues("update");
		if(deleteOrUpdate[0].equals("DELETE")){ // delete
			// 서비스 객체 불러서 query 만들기
			ArrayList<String> queries = deleteService.makeDeleteQuery(updateEmployeeSsn);
			deleteRepository.delete(queries);
		}
		else{ // update
			Update updateInfo = new Update(req.getParameter("updateCategory"),req.getParameter("updateText"));
			ArrayList<String> queries = updateService.makeUpdateQuery(updateEmployeeSsn, updateInfo);
			updateRepository.update(queries);
		}
		
		return "/jsp/home.jsp";
	}
}
