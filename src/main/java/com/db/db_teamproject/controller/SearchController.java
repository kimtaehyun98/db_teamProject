package com.db.db_teamproject.controller;

import com.db.db_teamproject.model.Search;
import com.db.db_teamproject.repository.SearchRepository;
import com.db.db_teamproject.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@Controller
public class SearchController {
	
	private SearchService searchService;
	private SearchRepository searchRepository;
	
	@GetMapping("/search")
	public String search(@RequestParam Map<String, String> params){
		searchService = new SearchService(params);
		searchRepository = new SearchRepository();
		
		String query = searchService.makeSearchQuery();
		searchRepository.search(query);
		
		return "/jsp/search.jsp";
	}
}
