-- Database: testeClaro

-- DROP DATABASE "testeClaro";

CREATE DATABASE "testeClaro"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
-- Table: public.Contatos

-- DROP TABLE public."Contatos";

CREATE TABLE IF NOT EXISTS public."Contatos"
(
    "Email" character varying(120) COLLATE pg_catalog."default" NOT NULL,
    "Nome" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "Telefone" character varying(11) COLLATE pg_catalog."default" NOT NULL,
    "CEP" character varying(9) COLLATE pg_catalog."default" NOT NULL,
    "Endereco" character varying(220) COLLATE pg_catalog."default",
    "Cidade" character varying(80) COLLATE pg_catalog."default",
    "UF" character varying(2) COLLATE pg_catalog."default",
    "DataCadastro" date,
    CONSTRAINT "Contatos_pkey" PRIMARY KEY ("Email")
)

TABLESPACE pg_default;

ALTER TABLE public."Contatos"
    OWNER to postgres;