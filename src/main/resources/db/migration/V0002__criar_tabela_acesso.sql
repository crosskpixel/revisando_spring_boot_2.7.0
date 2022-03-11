create sequence sq_acesso;
CREATE TABLE IF NOT EXISTS public."acesso"
(
    "id" serial NOT NULL,
    "ip" varchar(15)  NOT NULL,
    "access_token" text NOT NULL,
    "refresh_token" text NOT NULL,
    "usuario_id"     int4         NOT NULL,
    CONSTRAINT PKEY_ACESSO PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES public."usuario" (id),
    CONSTRAINT UNQ_ACCESS_TOKEN UNIQUE ("access_token"),
    CONSTRAINT UNQ_REFRESH_TOKEN UNIQUE ("refresh_token")
);