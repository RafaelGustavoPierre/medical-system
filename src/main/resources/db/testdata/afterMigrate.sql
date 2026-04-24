DELETE FROM consultation;
DELETE FROM health_insurance_patient;
DELETE FROM medical_service_registered;
DELETE FROM patient;

ALTER TABLE consultation AUTO_INCREMENT = 1;
ALTER TABLE health_insurance_patient AUTO_INCREMENT = 1;

INSERT INTO patient (id, name, email, cpf, gender, registration_date, date_of_birth, father, mother, nationality, cell_phone, phone, address_street, address_number, address_neighborhood, address_city, address_state, address_complement, observation) VALUES
(1, 'João Laranja Fina', 'rafaelrestapi+joao@gmail.com', '12345678901', 'M', '2026-04-08 19:00:04', '1990-05-15 00:00:00', 'José Antônio Fina', 'Maria Laranja Fina', 'Brasileiro', '43991234567', '43999887766', 'Rua João Pessoa', '123', 'Centro', 'Londrina', 'PR', 'Apto 101', 'Paciente em acompanhamento ambulatorial'),
(2, 'Maria Joana', 'rafaelrestapi+maria@gmail.com', '98765432109', 'F', '2026-04-08 19:00:04', '1987-09-18 00:00:00', 'Carlos Eduardo Santos', 'Ana Paula Ferreira', 'Brasileira', '43998765432', '4333221100', 'Avenida Higienópolis', '456', 'Centro', 'Londrina', 'PR', 'Bloco B, Apto 302', 'Paciente em acompanhamento de rotina'),
(3, 'Reginaldu Couves', 'rafaelrestapi+reginaldu@gmail.com', '15487598632', 'M', '2026-04-08 19:00:04', '1987-09-18 00:00:00', 'Aguiar Antonio Silva', 'Joana Antonia Silva', 'Brasileira', '43998765434', '4333221104', 'Avenida do Sete', '216', 'Centro', 'Londrina', 'PR', 'Bloco A, Apto 12', 'Paciente em acompanhamento de rotina');

INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (1, 2);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 3);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 4);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 5);

INSERT INTO medical_service_registered (id, medical_service_id, price, start_time, end_time, worker_id, health_insurance_id, patient_id) VALUES(78, 5, 12.50, '2026-04-22 01:16:15.000', NULL, 5, 1, 2);

INSERT INTO consultation (id, patient_id, health_insurance_id, worker_id, date_registration, price, observation) VALUES(1, 2, 1, 5, '2026-04-22 19:17:36.000', 12.90, 'Reclamando de dor no PÉ');
