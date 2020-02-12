package com.ibm.fsd.casestudy.mod.controller;

import java.util.List;

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

import com.ibm.fsd.casestudy.mod.formbean.MentorSkillForm;
import com.ibm.fsd.casestudy.mod.service.MentorSkillService;

@Controller
@RequestMapping("/mod/mentorskills")
public class MentorSkillsController {
	@Autowired
	MentorSkillService service;
	
	private final Logger logger = LoggerFactory.getLogger(MentorSkillsController.class);
	
	@RequestMapping(value="/summary/{mentor}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<MentorSkillForm>> getMentorSkills(@PathVariable Integer mentor) {
		logger.info("Request received.. data <= " + String.valueOf(mentor));
		List<MentorSkillForm> formList = service.getByMentorId(mentor, "approved");
		
		if(formList == null) {
			logger.info("Response data => NULL");
			return new ResponseEntity<List<MentorSkillForm>>(formList, HttpStatus.NOT_FOUND);
		}
		logger.info("Response data List size => " + formList.size());
		return new ResponseEntity<List<MentorSkillForm>>(formList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/approve/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> approve(@PathVariable Integer id) {
		logger.info("Request received.. data <= " + String.valueOf(id));
		if(service.approveMentorSkill(id)) {
			logger.info("Response data => success");
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<String>("failed", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MentorSkillForm> add(@RequestBody MentorSkillForm form) {
		logger.info("Request received.. data <= " + form.toString());
		if(form.getId() == null) {
			if(service.addMentorSkill(form)) {
				logger.info("Response data => " + form.toString());
				return new ResponseEntity<MentorSkillForm>(form, HttpStatus.OK);
			}
		} else {
			if(service.updateExperience(form.getId(), form.getExperience())) {
				logger.info("Response data => " + form.toString());
				return new ResponseEntity<MentorSkillForm>(form, HttpStatus.OK);
			}
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<MentorSkillForm>(form, HttpStatus.BAD_REQUEST);
	}
}
