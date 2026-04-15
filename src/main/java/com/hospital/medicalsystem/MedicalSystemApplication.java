package com.hospital.medicalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan("com.hospital.medicalsystem.V2")
@EntityScan("com.hospital.medicalsystem.V2.domain.model")
@EnableJpaRepositories("com.hospital.medicalsystem.V2.domain.repository")
public class MedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemApplication.class, args);
	}

}
