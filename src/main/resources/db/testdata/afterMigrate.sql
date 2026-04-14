DELETE FROM health_insurance_patient;
DELETE FROM patient;

INSERT INTO patient (id, name, email, cpf, gender, registration_date, date_of_birth, father, mother, nationality, cell_phone, phone, address_street, address_number, address_neighborhood, address_city, address_state, address_complement, observation) VALUES
(1, 'João Laranja Fina', 'rafaelrestapi+joao@gmail.com', '12345678901', 'M', '2026-04-08 19:00:04', '1990-05-15 00:00:00', 'José Antônio Fina', 'Maria Laranja Fina', 'Brasileiro', '43991234567', '43999887766', 'Rua João Pessoa', '123', 'Centro', 'Londrina', 'PR', 'Apto 101', 'Paciente em acompanhamento ambulatorial'),
(2, 'Maria Joana', 'rafaelrestapi+maria@gmail.com', '98765432109', 'F', '2026-04-08 19:00:04', '1987-09-18 00:00:00', 'Carlos Eduardo Santos', 'Ana Paula Ferreira', 'Brasileira', '43998765432', '4333221100', 'Avenida Higienópolis', '456', 'Centro', 'Londrina', 'PR', 'Bloco B, Apto 302', 'Paciente em acompanhamento de rotina');

INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (1, 1);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (1, 2);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 1);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 3);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 4);
INSERT INTO health_insurance_patient (patient_id, health_insurance_id) VALUES (2, 5);