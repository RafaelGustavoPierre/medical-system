CREATE TABLE remedie_registred (
	id bigint NOT NULL AUTO_INCREMENT,
	patient_historic_id bigint NOT NULL,
	remedie_id bigint NOT NULL,
	price DECIMAL(18,2) NOT NULL,
	quantity bigint NOT NULL,
	time_registred datetime NOT NULL,

	PRIMARY KEY(id),
	FOREIGN KEY (remedie_id) REFERENCES remedie(id),
	FOREIGN KEY (patient_historic_id) REFERENCES patient_historic(id)
);
INSERT INTO remedie_registred (patient_historic_id, remedie_id, price, quantity, time_registred) VALUES (1, 3, 8.99, 1, CURRENT_TIMESTAMP());
INSERT INTO remedie_registred (patient_historic_id, remedie_id, price, quantity, time_registred) VALUES (2, 2, 124.50, 1, CURRENT_TIMESTAMP());
INSERT INTO remedie_registred (patient_historic_id, remedie_id, price, quantity, time_registred) VALUES (2, 1, 124.50, 1, CURRENT_TIMESTAMP());