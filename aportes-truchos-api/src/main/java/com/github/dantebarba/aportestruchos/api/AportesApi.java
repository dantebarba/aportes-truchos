package com.github.dantebarba.aportestruchos.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.github.dantebarba.aportestruchos.controllers.AportesController;

@Component
@Path("/api/aportes")
public class AportesApi {

	@Autowired
	AportesController aportesController;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAportes(@QueryParam("from") Integer from, @QueryParam("size") Integer size) {
		return Response.ok(aportesController.findAll(new PageRequest(from, size)).getContent()).build();
	}
	
	@GET
	@Path("/{dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarAporte(@PathParam("dni") String dni) {
		return Response.ok(aportesController.findByDni(dni)).build();
	}
}
