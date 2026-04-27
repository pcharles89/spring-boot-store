create table profiles
(
    id             BIGINT NOT NULL primary key,
    bio            TEXT,
    phone_number   VARCHAR(15),
    date_of_birth  DATE,
    loyalty_points INT UNSIGNED default 0 not null,
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);