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
		RequestDto dto = getRequestDto();
		logging.log(servletRequest.getRemoteAddr(), new Gson().toJson(dto));
	}

	private RequestDto getRequestDto() {
		RequestDto dto = new RequestDto();
		dto.url = servletRequest.getRequestURL().toString();
		dto.uri = servletRequest.getRequestURI();
		dto.os = servletRequest.getHeader("User-Agent");
		dto.xforwardedfor = servletRequest.getHeader("X-FORWARDED-FOR");
		dto.httpxforwardedfor = servletRequest.getHeader("HTTP_X_FORWARDED_FOR");
		dto.httpxforwarded = servletRequest.getHeader("HTTP_X_FORWARDED");
		dto.httpclusterclientip = servletRequest.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
		dto.httpclientip = servletRequest.getHeader("HTTP_CLIENT_IP");
		dto.httpforwardedfor = servletRequest.getHeader("HTTP_FORWARDED_FOR");
		dto.httpforwarded = servletRequest.getHeader("HTTP_FORWARDED");
		dto.httpvia = servletRequest.getHeader("HTTP_VIA");
		return dto;
	}
}
