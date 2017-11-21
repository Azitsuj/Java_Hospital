drop database if exists hospital;

create database hospital;

use hospital;

-- tworzy uzytkownika na potrzeby Pythona
drop user if exists KJ_Java_hospital;
create user KJ_Java_hospital identified by 'strongPasswordWouldBeNice';
grant select, insert, delete, update on hospital.* to 'KJ_Java_hospital'@'localhost' identified by 'strongPasswordWouldBeNice';

-- tworzenie tabel
create table patient (
	idp int primary key auto_increment,
    pname varchar(20),
    psurname varchar(30)
);

create table doctor (
	idd int primary key auto_increment,
    dname varchar(20),
    dsurname varchar(20),
    specialization varchar(20)   
);

create table visits (
	idv int primary key auto_increment,
    idd int,
    idp int,
    vday varchar(10),
    vtime_start varchar(10),
    vtime_end varchar(10),
    foreign key (idd) references doctor (idd),
    foreign key (idp) references patient (idp)
);

create table doctor_schedule (
	idds int primary key auto_increment,
    idd int,
    dday varchar(10),
    dtime_start varchar(30),
    dtime_end varchar(30),
    foreign key (idd) references doctor (idd)
);
 
 
 SELECT idds, doctor.idd, doctor.dname, doctor.dsurname, dday, dtime_start, dtime_end specialization FROM doctor_schedule 
 JOIN doctor USING(idd);