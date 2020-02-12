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

import com.ibm.fsd.casestudy.mod.formbean.TrainingForm;
import com.ibm.fsd.casestudy.mod.service.TrainingService;

@Controller
@RequestMapping("/mod/training")
public class TrainingController {

	@Autowired
	TrainingService service;
	
	private final Logger logger = LoggerFactory.getLogger(TrainingController.class);
	
	@RequestMapping(value="/status/{status}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TrainingForm>> getTrainingByStatus(@PathVariable String status) {
		logger.info("Request received.. data <= " + status);
		List<TrainingForm> formList = service.getTrainingByStatus(status);
		
		if(formList != null) {
			logger.info("Response data List size => " + formList.size());
			return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/mentor/{mentor}/status/{status}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TrainingForm>> getTrainingForMentor(
			@PathVariable Integer mentor, @PathVariable String status) {
		logger.info("Request received.. data <= " + String.valueOf(mentor) + status);
		List<TrainingForm> formList = service.getTrainingForMentor(mentor, status);
		
		if(formList != null) {
			logger.info("Response data List size => " + formList.size());
			return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/scholar/{scholar}/status/{status}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TrainingForm>> getTrainingForScholar(
			@PathVariable Integer scholar, @PathVariable String status) {
		logger.info("Request received.. data <= " + String.valueOf(scholar) + status);
		List<TrainingForm> formList = service.getTrainingForScholar(scholar, status);
		
		if(formList != null) {
			logger.info("Response data List size => " + formList.size());
			return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<List<TrainingForm>>(formList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<TrainingForm> getTrainingById(@PathVariable Integer id) {
		logger.info("Request received.. data <= " + String.valueOf(id));
		TrainingForm form = service.getTrainingById(id);
		if(form != null) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<TrainingForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<TrainingForm>(form, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TrainingForm> add(@RequestBody TrainingForm form) {
		logger.info("Request received.. data <= " + form.toString());
		if(service.addTraining(form)) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<TrainingForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<TrainingForm>(form, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/update/status", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TrainingForm> updateStatus(@RequestBody TrainingForm form) {
		logger.info("Request received.. data <= " + form.toString());
		if(service.updateStatus(form)) {
			logger.info("Response data => " + form.toString());
			return new ResponseEntity<TrainingForm>(form, HttpStatus.OK);
		}
		logger.info("Response data => NULL");
		return new ResponseEntity<TrainingForm>(form, HttpStatus.BAD_REQUEST);
	}
}
