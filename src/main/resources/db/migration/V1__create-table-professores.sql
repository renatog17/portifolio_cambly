create table professores(
	id bigint not null auto_increment,
	nome varchar(255) not null,
	sotaque varchar(40) not null,
	pais varchar(140) not null,
	cidade varchar(140) not null,
	
	primary key(id)
);