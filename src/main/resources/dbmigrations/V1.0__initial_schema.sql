-- SEQUENCE
CREATE SEQUENCE droidcon.id_seq START 1;

CREATE TABLE droidcon.todo
(
    id bigint NOT NULL DEFAULT nextval('id_seq'::regclass),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    inserted_at timestamp without time zone NOT NULL,
    CONSTRAINT cron_type_pkey PRIMARY KEY (id)
);