create database Teste;

use Teste;

create table UsuarioTeste(
senha_usuario int(45) primary key AUTO_INCREMENT,
Nome_teste varchar(45) not null

);

create table Estoque(
id int primary key AUTO_INCREMENT,
nome varchar(45) not null,
descricao varchar(40) not null,
quantidade int not null,
preco double not null 
);
