create table if not exists posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now()
);

insert into posts (name, description) values ('О чем этот форум?', 'Форум на разнообразные темы!');
insert into posts (name, description) values ('Правила форума.', 'Одно из основных правил - отсутствие рекламы!');