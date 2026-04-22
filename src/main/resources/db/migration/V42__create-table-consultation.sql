CREATE TABLE consultation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    patient_id BIGINT NOT NULL,
    health_insurance_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    date_registration DATETIME NOT NULL,
    price DECIMAL(18,2) NOT NULL,
    observation VARCHAR(130),

    PRIMARY KEY (id),
    CONSTRAINT fk_consultation_patient_id FOREIGN KEY (patient_id) REFERENCES patient (id),
    CONSTRAINT fk_consultation_health_insurance_id FOREIGN KEY (health_insurance_id) REFERENCES health_insurance (id),
    CONSTRAINT fk_consultation_worker_id FOREIGN KEY (worker_id) REFERENCES worker (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;