package com.ibm.fsd.casestudy.mod.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsd.casestudy.mod.formbean.TechnologyForm;
import com.ibm.fsd.casestudy.mod.jpa.entity.Technology;
import com.ibm.fsd.casestudy.mod.jpa.repo.TechnologyRepository;

@Service
public class TechnologyService {

	@Autowired
	TechnologyRepository repo;
	
	private final Logger logger = LoggerFactory.getLogger(TechnologyService.class);
	
	public List<TechnologyForm> getAllTechnologies() {
		logger.info("Input data <= N/A");
		try {
			List<Technology> TechnologyList = repo.findAll();
			List<TechnologyForm> formList = new ArrayList<TechnologyForm>();
			for (Technology technology: TechnologyList) {
				TechnologyForm form = new TechnologyForm();
				form.setId(technology.getId());
				form.setName(technology.getName());
				form.setDuration(technology.getDuration());
				form.setCost(technology.getCost());
				formList.add(form);
			}
			logger.info("Output data List size => " + formList.size());
			return formList;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public TechnologyForm getTechnologyById(Integer id) {
		logger.info("Input data <= " + String.valueOf(id));
		try {
			List<Technology> technologyList = repo.findByIdentity(id);
			if(technologyList.size() > 0) {
				Technology technology = technologyList.get(0);
				TechnologyForm form = new TechnologyForm();
				form.setId(technology.getId());
				form.setName(technology.getName());
				form.setDuration(technology.getDuration());
				form.setCost(technology.getCost());
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
	
	public boolean registerTechnology(TechnologyForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			repo.insertTechnology(form.getName(), form.getDuration(),
					form.getCost());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		logger.info("Output data => SUCCESS");
		return true;
	}
}
