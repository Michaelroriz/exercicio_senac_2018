CREATE DATABASE PRODUTOBD;

CREATE TABLE PRODUTOBD.PRODUTO (
  ID           BIGINT        NOT NULL AUTO_INCREMENT,
  NOME         VARCHAR(100)  NOT NULL,
  DESCRICAO    VARCHAR(1000) NULL,
  PRECO_COMPRA DECIMAL(9,2)  NOT NULL,
  PRECO_VENDA  DECIMAL(9,2)  NOT NULL,
  QUANTIDADE   INT           NOT NULL DEFAULT 0,
  DT_CADASTRO  TIMESTAMP     NOT NULL,
  CONSTRAINT PK_PRODUTO PRIMARY KEY (ID)
);

CREATE TABLE PRODUTOBD.CATEGORIA (
  ID   INT          NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID),
  CONSTRAINT UC_NOME UNIQUE (NOME)
);

CREATE TABLE PRODUTOBD.PRODUTO_CATEGORIA (
    ID_PRODUTO   BIGINT NOT NULL,
    ID_CATEGORIA INT    NOT NULL,
    CONSTRAINT FK_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTOBD.PRODUTO(ID),
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (ID_CATEGORIA) REFERENCES PRODUTOBD.CATEGORIA(ID)
);

INSERT INTO PRODUTOBD.CATEGORIA(NOME) VALUES ("Categoria Um");
INSERT INTO PRODUTOBD.CATEGORIA(NOME) VALUES ("Categoria Dois");
INSERT INTO PRODUTOBD.CATEGORIA(NOME) VALUES ("Categoria Três");
INSERT INTO PRODUTOBD.CATEGORIA(NOME) VALUES ("Categoria Quatro");
INSERT INTO PRODUTOBD.CATEGORIA(NOME) VALUES ("Categoria Cinco");