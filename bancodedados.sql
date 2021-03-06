CREATE SCHEMA DEMO;
SET SCHEMA DEMO;

CREATE TABLE PROBLEMA(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME CHAR(100),
CLASSE CHAR(100),
PRIMARY KEY (ID)
);

CREATE TABLE SOLUCAO(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME CHAR(100),
CLASSE CHAR(100)
);

/* popula o banco */
INSERT INTO PROBLEMA (NOME) VALUES 
 ('Não liga') 
,('HD com defeito')
,('Falha ao iniciar')
,('Monitor piscando')
,('Travando');

INSERT INTO SOLUCAO(NOME) VALUES 
 ('Remover mal contato')
,('Substituir o HD')
,('Reparar monitor')
,('Substituir o cabo');