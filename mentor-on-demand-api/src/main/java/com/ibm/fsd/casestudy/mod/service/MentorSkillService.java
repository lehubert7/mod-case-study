package com.ibm.fsd.casestudy.mod.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsd.casestudy.mod.formbean.LoginForm;
import com.ibm.fsd.casestudy.mod.formbean.MentorSkillForm;
import com.ibm.fsd.casestudy.mod.formbean.TechnologyForm;
import com.ibm.fsd.casestudy.mod.formbean.TrainingForm;
import com.ibm.fsd.casestudy.mod.formbean.TrainingSearchForm;
import com.ibm.fsd.casestudy.mod.jpa.entity.MentorSkill;
import com.ibm.fsd.casestudy.mod.jpa.repo.MentorSkillRepository;

@Service
public class MentorSkillService {
	
	@Autowired
	MentorSkillRepository repo;
	
	@Autowired 
	TechnologyService technologyService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TrainingService trainingService;
	
	private final Logger logger = LoggerFactory.getLogger(MentorSkillService.class);
	
	public List<MentorSkillForm> getByMentorId(Integer mentor, String status) {
		logger.info("Input data <= " + String.valueOf(mentor) + ", " + status);
		try {
			List<MentorSkill> mentorSkillsList = repo.findByMentorId(mentor, status);
			List<MentorSkillForm> formList = new ArrayList<MentorSkillForm>();
			for (MentorSkill mentorSkill: mentorSkillsList) {
				TechnologyForm technologyForm = technologyService.getTechnologyById(mentorSkill.getTechnology());
				LoginForm userForm = userService.getUserInfoById(mentorSkill.getMentor());
				List<TrainingForm> trainingFormList = 
						trainingService.getTrainingForMentorByTechnology(mentorSkill.getMentor(),
								"completed", mentorSkill.getTechnology());
				MentorSkillForm form = new MentorSkillForm();
				form.setId(mentorSkill.getId());
				form.setNoOfTrainings(trainingFormList.size());
				form.setName(userForm.getName());
				form.setMentor(mentorSkill.getMentor());
				form.setTechnologyId(mentorSkill.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setExperience(mentorSkill.getExperience());
				form.setStatus(mentorSkill.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<MentorSkillForm> getMentorsByTechnology(TrainingSearchForm trainingSearchForm, String status) {
		logger.info("Input data <= " + trainingSearchForm.toString() + ", " + status);
		try {
			Integer technology = trainingSearchForm.getTechnology();
			Integer scholar = trainingSearchForm.getScholar();
			List<MentorSkill> mentorSkillsList = repo.findMentorByTechnology(technology, status);
			List<MentorSkillForm> formList = new ArrayList<MentorSkillForm>();
			for (MentorSkill mentorSkill: mentorSkillsList) {
				TechnologyForm technologyForm = technologyService.getTechnologyById(mentorSkill.getTechnology());
				LoginForm userForm = userService.getUserInfoById(mentorSkill.getMentor());
				List<TrainingForm> trainingFormList = 
						trainingService.getTrainingForMentorByTechnology(mentorSkill.getMentor(),
								"completed", mentorSkill.getTechnology());
				List<TrainingForm> trainingFormList2 = 
						trainingService.getTrainingForMentorAndScholarByTechnology(mentorSkill.getMentor(),
								scholar, "proposed", mentorSkill.getTechnology());
				MentorSkillForm form = new MentorSkillForm();
				form.setId(mentorSkill.getId());
				form.setMentor(mentorSkill.getMentor());
				form.setTechnologyId(mentorSkill.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setExperience(mentorSkill.getExperience());
				form.setStatus(mentorSkill.getStatus());
				form.setId(userForm.getId());
				form.setName(userForm.getName());
				form.setNoOfTrainings(trainingFormList.size());
				if(trainingFormList2.size() > 0) {
					form.setProposed(true);
				} else {
					form.setProposed(false);
				}
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	
	
	public boolean addMentorSkill(MentorSkillForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			repo.insertMentorSkill(form.getMentor(), form.getTechnologyId(), form.getExperience(), form.getStatus());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}
	
	public boolean approveMentorSkill(Integer id) {
		logger.info("Input data <= " + String.valueOf(id));
		try {
			repo.approveMentorSkill(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}
	
	public boolean updateExperience(Integer id , Integer experience) {
		logger.info("Input data <= " + String.valueOf(id));
		try {
			repo.updateExperience(id, experience);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}
	
	
}
