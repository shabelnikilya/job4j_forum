CREATE TABLE authorities (
  id serial primary key,
  authority VARCHAR(50) NOT NULL unique
);
insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');
create table if not exists users (
    id serial primary key,
    username text not null unique,
    password text not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);
insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$ntYJ8xSMwDKsA/EiRZsbdeOmR9nNRuQZI7dvL854xcKxQDl4YwYpC',
(select id from authorities where authority = 'ROLE_ADMIN'));

create table if not exists posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now(),
  users_id int not null references users(id)
);

insert into posts (name, description, users_id) values ('О чем этот форум?', 'Форум на разнообразные темы!', 1);
insert into posts (name, description, users_id) values ('Правила форума.', 'Одно из основных правил - отсутствие рекламы!', 1);