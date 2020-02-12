package com.ibm.fsd.casestudy.mod.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.fsd.casestudy.mod.formbean.LoginForm;
import com.ibm.fsd.casestudy.mod.service.UserService;

@Controller
@RequestMapping("/mod/login")
public class LoginController {
	
	@Autowired
	UserService service;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LoginForm> login(@RequestBody LoginForm form) {
		logger.info("Request received.. data <= " + form.toString());
		form = service.validateCredentials(form);
		if(form == null) {
			logger.info("Response data => NULL");
			return new ResponseEntity<LoginForm>(form, HttpStatus.NOT_FOUND);
		}
		logger.info("Response data => " + form.toString());
		return new ResponseEntity<LoginForm>(form, HttpStatus.OK);
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<LoginForm> register(@RequestBody LoginForm form) {
		logger.info("Request received.. data <= " + form.toString());
		form = service.registerUser(form);
		if(form != null) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<LoginForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<LoginForm>(form, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/userinfo/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<LoginForm> getUserInfoById(@PathVariable Integer userId) {
		logger.info("Request received.. data <= " + String.valueOf(userId));
		LoginForm form = service.getUserInfoById(userId);
		if(form != null) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<LoginForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<LoginForm>(form, HttpStatus.BAD_REQUEST);
	}

}
