package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuthServerConfig extends AuthorizationServerConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123Stella");
        return converter;
    }
    
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
	
    @Bean
    public TokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
        		   .checkTokenAccess("isAuthenticated()")
        		   .passwordEncoder(encoder());
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("garbage_app")
        				  .secret(/*"garbage" */"$2a$04$pvMIM2MPFl0wXH7jneGinOBzpMsDLYgCvQq4TfhE3mSEG5wYTeD1C")
        				  .scopes("garbage_application")
        				  .authorizedGrantTypes("password", "refresh_token")
        				  .accessTokenValiditySeconds(100);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    	
    	TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
          Arrays.asList(tokenEnhancer(), accessTokenConverter()));
    	
        endpoints.tokenStore(tokenStore())
        		 .tokenEnhancer(tokenEnhancerChain)
        		 .authenticationManager(authenticationManager)
        		 .userDetailsService(userDetailsService);
    }
}
