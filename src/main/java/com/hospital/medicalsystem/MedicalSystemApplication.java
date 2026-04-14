package com.hospital.medicalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan("com.hospital.medicalsystem.V2")
public class MedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemApplication.class, args);
	}

}
