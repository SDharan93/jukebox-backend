-- This file creates the necessary tables to use the Security User Library.
-- This file will be run during Spring's initialization process can run all
CREATE TABLE if not exists users (
    user_id serial PRIMARY KEY,
    email VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL,
    enabled BOOL NOT NULL
);