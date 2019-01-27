package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.AppUserRepository;

public class CustomTokenEnhancer implements TokenEnhancer {
	
	@Autowired
	AppUserRepository repo;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        
        AppUser user = repo.findByUsername(authentication.getName());
        
        if(user != null && user.getArea() != null)
        	additionalInfo.put("area", user.getArea().getNome());
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        
        return accessToken;
	}

}
