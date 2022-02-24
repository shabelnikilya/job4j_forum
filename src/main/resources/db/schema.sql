CREATE TABLE authorities (
  id serial primary key,
  authority VARCHAR(50) NOT NULL unique
);

create table if not exists users (
    id serial primary key,
    username text not null unique,
    password text not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

create table if not exists posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now(),
  users_id int not null references users(id)
);
