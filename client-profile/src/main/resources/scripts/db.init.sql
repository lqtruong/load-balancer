use `loadbalancing`;

create table if not exists `profiles`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `app`           varchar(20) not null,
    `createdAt`     datetime not null default current_timestamp,
    `modifiedAt`    datetime not null default current_timestamp
);

insert into `profiles`
(
    id, email, username, app, createdAt, modifiedAt
) values
(1, 'truong@mail.com', 'truong', 'eshop', sysdate(), sysdate())
,(2, 'charles@mail.com', 'charles', 'eshop', sysdate(), sysdate())
;

select * from profiles;