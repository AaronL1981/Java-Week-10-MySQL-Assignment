create database if not exist vehicles;

use vehicles;

drop table if exist vehicles;

create table vehicles (
		id int(10) not null auto_increment,
		vehicle type varchar(10) not null,
		make varchar(50) not null,
		model varchar(50) not null,
		primary key(id)
);