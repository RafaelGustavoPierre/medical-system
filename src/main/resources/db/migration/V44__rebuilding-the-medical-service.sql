ALTER TABLE medical_service DROP FOREIGN KEY fk_exam_department_id;
ALTER TABLE medical_service RENAME INDEX fk_exam_department_id TO fk_medical_service_department_id;
ALTER TABLE medical_service ADD CONSTRAINT fk_medical_service_department_id FOREIGN KEY (department_id) REFERENCES department (id);