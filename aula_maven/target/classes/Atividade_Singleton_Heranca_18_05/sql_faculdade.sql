create database bd_faculdade;
use bd_faculdade;

CREATE TABLE alunos (
	id INT NOT NULL AUTO_INCREMENT,
    matricula VARCHAR(200) NOT NULL,
    cpf VARCHAR(12) DEFAULT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE professores (
	id INT NOT NULL AUTO_INCREMENT,
    matricula VARCHAR(200) NOT NULL,
    cpf VARCHAR(12) DEFAULT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id)
);