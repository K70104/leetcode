
create table books (author varchar(20), price int, publish_date datetime);

insert into books values (11, 50, '2022-01-02'), (13, 70, '2020-02-03'), (22, 100, '2000-11-03');

select * from books where author is not null or (price > 50 and publish_date > '2019-01-01');





create table article (title varchar(20), create_date datetime);

insert into article values ('111', '2019-01-01'), ('222', '2022-02-11'), ('321', '2020-12-26');

insert into article values (null, '2001-02-12');



insert into article values ('232', '2019-01-01 11:12:12'), ('685', '2019-06-23 14:12:00');

select * from article where create_date between '2019-01-01 10:30:00' and '2019-11-10 14:02:00';