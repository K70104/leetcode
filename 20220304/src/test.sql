

create table teacher (
    name varchar(20), age int,
    height double(3,1), weight double(3,1), sex varchar(20),
 education varchar(20), birthday datetime, id_card bigint);

create table books (
    name varchar(20), author varchar(20),
    prize int, classify varchar(20));

create table goods (name varchar(50), prize int,
    stock int, goods_describe varchar(50));