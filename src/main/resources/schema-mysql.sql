create table hibernate_sequence (next_val bigint);

insert into hibernate_sequence values ( 1 );

DROP TABLE IF EXISTS tbl_musica;

create table tbl_musica (
	id integer not null, 
	nm_musica varchar(120), 
	primary key (id)
) ;