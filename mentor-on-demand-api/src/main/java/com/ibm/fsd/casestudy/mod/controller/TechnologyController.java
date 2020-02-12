package com.ibm.fsd.casestudy.mod.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.fsd.casestudy.mod.formbean.TechnologyForm;
import com.ibm.fsd.casestudy.mod.service.TechnologyService;

@Controller
@RequestMapping("/mod/technology")
public class TechnologyController {
	@Autowired
	TechnologyService service;
	
	private final Logger logger = LoggerFactory.getLogger(TechnologyController.class);
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TechnologyForm>> fetchAll() {
		logger.info("Request received.. data <= N/A");
		List<TechnologyForm> formList = service.getAllTechnologies();
		
		if(formList != null) {
			logger.info("Response data List size => " + formList.size());
			return new ResponseEntity<List<TechnologyForm>>(formList, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<List<TechnologyForm>>(formList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TechnologyForm> register(@RequestBody TechnologyForm form) {
		logger.info("Request received.. data <= " + form.toString());
		if(service.registerTechnology(form)) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<TechnologyForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<TechnologyForm>(form, HttpStatus.BAD_REQUEST);
	}

}
