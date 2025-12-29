package com.jobintech.SpringMS;

import com.jobintech.SpringMS.model.Personne;
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
        return args -> {
            personneRepository.save(new Personne(null, "Lina", "douiri"));
            personneRepository.save(new Personne(null, "Farah", "douiri"));
            personneRepository.save(new Personne(null, "salah", "regbi"));

        };
    }
}