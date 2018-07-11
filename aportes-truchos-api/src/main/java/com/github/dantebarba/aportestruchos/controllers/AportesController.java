package com.github.dantebarba.aportestruchos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.github.dantebarba.aportestruchos.domain.Aporte;
import com.github.dantebarba.aportestruchos.repositories.AportesRepository;

@Controller
public class AportesController {

	@Autowired
	AportesRepository repo;	

	@Transactional(readOnly = true)
	public Page<Aporte> findAll(PageRequest page) {
		return repo.findAll(page);
	}
}
