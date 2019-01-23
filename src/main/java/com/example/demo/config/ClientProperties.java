package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "oauth.client")
@Configuration("clientProperties")
public class ClientProperties {
	private String username;
	private String secret;
	private String scopes;
}
