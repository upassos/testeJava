-- Database: APIData

-- DROP DATABASE "APIData";

CREATE DATABASE "APIData"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
-- Type: enderecoCompleto

-- DROP TYPE "testeClaro"."enderecoCompleto";

-- Type: enderecoCompleto

-- DROP TYPE "testeClaro"."enderecoCompleto";

CREATE TYPE "testeClaro"."enderecoCompleto" AS
(
	ender "char"[],
	bairro "char"[],
	numero integer,
	complemento "char"[]
);

ALTER TYPE "testeClaro"."enderecoCompleto"
    OWNER TO postgres;
	
-- Table: testeClaro.Contatos

-- DROP TABLE "testeClaro"."Contatos";

CREATE TABLE IF NOT EXISTS "testeClaro"."Contatos"
(
    "Email" "char"[] NOT NULL,
    "Nome" "char"[] NOT NULL,
    "Telefone" "char"[] NOT NULL,
    "CEP" integer NOT NULL,
    "Endereco" "testeClaro"."enderecoCompleto",
    "Cidade" "char"[],
    "UF" "char"[],
    CONSTRAINT "Contatos_pkey" PRIMARY KEY ("Email")
)

TABLESPACE pg_default;

ALTER TABLE "testeClaro"."Contatos"
    OWNER to postgres;
