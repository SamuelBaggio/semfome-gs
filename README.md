# Sem Fome - Global Solution

## Endpoints 

### /api/login 

**formato do POST** 👇

````
{
  "email": "samuel@fiap.com.br",
  "senha": "123456"
}
````

### /api/alimentos

**formato do POST** 👇

````
{
  "nome": "Cenoura",
  "descricao": "",
  "preco": 2,
  "empresa": {
    "id": 1
  }
}
````

**GET{id}** 👇

````
{
  "id": 2,
  "nome": "Maça",
  "descricao": null,
  "preco": 1,
  "empresa": {
    "id": 1,
    "cnpj": "04.577.864/0001-21",
    "razaoSocial": "Empresa A",
    "nomeFantasia": "A Vendas de Esquina",
    "senha": "1234",
    "tipo": 1,
    "cep": "02079009",
    "logradouro": "Rua do Seu Geraldo",
    "numero": "120",
    "complemento": null,
    "bairro": "Vila do Zé",
    "cidade": "São Paulo",
    "estado": "SP"
  }
````

### /api/empresas

**formato do POST** 👇

````
{
  "id": 25,
  "cnpj": "60.498.869/0001-30",
  "razaoSocial": "Empresa X",
  "nomeFantasia": "Empresa X",
  "senha": "123456",
  "tipo": 2,
  "cep": "02345622",
  "logradouro": "Rua Nove",
  "numero": "9",
  "complemento": "Casa",
  "bairro": "Bairro das Olivas",
  "cidade": "Cidade das Olivas",
  "estado": "SP"
}
````

**GET{id}** 👇

````
{
  "id": 25,
  "cnpj": "60.498.869/0001-30",
  "razaoSocial": "Empresa X",
  "nomeFantasia": "Empresa X",
  "senha": "123456",
  "tipo": 2,
  "cep": "02345622",
  "logradouro": "Rua Nove",
  "numero": "9",
  "complemento": "Casa",
  "bairro": "Bairro das Olivas",
  "cidade": "Cidade das Olivas",
  "estado": "SP"
}
````

