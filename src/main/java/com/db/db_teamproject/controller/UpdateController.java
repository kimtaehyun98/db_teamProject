package com.db.db_teamproject.controller;

import com.db.db_teamproject.model.Update;
import com.db.db_teamproject.repository.DeleteRepository;
import com.db.db_teamproject.repository.UpdateRepository;
import com.db.db_teamproject.service.DeleteService;
import com.db.db_teamproject.service.UpdateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;

@Controller
@Slf4j
public class UpdateController {
	
	private DeleteService deleteService = new DeleteService();
	private UpdateService updateService = new UpdateService();
	
	@PostMapping("/updates")
	private String updates(@ModelAttribute Update update){
		if(update.getUpdate().equals("DELETE")){ // delete
			deleteService.delete(update);
		}
		else{ // update
			if(updateService.update(update) == false) return "/jsp/updateFail.jsp";
		}
		return "/jsp/home.jsp";
	}
}
