# conductor - Desafio Técnico

Desenvolver os recursos em API Rest que realizam operações bancárias.

Arquitetura do Projeto
----------------------
* [DOcker 2.0 ]
* [Swagger 2.0 ] O Swagger auxilia no desenvolvimento em todo o ciclo de vida da API, desde o design e a documentação até o teste e a implantação.
* [Java 1.8.0_211] - O Java 8 é um lançamento revolucionário da plataforma de desenvolvimento nº 1 do mundo. Inclui uma grande atualização para o modelo de programação Java e uma evolução coordenada da JVM, linguagem Java e bibliotecas.
* [Spring Boot 2.1.7.RELEASE]  - O Spring Boot facilita a criação de aplicativos autônomos baseados em Spring e com grau de produção que você pode "simplesmente executar".
* [Maven 3.5.3] - O Apache Maven é uma ferramenta de gerenciamento e compreensão de projetos de software. Com base no conceito de um modelo de objeto de projeto (POM),
O Maven pode gerenciar a construção, os relatórios e a documentação de um projeto a partir de uma informação central. 
* [PostgreSQL 11] - O PostgreSQL é um poderoso banco de dados objeto-relacional de código aberto.


Build do Projeto
----------------------
Vou partir da premissa que já tenha o ambiente com a lista de tecnoligias já instalada;

O projeto pressupõe que você tenha o Docker instalada localmente.

Primeiro, provisione o banco de dados de desenvolvimento local do PostgreSQL usando o Docker:

# create container
docker run --name postgres \
  -e POSTGRES_USERNAME=postgres \
  -e POSTGRES_PASSWORD=12345678 \
  -e POSTGRES_DB=postgres \
  -p 5432:5432 \
  -d postgres

# view container
docker container ls

# trail container logs
docker logs postgres  --follow


/conductor
