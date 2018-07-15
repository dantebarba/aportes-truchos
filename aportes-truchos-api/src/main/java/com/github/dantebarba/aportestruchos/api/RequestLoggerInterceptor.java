package com.github.dantebarba.aportestruchos.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dantebarba.aportestruchos.controllers.LoggingController;
import com.github.dantebarba.aportestruchos.dto.RequestDto;
import com.google.gson.Gson;

@Provider
@Component
public class RequestLoggerInterceptor implements ContainerRequestFilter {

	@Autowired
	LoggingController logging;

	@Context
	private HttpServletRequest servletRequest;

	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		RequestDto dto = new RequestDto();
		dto.url = servletRequest.getRequestURL().toString();
		dto.uri = servletRequest.getRequestURI();
		dto.os = servletRequest.getHeader("User-Agent");
		logging.log(servletRequest.getRemoteAddr(), new Gson().toJson(dto));
	}
}
