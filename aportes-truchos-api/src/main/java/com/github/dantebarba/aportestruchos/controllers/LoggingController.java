package com.github.dantebarba.aportestruchos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dantebarba.aportestruchos.domain.EventLog;
import com.github.dantebarba.aportestruchos.repositories.LoggingRepository;

@Controller
public class LoggingController {
	
	@Autowired
	LoggingRepository repo;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public EventLog log(String ip, String request) {
		return repo.saveAndFlush(new EventLog().create(ip, request));
	}
	
}
