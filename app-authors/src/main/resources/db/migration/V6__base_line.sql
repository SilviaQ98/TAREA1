create table if not exists public.authors
(
    id         integer default nextval('author_id_author_seq'::regclass) not null
    constraint id_author
    primary key,
    first_name varchar(16)                                               not null,
    last_name  varchar(128)
    );