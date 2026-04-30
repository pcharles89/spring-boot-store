alter table users
    add constraint uk_users_email UNIQUE (email);