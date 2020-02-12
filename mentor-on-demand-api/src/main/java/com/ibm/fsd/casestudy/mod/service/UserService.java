package com.ibm.fsd.casestudy.mod.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fsd.casestudy.mod.formbean.LoginForm;
import com.ibm.fsd.casestudy.mod.jpa.entity.User;
import com.ibm.fsd.casestudy.mod.jpa.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public LoginForm validateCredentials(LoginForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			List<User> userList = repo.findByEmail(form.getEmail());
			if(userList.size() > 0) {
				User user = userList.get(0);
				if(form.getPassword().equals(user.getPassword())) {
					form.setId(user.getId());
					form.setName(user.getName());
					form.setLocation(user.getLocation());
					form.setUsertype(user.getUsertype());
					logger.info("Output data => " + form.toString());
					return form;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		logger.info("Output data => NULL");
		return null;
	}
	
	public LoginForm getUserInfoById(Integer id) {
		logger.info("Input data <= " + String.valueOf(id));
		try {
			List<User> userList = repo.findByIdentity(id);
			if(userList.size() > 0) {
				User user = userList.get(0);
				LoginForm form = new LoginForm();
				form.setId(user.getId());
				form.setName(user.getName());
				form.setEmail(user.getEmail());
				form.setLocation(user.getLocation());
				form.setUsertype(user.getUsertype());
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
	
	public LoginForm registerUser(LoginForm form) {
		logger.info("Input data <= " + form.toString());
		try {
			repo.insertUser(form.getName(), form.getEmail(),
					form.getPassword(), form.getUsertype(), form.getLocation());
			List<User> userList = repo.findByEmail(form.getEmail());
			if(userList.size() > 0) {
				User user = userList.get(0);
				form.setId(user.getId());
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

}
