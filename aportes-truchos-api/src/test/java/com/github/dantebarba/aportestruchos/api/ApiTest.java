package com.github.dantebarba.aportestruchos.api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.github.dantebarba.aportestruchos.IntegrationTest;


public class ApiTest extends IntegrationTest {
	
	@Test
	public void testApiInfo() {
		Client client = ClientBuilder.newClient();
		WebTarget employeeWebTarget 
		  = client.target("http://127.0.0.1:"+this.port).path("api");
		String output = employeeWebTarget.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotNull(output);
	}
	
}
