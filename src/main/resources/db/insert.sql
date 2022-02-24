insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$ntYJ8xSMwDKsA/EiRZsbdeOmR9nNRuQZI7dvL854xcKxQDl4YwYpC',
(select id from authorities where authority = 'ROLE_ADMIN'));

insert into posts (name, description, users_id) values ('О чем этот форум?', 'Форум на разнообразные темы!', 1);
insert into posts (name, description, users_id) values ('Правила форума.', 'Одно из основных правил - отсутствие рекламы!', 1);