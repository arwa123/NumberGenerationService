package com.kristal.ai.controller;

import com.kristal.ai.domain.dto.Response;
import com.kristal.ai.service.INumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1")
public class NumberController
{
	@Qualifier("numberServiceImpl")
    @Autowired
	INumberService numberService;


	@GetMapping(path = "/numbers")
	public Response numberGenerator() {

		return numberService.generate();

	}


	
}
