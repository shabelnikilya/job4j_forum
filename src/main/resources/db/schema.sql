CREATE TABLE IF NOT EXISTS authorities (
  id serial primary key,
  authority VARCHAR(50) not null unique
);

create table if not exists users (
    id serial primary key,
    username VARCHAR(100) not null unique,
    password VARCHAR(150) not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

create table if not exists posts (
  id serial primary key,
  name varchar(200),
  description VARCHAR(500),
  created timestamp without time zone not null default now(),
  users_id int not null references users(id)
);
