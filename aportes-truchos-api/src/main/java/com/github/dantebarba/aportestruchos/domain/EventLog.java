package com.github.dantebarba.aportestruchos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.dantebarba.aportestruchos.domain.generics.EntidadBase;

@Entity
@Table(name = "eventlog")
public class EventLog extends EntidadBase {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ip;
	/**
	 * JSON request.
	 */
	private String request;
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getRequest() {
		return request;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public EventLog create(String ip, String request) {
		this.ip = ip;
		this.request = request;
		return this;
	}
	
	
}
