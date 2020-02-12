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

import com.ibm.fsd.casestudy.mod.formbean.MentorSkillForm;
import com.ibm.fsd.casestudy.mod.formbean.TrainingSearchForm;
import com.ibm.fsd.casestudy.mod.service.MentorSkillService;

@Controller
@RequestMapping("/mod/trainsearch")
public class TrainingSearchController {
	@Autowired
	MentorSkillService mentorSkillService;
	
	private final Logger logger = LoggerFactory.getLogger(TrainingSearchController.class);
	
	@RequestMapping(value="/mentor", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<MentorSkillForm>> searchTraining(@RequestBody TrainingSearchForm form) {
		logger.info("Request received.. data <= " + form.toString());
		List<MentorSkillForm> mentorSkillFormList = 
				mentorSkillService.getMentorsByTechnology(form, "approved");
		if(mentorSkillFormList != null) {
			logger.info("Response data List size => " + mentorSkillFormList.size());
			return new ResponseEntity<List<MentorSkillForm>>(mentorSkillFormList, HttpStatus.OK);
		} 
		logger.info("Response data => NULL");
		return new ResponseEntity<List<MentorSkillForm>>(mentorSkillFormList, HttpStatus.NOT_FOUND);
	}

}
