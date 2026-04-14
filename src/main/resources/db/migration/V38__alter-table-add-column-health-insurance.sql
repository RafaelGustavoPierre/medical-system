ALTER TABLE exam_registred ADD COLUMN health_insurance_id BIGINT NOT NULL,
ADD CONSTRAINT fk_exam_registred_health_insurance FOREIGN KEY (health_insurance_id) REFERENCES health_insurance(id);