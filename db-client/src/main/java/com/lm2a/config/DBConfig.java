package com.lm2a.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@RefreshScope
public class DBConfig {

	@Value("${application.name}")
	private String applicationName;
	
	@Value("${functionality.active}")
	private boolean functionalityActive;

	public boolean isFunctionalityActive() {
		return functionalityActive;
	}

	public void setFunctionalityActive(boolean functionalityActive) {
		this.functionalityActive = functionalityActive;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	
}
