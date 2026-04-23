ALTER TABLE exam_registred DROP FOREIGN KEY exam_registred_ibfk_1;
ALTER TABLE exam_registred DROP FOREIGN KEY fk_exam_registred_worker_id;
ALTER TABLE exam_registred DROP FOREIGN KEY fk_exam_registred_health_insurance;
ALTER TABLE exam_registred DROP FOREIGN KEY fk_exam_registred_patient;

RENAME TABLE exam_registred TO medical_service_registered;

ALTER TABLE medical_service_registered RENAME COLUMN exam_id TO service_id;

ALTER TABLE medical_service_registered RENAME INDEX exam_id TO idx_medical_service_registered_service_id;
ALTER TABLE medical_service_registered RENAME INDEX fk_exam_registred_worker_id TO idx_medical_service_registered_worker_id;
ALTER TABLE medical_service_registered RENAME INDEX fk_exam_registred_health_insurance TO idx_medical_service_registered_health_insurance_id;
ALTER TABLE medical_service_registered RENAME INDEX fk_exam_registred_patient TO idx_medical_service_registered_patient_id;

ALTER TABLE medical_service_registered ADD CONSTRAINT fk_medical_service_registered_service_id FOREIGN KEY (service_id) REFERENCES medical_service (id);
ALTER TABLE medical_service_registered ADD CONSTRAINT fk_medical_service_registered_worker_id FOREIGN KEY (worker_id) REFERENCES worker (id);
ALTER TABLE medical_service_registered ADD CONSTRAINT fk_medical_service_registered_health_insurance_id FOREIGN KEY (health_insurance_id) REFERENCES health_insurance (id);
ALTER TABLE medical_service_registered ADD CONSTRAINT fk_medical_service_registered_patient_id FOREIGN KEY (patient_id) REFERENCES patient (id);