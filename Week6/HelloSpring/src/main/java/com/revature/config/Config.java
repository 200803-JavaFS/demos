package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration
public class Config {
	
	@Bean(name="user")
	public User getUser() {
		return new User(getAccount());
	}
	
	@Bean(name="account")
	public Account getAccount() {
		return new Account();
	}

}
