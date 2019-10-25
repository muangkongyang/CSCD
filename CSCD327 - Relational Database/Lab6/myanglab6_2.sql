-- Lab6 (continued)

-- 8)
create table STORE_REPS(
 Rep_ID int(5),
 Last varchar(15),
 First varchar(10),
 Comm char(1) default 'Y',
 constraint Store_Rep_ID primary key(Rep_ID) );

-- 9)
alter table STORE_REPS
modify Last varchar(15) not null, 
modify First varchar(10) not null;

-- 10)
create table BOOK_STORES(
 Store_ID int(8) not null,
 Name varchar(30) unique not null,
 Contact varchar(20),
 Rep_ID int(5), 
 primary key(Store_ID) );
 
 drop table BOOK_STORES;
 -- 11)
 alter table BOOK_STORES
 modify Rep_ID int(5),
 add constraint book_stores_Rep_ID_fk
	foreign key(Rep_ID) references STORE_REPS(Rep_ID) on delete cascade;
 
 -- 12)
 create table REP_CONTRACTS(
  Store_ID int(8) not null,
  Name int(5),
  Quarter char(3) not null,
  Rep_ID int(5) not null,
  constraint rep_contracts_pk primary key(Store_ID, Rep_ID, Quarter),
  constraint rep_contracts_store_id_fk foreign key(Store_ID)
	references BOOK_STORES(Store_ID),
  constraint rep_contracts_rep_id_fk foreign key(Rep_id)
	references STORE_REPS(Rep_ID));
  
  drop table REP_CONTRACTS;