CREATE DATABASE "testeClaro"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
CREATE SCHEMA "claroapi"
    AUTHORIZATION postgres;
	
CREATE TABLE IF NOT EXISTS "claroapi"."contatos"
(
    "email" character varying(120) COLLATE pg_catalog."default" NOT NULL,
    "nome" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "telefone" character varying(11) COLLATE pg_catalog."default" NOT NULL,
    "cep" character varying(9) COLLATE pg_catalog."default" NOT NULL,
    "endereco" character varying(220) COLLATE pg_catalog."default",
    "cidade" character varying(80) COLLATE pg_catalog."default",
    "uf" character varying(2) COLLATE pg_catalog."default",
    "data_cadastro" date,
    CONSTRAINT "Contatos_pkey" PRIMARY KEY ("email")
)

TABLESPACE pg_default;

ALTER TABLE "claroapi"."contatos"
    OWNER to postgres;