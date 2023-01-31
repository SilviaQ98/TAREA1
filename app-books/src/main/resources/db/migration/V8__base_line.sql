create table if not exists public.books
(
    id        serial
    constraint id_books
    primary key,
    isbn      varchar(16),
    title     varchar(128),
    author_id integer
    constraint fk_id_author
    references public.authors
    constraint fk_author_id
    references public.authors,
    price     numeric(6, 2)
    );