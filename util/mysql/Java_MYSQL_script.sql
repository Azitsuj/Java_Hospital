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
    vtime_start datetime,
    vtime_end datetime,
    foreign key (idd) references doctor (idd),
    foreign key (idp) references patient (idp)
);

create table doctor_schedule (
	idds int primary key auto_increment,
    idd int,
    dtime_start datetime,
    dtime_end datetime,
    foreign key (idd) references doctor (idd)
);
 
 
 SELECT idds, doctor.idd, doctor.dname, doctor.dsurname, dtime_start, dtime_end specialization FROM doctor_schedule 
 JOIN doctor USING(idd) where idd = 1;
 
 
 insert into visits (idd, idp, vday, vtime_start, vtime_end) values (1, null, '2017-11-02', '2017-11-02 10:00', '2017-11-02 11:00');
 select * from visits;
 select * from doctor_schedule;
 select * from doctor;
 alter table doctor_schedule drop dday;
 delete from visits;
 delete from doctor_schedule;
 SELECT idds, doctor.idd, doctor.dname, doctor.dsurname, dtime_start, dtime_end, doctor.specialization FROM 
 doctor_schedule JOIN doctor USING (idd) WHERE idds = 15;
 
 select * from visits where idd = 1 AND vtime_start >= '2017-11-05 11:20:00';
 
 SELECT idv, idd, doctor.dname, doctor.dsurname, doctor.specialization, idp, patient.pname, 
 patient.psurname, vtime_start, vtime_end FROM visits JOIN doctor USING(idd) LEFT JOIN patient USING(idp) WHERE idd = 1;