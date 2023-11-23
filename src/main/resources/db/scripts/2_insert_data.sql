-- Authors
insert into author (id, first_name, middle_name, last_name, birth_date, created, changed, version)
values (1000, 'Александр', 'Сергеевич', 'Пушкин', '1799-06-06', now(), null, 0);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed, version)
values (1001, 'Иван', 'Сергеевич', 'Тургенев', '1818-10-28', now(), null, 0);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed, version)
values (1002, 'Корней', 'Иванович', 'Чуковский', '1882-03-19', now(), null, 0);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed, version)
values (1003, 'Антон', 'Павлович', 'Чехов', '1860-01-17', now(), null, 0);

-- Genres
insert into genre (id, description, created, changed, version)
values (1004, 'Отечественная поэзия для детей', now(), null, 0);

insert into genre (id, description, created, changed, version)
values (1005, 'Сказки отечественных писателей', now(), null, 0);

insert into genre (id, description, created, changed, version)
values (1006, 'Произведения школьной программы', now(), null, 0);

insert into genre (id, description, created, changed, version)
values (1007, 'Философская художественная литература', now(), null, 0);

-- Books
insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1008, 'Сказки Пушкина', '978-5-91045-966-7', 1005, now(), null, 35.71, 'BYN', 0, 0, 1000);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1009, 'Капитанская дочка', '978-5-9287-3324-7', 1006, now(), null, 200.69, 'INR', 0, 2, 1000);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1010, 'Отцы и дети', '978-5-9268-2711-5', 1007, now(), null, 100.45, 'KZT', 0, 5, 1001);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1011, 'Сказки и стихи', '9785001928379', 1004, now(), null, 53.03, 'CAD', 0, 3, 1002);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1012, 'Железнодорожные рассказы', '978-5-94887-134-9', 1006, now(), null, 107.95, 'UAH', 0, 10, 1003);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1013, 'Палата № 6', '978-5-389-23268-6', 1007, now(), null, 22.48, 'JPY', 0, 0, 1003);

insert into book (id, title, isbn, genre_id, created, changed, price, currency, version, realization_count, author_id)
values (1014, 'Записки Охотника', '978-5-9268-2869-3', 1006, now(), null, 50, 'TRY', 0, 7, 1001);


-- UserAccounts
insert into user_account (id, first_name, middle_name, last_name, birth_date, login, password, is_active, created, changed, version)
values (1015, 'Сергей', 'Алексеевич', 'Иванов', '1990-05-12', 'admin', '$2y$10$/Xzw7FXSgy/GX7GbkiY0hun5WQDtjdWxIkUba0.fQCjh9q4GFxNOm',
        true, now(), null, 0);

insert into user_account (id, first_name, middle_name, last_name, birth_date, login, password, is_active, created, changed, version)
values (1016, 'Иван', 'Александрович', 'Сергеев', '1980-12-05', 'user', '$2y$10$TbnlU2bsaq85g7oCWKlfyOGgS4cslp3I6Ag7u2N6uD.yYaEoXSUiq',
        true, now(), null, 0);

insert into user_account (id, first_name, middle_name, last_name, birth_date, login, password, is_active, created, changed, version)
values (1017, 'Дмитрий', 'Михайлович', 'Ерофеев', '1985-10-07', 'creator', '$2y$10$PO35bxUDNnXJYzDLNX4GnOsAoe.wh/5nuysbm9kqQfkUj1ou24e9u',
        true, now(), null, 0);

insert into user_account (id, first_name, middle_name, last_name, birth_date, login, password, is_active, created, changed, version)
values (1018, 'Валерий', 'Петрович', 'Собакичев', '1992-04-21', 'updater', '$2y$10$p3tAAETYJy7sqWGzJ2EVN.7d7qkKEHWIu5Q4h1T/ZEWMsFx23d5b2',
        true, now(), null, 0);

-- UserRoles
insert into user_role (id, role_name, description, created, changed, version)
values (1019, 'ROLE_ADMIN', 'Администратор. Доступны все операции', now(), null, 0);

insert into user_role (id, role_name, description, created, changed, version)
values (1020, 'ROLE_USER', 'Обычный пользователь. Доступен только просмотр страниц', now(), null, 0);

insert into user_role (id, role_name, description, created, changed, version)
values (1021, 'ROLE_CREATOR', 'Создатель. Доступны операции создания новых сущностей.', now(), null, 0);

insert into user_role (id, role_name, description, created, changed, version)
values (1022, 'ROLE_UPDATER', 'Редактор. Доступны операции изменения существующих сущностей.', now(), null, 0);

-- User_Role
insert into user_account_user_role (account_id, role_id)
values (1015, 1019), (1016, 1020), (1017, 1021), (1018, 1022);