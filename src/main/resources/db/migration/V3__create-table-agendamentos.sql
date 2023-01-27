create table agendamentos(
		id bigint not null auto_increment,
		dataAgendamento date not null,
		hora time not null,
		professor_id bigint not null,
		estudante_id bigint not null,
		primary key(id),
		foreign key (professor_id) references professores (id),
		foreign key (estudante_id) references estudantes (id)
)
