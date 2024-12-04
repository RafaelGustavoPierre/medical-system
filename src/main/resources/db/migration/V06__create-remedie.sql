CREATE TABLE remedie (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(35) NOT NULL,
	description varchar(120),

	PRIMARY KEY(id),
	UNIQUE(name)
);
INSERT INTO remedie (name, description) VALUES ("Paracetamol (Tylenol)", "Seguro para muitas pessoas, usado para alívio de dores leves.");
INSERT INTO remedie (name, description) VALUES ("Morfina", "Controle de desconforto em pacientes com insuficiência cardíaca ou edema pulmonar agudo.");
INSERT INTO remedie (name, description) VALUES ("Insulina regular", "Reduz os níveis de glicose no sangue. Pode ser de ação rápida, intermediária ou prolongada.");