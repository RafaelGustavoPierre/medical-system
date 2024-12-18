set FOREIGN_KEY_CHECKS = 0;
DELETE FROM exam_registred;
DELETE FROM remedie_registred;

set FOREIGN_KEY_CHECKS = 1;
ALTER TABLE exam_registred AUTO_INCREMENT = 1;
ALTER TABLE remedie_registred  AUTO_INCREMENT = 1;

INSERT INTO remedie_registred (patient_id, remedie_id, price, quantity, time_registred) VALUES (1, 3, 8.99, 1, CURRENT_TIMESTAMP());
INSERT INTO remedie_registred (patient_id, remedie_id, price, quantity, time_registred) VALUES (2, 2, 124.50, 1, CURRENT_TIMESTAMP());
INSERT INTO remedie_registred (patient_id, remedie_id, price, quantity, time_registred) VALUES (2, 1, 124.50, 1, CURRENT_TIMESTAMP());

INSERT INTO exam_registred (patient_id , exam_id, price, start_time, end_time, worker_id) VALUES (1, 1, 189.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 4);
INSERT INTO exam_registred (patient_id , exam_id, price, start_time, end_time, worker_id) VALUES (2, 2, 249.98, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 4);