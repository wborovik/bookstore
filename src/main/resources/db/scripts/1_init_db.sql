create sequence if not exists hibernate_sequence start 1 increment 1;

create table if not exists author
(
    id          bigint  not null primary key,
    first_name  varchar not null,
    middle_name varchar,
    last_name   varchar not null,
    birth_date  date,
    created     timestamp(6) not null,
    changed     timestamp(6),
    version     integer
);

create table if not exists genre
(
    id          bigint  not null primary key,
    description varchar not null,
    created     timestamp(6),
    changed     timestamp(6),
    version     integer
);

create table if not exists book
(
    id                bigint  not null primary key,
    title             varchar,
    isbn              varchar not null,
    genre_id          bigint,
    author_id         bigint,
    price             numeric not null,
    currency          varchar not null,
    realization_count integer,
    created           timestamp(6) not null,
    changed           timestamp(6),
    version           integer
);

alter table if exists book add constraint book_genre_fk foreign key (genre_id) references genre;
alter table if exists book add constraint book_author_fk foreign key (author_id) references author;

-- create table if not exists author_book (
--     author_id bigint not null,
--     book_id   bigint not null
-- );
--
-- alter table if exists author_book add constraint author_book_fk foreign key (author_id) references author;
-- alter table if exists author_book add constraint book_author_fk foreign key (book_id) references book;

create table if not exists user_role
(
    id          bigint  not null primary key,
    role_name   varchar not null,
    description varchar not null,
    created     timestamp(6) not null,
    changed     timestamp(6),
    version     integer
);

create table if not exists payment_transaction
(
    id         bigint  not null primary key,
    book_id    bigint not null,
    account_id bigint not null,
    price      numeric not null,
    created    timestamp(6) not null,
    changed    timestamp(6),
    version    integer
);

create table if not exists user_account
(
    id          bigint  not null primary key,
    first_name  varchar not null,
    middle_name varchar,
    last_name   varchar not null,
    birth_date  date,
    login       varchar not null,
    password    varchar not null,
    is_active   boolean not null,
    created     timestamp(6) not null,
    changed     timestamp(6),
    version     integer
);

alter table if exists payment_transaction add constraint transaction_book_fk foreign key (book_id) references book;
alter table if exists payment_transaction add constraint transaction_user_fk foreign key (account_id) references user_account;

create table if not exists user_account_user_role
(
    account_id bigint not null,
    role_id bigint not null
);

alter table if exists user_account_user_role add constraint account_role_fk foreign key (account_id) references user_account;
alter table if exists user_account_user_role add constraint role_account_fk foreign key (role_id) references user_role;

create table if not exists user_account_purchased_book
(
    account_id bigint not null,
    book_id bigint not null
);

alter table if exists user_account_purchased_book add constraint account_book_fk foreign key (account_id) references user_account;
alter table if exists user_account_purchased_book add constraint book_account_fk foreign key (book_id) references book;