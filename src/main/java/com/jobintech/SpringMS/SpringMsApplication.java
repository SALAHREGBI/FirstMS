package com.jobintech.SpringMS;


import com.jobintech.SpringMS.model.DBUser;
import com.jobintech.SpringMS.repositories.DBUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsApplication.class, args);
	}

    @Bean
    CommandLineRunner start(DBUserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            String encodedPassword = passwordEncoder.encode("1234");

            DBUser user1 = new DBUser(null, "salah", encodedPassword, "ADMIN");

            userRepository.save(user1);
            System.out.println("User 'salah' t-stoka f MySQL m-hashi b BCrypt!");
        };
    }
}