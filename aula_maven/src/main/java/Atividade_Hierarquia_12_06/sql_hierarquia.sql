create database bd_hierarquia;
use bd_hierarquia;

CREATE TABLE funcionario (
	cpf VARCHAR(12) NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    salario FLOAT(12) NOT NULL, 
    aniversario DATETIME DEFAULT NULL,
    telefone VARCHAR(11) DEFAULT NULL,
    departamento VARCHAR(255) DEFAULT NULL
);

CREATE TABLE gerente (
	cpf VARCHAR(12) NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    salario FLOAT(12) NOT NULL, 
    aniversario DATETIME DEFAULT NULL,
    telefone VARCHAR(11) DEFAULT NULL,
    departamento VARCHAR(255) DEFAULT NULL,
    gratificacao FLOAT(12) DEFAULT NULL, 
);

CREATE TABLE terceiro (
	cpf VARCHAR(12) NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
    ativo SMALLINT NOT NULL,
    situacao SMALLINT NOT NULL
);