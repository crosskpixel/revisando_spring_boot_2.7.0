CREATE SCHEMA IF NOT EXISTS audit;
CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence;
CREATE TABLE IF NOT EXISTS audit.revinfo(
    rev int4 PRIMARY KEY,
    revtstmp BIGINT
);

CREATE TABLE IF NOT EXISTS public."usuario" (
  "id" serial NOT NULL,
  "email" varchar(255) NOT NULL,
  "password" varchar(50) NOT NULL,
  "primeiro_login" boolean  DEFAULT FALSE,
  "ativo" boolean NOT NULL DEFAULT FALSE,
  "created_at" timestamptz NOT NULL,
  "created_by" bigint NOT NULL,
  "updated_at" timestamptz NULL,
  "updated_by" bigint NULL,

  CONSTRAINT PKEY_USUARIO           PRIMARY KEY (id),
  CONSTRAINT UNQ_USUARIO            UNIQUE ("email")
);


