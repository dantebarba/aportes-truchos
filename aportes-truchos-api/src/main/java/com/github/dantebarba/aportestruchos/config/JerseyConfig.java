package com.github.dantebarba.aportestruchos.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.github.dantebarba.aportestruchos.api.ApiInfo;
import com.github.dantebarba.aportestruchos.api.AportesApi;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
        // register(...);
    	packages("com.github.dantebarba.mapadeldelito.api");
    	register(AportesApi.class);
    	register(ApiInfo.class);
    }
}
