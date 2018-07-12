package com.github.dantebarba.aportestruchos.controllers;

import java.util.List;

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

	@Transactional(readOnly = true)
	public List<Aporte> findByDni(String dni) {
		return repo.findByDni(Utils.normalizar(dni));
	}
}
