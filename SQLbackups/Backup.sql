CREATE TABLE Cliente(
	id_cliente SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR NOT NULL,
	cpf VARCHAR(14) UNIQUE NOT NULL
);

CREATE TABLE TipoRestaurante(
	id_tipoRestaurante SERIAL PRIMARY KEY NOT NULL,
	nomeTipo VARCHAR NOT NULL
);

CREATE TABLE Restaurante(
	id_restaurante SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR NOT NULL,
	tipo INTEGER NOT NULL,
	FOREIGN KEY(tipo) REFERENCES TipoRestaurante(id_tipoRestaurante)
);

CREATE TABLE Funcionario(
	id_funcionario SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR NOT NULL,
	restaurante_id INTEGER,
	FOREIGN KEY (restaurante_id) REFERENCES Restaurante(id_restaurante)
);

CREATE TABLE Cozinheiro(
	id_cozinheiro SERIAL PRIMARY KEY NOT NULL,
	id_funcionario INTEGER UNIQUE NOT NULL,
	FOREIGN KEY(id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Gerente(
	id_gerente SERIAL PRIMARY KEY NOT NULL,
	id_funcionario INTEGER UNIQUE NOT NULL,
	FOREIGN KEY(id_funcionario) REFERENCES Funcionario(id_funcionario)
);

CREATE TABLE Cardapio(
	id_cardapio SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR
);

CREATE TABLE Produto(
	id_produto SERIAL PRIMARY KEY NOT NULL,
	nome VARCHAR NOT NULL,
	preco FLOAT NOT NULL
);

CREATE TABLE ProdutoCardapio(
	id_produtoCardapio SERIAL PRIMARY KEY NOT NULL,
	id_produto INTEGER NOT NULL,
	id_cardapio INTEGER NOT NULL,
	FOREIGN KEY(id_produto) REFERENCES Produto(id_produto),
	FOREIGN KEY(id_cardapio) REFERENCES Cardapio(id_cardapio)
);