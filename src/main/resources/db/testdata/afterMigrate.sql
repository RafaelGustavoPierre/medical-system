set FOREIGN_KEY_CHECKS = 0;
DELETE FROM exam_registred;
DELETE FROM remedie_registred;
DELETE FROM patient_historic;

set FOREIGN_KEY_CHECKS = 1;
ALTER TABLE exam_registred AUTO_INCREMENT = 1;
ALTER TABLE remedie_registred  AUTO_INCREMENT = 1;
ALTER TABLE patient_historic AUTO_INCREMENT = 1;


INSERT INTO patient_historic (patient_id, worker_id, date_admission, status) VALUES (1, 3, CURRENT_TIMESTAMP(), 'HOSPITALIZED');
INSERT INTO remedie_registred (remedie_id, price, quantity, time_registred, patient_historic_id) VALUES (1, 2.74, 1, CURRENT_TIMESTAMP(), 1);
UPDATE patient_historic SET date_discharge = CURRENT_TIMESTAMP(), status = 'DISCHARGE' WHERE id = 1;

INSERT INTO patient_historic (patient_id, worker_id, date_admission, status) VALUES (1, 2, CURRENT_TIMESTAMP(), 'HOSPITALIZED');
INSERT INTO remedie_registred (remedie_id, price, quantity, time_registred, patient_historic_id) VALUES (3, 8.99, 1, CURRENT_TIMESTAMP(), 2);
INSERT INTO exam_registred (exam_id, price, start_time, end_time, worker_id, patient_historic_id) VALUES (1, 189.99, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 5, 2);


-- NÃO REMOVER ANTES DE TIRAR OS INSERTS
ALTER TABLE remedie_registred MODIFY patient_historic_id BIGINT NOT NULL;
ALTER TABLE exam_registred MODIFY patient_historic_id BIGINT NOT NULL;