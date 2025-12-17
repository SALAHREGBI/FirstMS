package com.jobintech.SpringMS;

import com.jobintech.SpringMS.repositories.PersonneRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsApplication.class, args);
	}

    @Bean
    ApplicationRunner Start(PersonneRepository personneRepository) {
        return  args -> {
            personneRepository.save(new com.jobintech.SpringMS.model.Personne("Lina", "douiri"));
            personneRepository.save(new com.jobintech.SpringMS.model.Personne("Farah", "douiri"));
            personneRepository.save(new com.jobintech.SpringMS.model.Personne("salah", "regbi"));
            personneRepository.save(new com.jobintech.SpringMS.model.Personne("simo", "alaoui"));
        };
    }
}

