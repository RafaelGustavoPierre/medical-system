CREATE TABLE exam (
	id bigint NOT NULL AUTO_INCREMENT,
	name varchar(35) NOT NULL,
	description varchar(120),

	PRIMARY KEY(id),
	UNIQUE(name)
);
INSERT INTO exam (name, description) VALUES ("Hemograma Completo", "Avalia glóbulos vermelhos, glóbulos brancos e plaquetas.");
INSERT INTO exam (name, description) VALUES ("Glicemia", "Mede os níveis de açúcar no sangue, importante no diagnóstico de diabetes.");
INSERT INTO exam (name, description) VALUES ("Raio-X", "Exame de imagem que utiliza radiação eletromagnética para visualizar estruturas internas do corpo, como ossos e órgãos.");
INSERT INTO exam (name, description) VALUES ("Ressonância Magnética", "A ressonância magnética usa campos magnéticos e ondas de rádio para gerar imagens detalhadas do corpo.");