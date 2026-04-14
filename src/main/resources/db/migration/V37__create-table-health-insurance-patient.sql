CREATE TABLE health_insurance_patient (
	patient_id bigint NOT NULL,
	health_insurance_id bigint NOT NULL,
	KEY `fk_health_insurance_patient_patient_id` (`patient_id`),
	KEY `fk_health_insurance_patient_health_insurance_id` (`health_insurance_id`),
	CONSTRAINT `fk_health_insurance_patient_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
	CONSTRAINT `fk_health_insurance_patient_health_insurance_id` FOREIGN KEY (`health_insurance_id`) REFERENCES `health_insurance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;