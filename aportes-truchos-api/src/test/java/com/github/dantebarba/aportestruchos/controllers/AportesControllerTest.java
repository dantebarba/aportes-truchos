package com.github.dantebarba.aportestruchos.controllers;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.dantebarba.aportestruchos.IntegrationTest;
import com.github.dantebarba.aportestruchos.domain.Aporte;

public class AportesControllerTest extends IntegrationTest {

	@Autowired
	AportesController aportesController;
	
	@Test
	public void testBuscarAporte() {
		List<Aporte> found = aportesController.findByDni("38204058");
	}
	
}
