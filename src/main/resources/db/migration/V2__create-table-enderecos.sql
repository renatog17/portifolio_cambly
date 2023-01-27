create table enderecos(
	id bigint not null auto_increment,
	pais varchar(150) not null,
	cidade varchar(150) not null,
	
	primary key(id)
);