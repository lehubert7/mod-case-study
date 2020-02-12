package com.ibm.fsd.casestudy.mod.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsd.casestudy.mod.formbean.LoginForm;
import com.ibm.fsd.casestudy.mod.formbean.TechnologyForm;
import com.ibm.fsd.casestudy.mod.formbean.TrainingForm;
import com.ibm.fsd.casestudy.mod.jpa.entity.Training;
import com.ibm.fsd.casestudy.mod.jpa.repo.TrainingRepository;

@Service
public class TrainingService {
	
	@Autowired
	TrainingRepository repo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TechnologyService technologyService;
	
	private final Logger logger = LoggerFactory.getLogger(TrainingService.class);
	
	public List<TrainingForm> getTrainingByStatus(String status) {
		logger.info("Input data <= " + status);
		try {
			List<Training> trainingList = repo.findByStatus(status);
			List<TrainingForm> formList = new ArrayList<TrainingForm>();
			for (Training training: trainingList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<TrainingForm> getTrainingForScholar(Integer scholar, String status) {
		logger.info("Input data <= " + String.valueOf(scholar) + ", " + status);
		try {
			List<Training> trainingList = repo.findForScholarByStatus(scholar, status);
			List<TrainingForm> formList = new ArrayList<TrainingForm>();
			for (Training training: trainingList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<TrainingForm> getTrainingForMentor(Integer mentor, String status) {
		logger.info("Input data <= " + String.valueOf(mentor) + ", " + status);
		try {
			List<Training> trainingList = repo.findForMentorByStatus(mentor, status);
			List<TrainingForm> formList = new ArrayList<TrainingForm>();
			for (Training training: trainingList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<TrainingForm> getTrainingForMentorByTechnology(Integer mentor, 
			String status, Integer technology) {
		logger.info("Input data <= " + String.valueOf(mentor) + ", " + status + ", " + String.valueOf(technology));
		try {
			List<Training> trainingList = repo.findForMentorByStatusAndTechnology(mentor, status, technology);
			List<TrainingForm> formList = new ArrayList<TrainingForm>();
			for (Training training: trainingList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public List<TrainingForm> getTrainingForMentorAndScholarByTechnology(Integer mentor, Integer scholar,
			String status, Integer technology) {
		logger.info("Input data <= " + String.valueOf(mentor) + ", " + String.valueOf(scholar) + ", " 
			+ status + ", " + String.valueOf(technology));
		try {
			List<Training> trainingList = repo.findForMentorAndScholarByStatusAndTechnology(mentor, scholar, status, technology);
			List<TrainingForm> formList = new ArrayList<TrainingForm>();
			for (Training training: trainingList) {
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public TrainingForm getTrainingById(Integer id) {
		logger.info("Input data <= " + String.valueOf(id));
		try {
			List<Training> trainingList = repo.findByIdentity(id);
			if(trainingList.size() > 0) {
				Training training = trainingList.get(0);
				TechnologyForm technologyForm = 
						technologyService.getTechnologyById(training.getTechnology());
				LoginForm scholarForm = userService.getUserInfoById(training.getScholar());
				LoginForm mentorForm = userService.getUserInfoById(training.getMentor());
				TrainingForm form = new TrainingForm();
				form.setId(training.getId());
				form.setScholarId(training.getScholar());
				form.setScholar(scholarForm.getName());
				form.setMentorId(training.getMentor());
				form.setMentor(mentorForm.getName());
				form.setTechnologyId(training.getTechnology());
				form.setTechnology(technologyForm.getName());
				form.setStartdate(training.getStartdate());
				form.setProgress(training.getProgress());
				form.setStatus(training.getStatus());
				logger.info("Output data => " + form.toString());
				return form;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		logger.info("Output data => NULL");
		return null;
	}
	
	
	public boolean addTraining(TrainingForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			repo.insertTraining(form.getScholarId(), form.getMentorId(), 
					form.getTechnologyId(), form.getStartdate(), form.getEnddate());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}
	
	public boolean updateStatus(TrainingForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			repo.updateTrainingById(form.getId(), form.getStatus());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}

}
