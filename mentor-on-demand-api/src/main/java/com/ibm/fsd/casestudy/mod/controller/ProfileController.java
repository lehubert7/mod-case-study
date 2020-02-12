package com.ibm.fsd.casestudy.mod.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.fsd.casestudy.mod.formbean.LoginForm;
import com.ibm.fsd.casestudy.mod.formbean.MentorInfoForm;
import com.ibm.fsd.casestudy.mod.formbean.MentorSkillForm;
import com.ibm.fsd.casestudy.mod.formbean.TechnologyForm;
import com.ibm.fsd.casestudy.mod.service.MentorSkillService;
import com.ibm.fsd.casestudy.mod.service.TechnologyService;
import com.ibm.fsd.casestudy.mod.service.UserService;

@Controller
@RequestMapping("/mod/profile")
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MentorSkillService mentorSkillService;
	
	@Autowired
	TechnologyService technologyService;
	
	private final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@RequestMapping(value="/mentor/{mentor}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<MentorInfoForm> getMentorInfo(@PathVariable Integer mentor) {
		logger.info("Request received.. data <= " + String.valueOf(mentor));
		LoginForm loginForm = userService.getUserInfoById(mentor);
		MentorInfoForm form = new MentorInfoForm();
		if(loginForm != null) {
			form.setId(loginForm.getId());
			form.setName(loginForm.getName());
			form.setLocation(loginForm.getLocation());
			form.setDesignation("Mentor");
			form.setEmail(loginForm.getEmail());
			
			List<MentorSkillForm> mentorSkillFormList = mentorSkillService.getByMentorId(mentor, "approved");
			List<String> skills = new ArrayList<String>(); 
			for(MentorSkillForm mentorSkillForm: mentorSkillFormList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(mentorSkillForm.getTechnologyId());
				skills.add(technologyForm.getName());
			}
			form.setSkills(skills);
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<MentorInfoForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<MentorInfoForm>(form, HttpStatus.NOT_FOUND);
	}
	

}
