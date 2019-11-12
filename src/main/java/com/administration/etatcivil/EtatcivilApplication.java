package com.administration.etatcivil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EtatcivilApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtatcivilApplication.class, args);
	}
	
	//@Bean
    //public BCryptPasswordEncoder bCryptPasswordEncoder() {
      //  return new BCryptPasswordEncoder();
    //}

}
