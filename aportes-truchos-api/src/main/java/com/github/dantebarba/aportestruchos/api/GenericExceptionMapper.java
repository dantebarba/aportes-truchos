package com.github.dantebarba.aportestruchos.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.github.dantebarba.aportestruchos.dto.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		setHttpStatus(ex, errorMessage);
		errorMessage.setMessage(ex.getMessage());
		return Response.status(errorMessage.getStatus()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
	}

	private void setHttpStatus(Throwable ex, ErrorMessage errorMessage) {
		if (ex instanceof WebApplicationException) {
			errorMessage.setStatus(((WebApplicationException) ex).getResponse().getStatus());
		} else {
			errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
			// 500
		}
	}
}
