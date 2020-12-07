create table users(
user_id serial primary key,
user_name varchar(40) not null,
user_password varchar(40) not null);

create table users_query(
query_id serial primary key,
URL text not null,
response text,
user_id int not null,
foreign key(user_id)references users(user_id));

insert into users(user_id,user_name,user_password) values(1,'rahul','cmFodWw='); //rahul
insert into users(user_name,user_password) values('pankaj','cm9vdA=='); //root
