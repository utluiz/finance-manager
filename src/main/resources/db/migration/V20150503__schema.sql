create table if not exists user (
	id int auto_increment primary key, 
	email varchar(100) unique not null,
	password varchar(64) not null,
	name varchar(50) not null,
	last_access datetime
);

create table if not exists balance (
	id int auto_increment primary key, 
	title varchar(100) not null,
	owner_id int not null,
	constraint fk_balance_user foreign key (owner_id) references user(id)
);

create table if not exists account (
	id int auto_increment primary key, 
	title varchar(50) not null,
	color varchar(10),
	balance_id int,
	constraint fk_account_balance foreign key (balance_id) references balance(id)
);

create table if not exists movement (
	id int auto_increment primary key,
	description varchar(250) not null,
	movement_date datetime not null,
	value decimal(10,2) not null,
	type char(1) not null,
	account_id int,
	constraint fk_movement_account foreign key (account_id) references account(id)
);

