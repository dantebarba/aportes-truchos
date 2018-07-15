package com.github.dantebarba.aportestruchos.controllers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.dantebarba.aportestruchos.IntegrationTest;
import com.github.dantebarba.aportestruchos.domain.EventLog;
import com.github.dantebarba.aportestruchos.dto.RequestDto;
import com.github.dantebarba.aportestruchos.repositories.LoggingRepository;
import com.google.gson.Gson;

public class EventLogControllerTest extends IntegrationTest {

	@Autowired
	LoggingController logging;

	@Autowired
	LoggingRepository repo;

	@Test
	@Transactional
	public void testEventLog() {
		RequestDto request = new RequestDto();
		request.uri = "localhost";
		request.url = "localhost";
		request.os = "123OS123";
		logging.log("127.0.0.1", new Gson().toJson(request));

		List<EventLog> events = (List<EventLog>) repo.findAll();

		Assert.assertTrue(!events.isEmpty());

		Assert.assertTrue(events.iterator().next().getIp().equals("127.0.0.1"));
	}

}
