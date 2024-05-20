# Microsserviço de Livros

Este projeto contém APIs e foi escrito em **Java, Java Spring, H2 as the database.**

## Table of Contents

- [Summary](#summary)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)

## Summary


## Installation

1. Efetue o clone do repositório

```bash
git clone https://github.com/marcelybigsantello/MicrosservicoJavaSpring.git
```

2. Instalar as dependências com o Maven

3. Rodar o Microsserviço

## Usage

1. Execute a aplicação com o Maven
2. A API estará acessível no endereço http://localhost:8080

## API Endpoints
A API oferece os seguintes endpoints:

**GET BOOK**
```markdown
GET /books - Recupera uma lista de todos os livros
```
```json
[
    {
        "id": 1,
        "title": "A Revolução dos Bichos",
        "description": "Clássico de George Orwell",
        "author": "George Orwell",
        "editor": "Companhia das Letras",
        "language": "PORTUGUESE",
        "numberOfPages": 150,
        "releaseDate": "2007-02-01",
        "quantityInSupply": 200
    },
    {
        "id": 2,
        "title": "1984",
        "description": "Clássico sobre política, sociedade e regimes totalitários",
        "author": "George Orwell",
        "editor": "Companhia das Letras",
        "language": "PORTUGUESE",
        "numberOfPages": 460,
        "releaseDate": "2009-02-10",
        "quantityInSupply": 20
    }
]
```

**POST BOOK**
```markdown
POST /books - Registra um novo livro na Aplicação
```
```json
{
	"title": "1984",
	"description": "", 
	"author": "George Orwell",
	"editor": "Companhia das Letras",
	"language": 0,
	"numberOfPages": 460,
	"releaseDate": "20/02/2009",
	"quantityInSupply": 10
}
```

**PUT BOOK**
```markdown
PUT /books/${id} - Atualiza as informações de um livro cadastrado
```

```json
{
	"title": "A Revolução dos Bichos",
	"description":"A revolução dos bichos a ser amplamente usada pelo Ocidente nas décadas seguintes como arma ideológica contra o comunismo. ", 
	"author": "George Orwell",
	"editor": "Companhia das Letras",
	"language": 0,
	"numberOfPages": 152,
	"releaseDate": "01/01/2007",
	"quantityInSupply": 15
}
```

**POST ORDER**
```markdown
POST /books/{bookId}/registerOrder - Registra um novo pedido de livro se houver no estoque
```

```json
{
  "participantEmail": "teste@gmail.com"
}
```

**GET ORDERS**
```markdown
GET /books/orders - Recupera uma lista de todos os pedidos de livros
```
```json
[
    {
        "id": 1,
        "book": {
            "id": 1,
            "title": "A Revolução dos Bichos",
            "description": "Clássico de George Orwell",
            "author": "George Orwell",
            "editor": "Companhia das Letras",
            "language": "PORTUGUESE",
            "numberOfPages": 150,
            "releaseDate": "2007-02-01",
            "quantityInSupply": 200
        },
        "buyerEmail": "teste@gmail.com"
    }
]
```


## Database
O projeto utiliza [H2 Database](https://www.h2database.com/html/tutorial.html) como banco de dados relacional.

