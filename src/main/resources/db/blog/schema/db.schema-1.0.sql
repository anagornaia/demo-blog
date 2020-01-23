--liquibase formatted sql

--changeset anagornaia:1 comment: create LC_BLOG schema. Only for local dev environment
DROP SCHEMA IF EXISTS LC_BLOG CASCADE;

CREATE SCHEMA LC_BLOG
    AUTHORIZATION postgres;

