create table REALMS
(
	id int auto_increment,
	name VARCHAR not null,
	description VARCHAR(255),
	key VARCHAR(32) not null
);

create unique index REALMS_id_uindex
	on REALMS (id);

create unique index REALMS_name_uindex
	on REALMS (name);

alter table REALMS
	add constraint REALMS_pk
		primary key (id);

