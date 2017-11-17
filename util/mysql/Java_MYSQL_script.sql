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
    surname varchar(30)
);

create table doctor (
	idd int primary key auto_increment,
    dname varchar(20),
    surname varchar(20),
    specialization varchar(20),
    klatka_m char(1)
);

create table visits (
	idv int primary key auto_increment,
    idd int,
    idp int,
    vday varchar(10),
    vtime varchar(30),
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
 /*
-- wczytanie tabeli logowania
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_login.csv" INTO TABLE login FIELDS TERMINATED BY ';' IGNORE 1 LINES;
-- wczytanie tabeli miejsc
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_miejsca_final.csv" INTO TABLE miejsce FIELDS TERMINATED BY ';' IGNORE 1 LINES;
-- wczytanie tabeli klientów
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_klient.csv" INTO TABLE klient CHARACTER SET 'utf8mb4' FIELDS TERMINATED BY ';' IGNORE 1 LINES;
-- wczytanie tabeli samochodów
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_samochody.csv" INTO TABLE samochod CHARACTER SET 'utf8mb4' FIELDS TERMINATED BY ';' IGNORE 1 LINES;
-- wczytanie tabeli samochodów
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_piloty.csv" INTO TABLE pilot CHARACTER SET 'utf8mb4' FIELDS TERMINATED BY ';' IGNORE 1 LINES;
-- wczytanie tabeli statusu
LOAD DATA LOCAL INFILE "c:/Users/Gustaw/Desktop/KJ_Parking/KJ_status.csv" INTO TABLE status CHARACTER SET 'utf8mb4' FIELDS TERMINATED BY ';' IGNORE 1 LINES;

-- lista loginow
select * from login;

-- widok dla ochroniarza - rejestracje pojazdow majacych abonament w danym miesiącu
create view lista_aktywnych_pojazdow as select id_m, samochod.rejestracja, data_start, data_koniec from miejsce
	join status using(id_m) join klient using (id_k) join samochod using (id_s)
	where curdate() >= data_start and curdate() <= data_koniec order by rejestracja;
select * from lista_aktywnych_pojazdow;

-- widok klientow z rejestracjami oraz wykupionym abonamentem
create view lista_aktywnych_klientow as select id_m, klient.imie, klient.nazwisko, samochod.rejestracja, data_start, data_koniec from miejsce
	join status using(id_m) join klient using (id_k) join samochod using (id_s)
    where curdate() >= data_start and curdate() <= data_koniec order by id_m;
select * from lista_aktywnych_klientow;

-- widok posiadaczy pilotów
create view lista_posiadaczy_pilotow as select distinct imie, nazwisko, nr_p from status join klient using (id_k) join pilot using (id_p) order by nazwisko;
select * from lista_posiadaczy_pilotow;

-- widok klientów z abonamentem na więcej niż jeden miesiąc (mniej niż 12 miesięcy)
create view lista_klientow_premium as select id_m, klient.imie, klient.nazwisko, samochod.rejestracja, data_start, data_koniec from miejsce
	join status using(id_m) join klient using (id_k) join samochod using (id_s) where abs(month(data_start) - month(data_koniec)) > 1 order by id_m;
select * from lista_klientow_premium;

-- widok miejsc niewynajętych, które nie mają żadnych przeszkód
create view lista_miejsc_niewynajetych_bez_przeszkod as select id_m, opis_m, klatka_m from miejsce
	left join status using (id_m) where id_st is null and slup_lewy = 0 and slup_prawy = 0 and sciana_lewa = 0 and sciana_prawa = 0 and sciana_przod = 0 and opis_m != 'brak';
select * from lista_miejsc_niewynajetych_bez_przeszkod;

-- widok wszystkich miejsc wraz z aktywnymi samochodami oraz danymi klienta (imię, nazwisko)
create view lista_miejsc as select id_m, opis_m, coalesce(sa.rejestracja, ''), coalesce(kl.imie, ''),
	coalesce(kl.nazwisko, '') from miejsce as mi
	left join status as st using (id_m) left join klient as kl using (id_k)
	left join samochod as sa using (id_s) where mi.opis_m <> 'brak' order by mi.id_m;
select * from lista_miejsc;

-- lista wszystkich klientów i pojazdów
select imie, nazwisko, rejestracja, marka, model from klient join status using (id_k) join samochod using (id_s) order by nazwisko;

-- lista klientów z nadchodzącym abonamentem
select id_m, klient.imie, klient.nazwisko, samochod.rejestracja, data_start, data_koniec from miejsce
	join status using(id_m) join klient using (id_k) join samochod using (id_s) where curdate() < date(data_start) order by id_m;

-- lista klientów mających najwięcej pojazdów
select concat_ws(' ',imie, nazwisko) as wlasciciel, count(rejestracja) liczba_pojazdow from status
	join klient using (id_k) join samochod using (id_s) group by wlasciciel order by liczba_pojazdow desc, nazwisko;

select count(*) liczba_wszystkich_miejsc from miejsce where opis_m != 'brak';
select count(*) liczba_klientow from klient;
select count(*) liczba_samochodow from samochod;
select count(*) liczba_pilotow from pilot;

describe status; */