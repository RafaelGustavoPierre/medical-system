package com.hospital.medicalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
public class MedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSystemApplication.class, args);
	}

}
