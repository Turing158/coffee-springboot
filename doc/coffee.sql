create database coffee;
create table goods
(
    id          int          not null,
    name        varchar(100) null,
    introduce   varchar(255) null,
    price       double       null,
    classname   varchar(12) null,
    temperature varchar(255) null,
    sugar       varchar(255) null,
    img         varchar(255) null
);

create table orders
(
    id          varchar(255) null,
    goods       varchar(255) null,
    user        varchar(255) null,
    date        datetime     null,
    price       double       null,
    status      int          null,
    number      int          null,
    useForm     varchar(10)  null,
    reservation varchar(50)  null,
    note        varchar(255) null
);

create table user
(
    user     varchar(255) not null,
    password varchar(255) null,
    name     varchar(255) null,
    num      int          null,
    phone    varchar(44) null
);

