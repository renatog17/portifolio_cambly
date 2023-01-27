create table estudantes(
	id bigint not null auto_increment,
	nome varchar(150) not null,
	cpf varchar(150) not null,
	pais varchar(140) not null,
	cidade varchar(140) not null,
	primary key(id)
);