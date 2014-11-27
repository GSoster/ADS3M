
CREATE TABLE CLIENTE(
idCliente int primary key,
nome varchar(255)
);

CREATE TABLE PRODUTO(
idProduto INT PRIMARY KEY,
nome varchar(255),
preco double
);

CREATE TABLE VENDA(
nota INT PRIMARY KEY,
data date
);

CREATE TABLE ITEMVENDA(
idItemVenda int primary key,
idnota int references venda(nota),
idProduto int references produto(idProduto),
quantidade int
);