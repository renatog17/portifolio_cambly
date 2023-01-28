alter table professores add ativo tinyint not null;
alter table estudantes add ativo tinyint not null;
update estudantes set ativo = 1;
update professores set ativo = 1;