CREATE TABLE worker_health_insurance (
    worker_id BIGINT NOT NULL,
    health_insurance_id BIGINT NOT NULL,

    PRIMARY KEY (worker_id, health_insurance_id),
    CONSTRAINT fk_worker_health_insurance_worker FOREIGN KEY (worker_id) REFERENCES worker(id),
    CONSTRAINT fk_worker_health_insurance_health_insurance FOREIGN KEY (health_insurance_id) REFERENCES health_insurance(id)
);