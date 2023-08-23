DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE Usuario(
	id_usuario INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	nome VARCHAR NOT NULL,
	email VARCHAR(320) UNIQUE,
	senha VARCHAR(128)
);

CREATE TABLE Cliente(
	id_cliente INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	id_usuario INTEGER NOT NULL,
	cpf VARCHAR(14) UNIQUE NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE TipoRestaurante(
	id_tipoRestaurante INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	nomeTipo VARCHAR NOT NULL
);

CREATE TABLE Restaurante(
	id_restaurante INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	nome VARCHAR NOT NULL,
	tipo INTEGER NOT NULL,
	FOREIGN KEY(tipo) REFERENCES TipoRestaurante(id_tipoRestaurante)
);

CREATE TABLE Funcionario(
	id_funcionario INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	id_usuario INTEGER NOT NULL,
	restaurante_id INTEGER,
	FOREIGN KEY (restaurante_id) REFERENCES Restaurante(id_restaurante),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

CREATE TABLE Cozinheiro(
	id_cozinheiro INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	id_funcionario INTEGER UNIQUE NOT NULL,
	FOREIGN KEY(id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Gerente(
	id_gerente INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	id_funcionario INTEGER UNIQUE NOT NULL,
	FOREIGN KEY(id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Cardapio(
	id_cardapio INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	nome VARCHAR
);

CREATE TABLE Produto(
	id_produto INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	nome VARCHAR NOT NULL,
	preco FLOAT NOT NULL
);

CREATE TABLE ProdutoCardapio(
	id_produtoCardapio INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'),
	id_produto INTEGER NOT NULL,
	id_cardapio INTEGER NOT NULL,
	FOREIGN KEY(id_produto) REFERENCES Produto(id_produto),
	FOREIGN KEY(id_cardapio) REFERENCES Cardapio(id_cardapio)
);

CREATE TABLE Estado_br (
	id_estado INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'), 
	nome VARCHAR(128) NOT NULL, 
	sigla VARCHAR(2) NOT NULL
);

CREATE TABLE Cidade_br (
	cidade_id INTEGER PRIMARY KEY NOT NULL DEFAULT NEXTVAL('sequencia_de_um'), 
	nome VARCHAR(128),
    is_capital BOOL NOT NULL,
    estado_id INTEGER NOT NULL,
    FOREIGN KEY (estado_id) REFERENCES Estado_br(id_estado)
);

CREATE OR REPLACE FUNCTION cadastrarUsuario(
	email VARCHAR(256), 
	nome VARCHAR(256), 
	senha VARCHAR(256))
RETURNS void AS $$
BEGIN
	INSERT INTO usuario(email, nome, senha)
			VALUES(
				email, nome, senha
			);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION removerUsuario(email_addr VARCHAR(256))
RETURNS void AS $$
BEGIN
	DELETE FROM usuario
	WHERE usuario.email = email_addr;
END;
$$ LANGUAGE plpgsql;

CREATE SEQUENCE sequencia_de_um
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 100000
    NO CYCLE;