create table tags
(
    id   INT auto_increment
        primary key,
    name VARCHAR(255) not null UNIQUE
);

create table user_tags
(
    user_id BIGINT not null,
    tag_id  INT    not null,
    constraint user_tags_pk
        primary key (user_id, tag_id),
    constraint user_tags_tags__fk
        foreign key (tag_id) references tags (id) on delete cascade,
    constraint user_tags_users_id_fk
        foreign key (user_id) references users (id)
            on delete cascade
);