package com.github.dantebarba.aportestruchos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.dantebarba.aportestruchos.domain.generics.EntidadBase;

@Entity
public class Usuario extends EntidadBase {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ip;
	
	/**
	 * MD5 de la IP.
	 */
	private String hashMd5;
	
	
	@Override
	public Long getId() {
		return this.id;
	}


	public String getHashMd5() {
		return hashMd5;
	}


	public void setHashMd5(String hashMd5) {
		this.hashMd5 = hashMd5;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

}
