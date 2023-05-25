create database empresa_coisas_coisas;
use empresa_coisas_coisas;

CREATE TABLE clientes (
	id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(255) DEFAULT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE servicos (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome ENUM('RE', 'RH', 'RA'),
    valor FLOAT NOT NULL
);

CREATE TABLE prestadores (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE prestadores_servicos (
	id_prestador INT NOT NULL,
    id_servico INT NOT NULL,
    FOREIGN KEY (id_prestador) REFERENCES prestadores(id),
    FOREIGN KEY (id_servico) REFERENCES servicos(id)
);

CREATE TABLE clientes_servicos (
    id_cliente INT NOT NULL,
    id_servico INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_servico) REFERENCES servicos(id),
    data_registro TIMESTAMP NOT NULL DEFAULT now()
);