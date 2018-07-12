package com.github.dantebarba.aportestruchos.controllers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.github.dantebarba.aportestruchos.domain.Aporte;
import com.github.dantebarba.aportestruchos.repositories.AportesRepository;
import com.github.dantebarba.aportestruchos.support.Utils;

@Controller
public class AportesController {

	@Autowired
	AportesRepository repo;

	@Transactional(readOnly = true)
	public Page<Aporte> findAll(PageRequest page) {
		return repo.findAll(page);
	}

	public ResponseBuilder findByDni(String dni) {
		return Response.ok(repo.findByDni(Utils.normalizar(dni)), MediaType.APPLICATION_JSON);
	}
}
