package com.github.dantebarba.aportestruchos.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/api")
public class ApiInfo {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String info() {
		return "API Running. See docs for detail.";
	}

}
