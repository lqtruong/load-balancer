use `loadbalancing`;

create table if not exists `accounts`(
    `id`            integer primary key auto_increment,
    `fullname`      varchar(100) not null,
    `dob`           date not null,
    `email`         varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `accounts`
(
    id, email, fullname, dob, createdAt, modifiedAt
) values
(1, 'truong@mail.com', 'Truong Le', '1983-05-21', sysdate(), sysdate())
,(2, 'peter@mail.com', 'peter Pin', '1999-07-12', sysdate(), sysdate())
;

select * from accounts;