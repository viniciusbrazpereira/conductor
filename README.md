# ITI - Desafio Técnico

Desenvolver uma API Rest que realiza validação de uma senha.

Input: Uma senha (string).
Output: Um boolean indicando se a senha é válida.

Consideração de uma senha válida, quando a mesma possuir as seguintes definições:

----------------------
* Nove ou mais caracteres
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial
* Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto


Arquitetura do Projeto
----------------------
* [Docker version 20.10.8, build 3967b7d] A pesquisa anual de desenvolvedores do Stack Overflow é sempre amplamente antecipada. O Docker foi classificado como o número 1 em "Plataforma mais amada", o número 2 "Plataforma mais procurada" e o número 3 "Plataforma em uso".
* [Swagger 2.0 ] O Swagger auxilia no desenvolvimento em todo o ciclo de vida da API, desde o design e a documentação até o teste e a implantação.
* [Java 1.8.0_211] - O Java 8 é um lançamento revolucionário da plataforma de desenvolvimento nº 1 do mundo. Inclui uma grande atualização para o modelo de programação Java e uma evolução coordenada da JVM, linguagem Java e bibliotecas.
* [Spring Boot 2.1.7.RELEASE]  - O Spring Boot facilita a criação de aplicativos autônomos baseados em Spring e com grau de produção que você pode "simplesmente executar".
* [Maven 3.8.3 wrapper] - O Apache Maven é uma ferramenta de gerenciamento e compreensão de projetos de software. Com base no conceito de um modelo de objeto de projeto (POM),
  O Maven pode gerenciar a construção, os relatórios e a documentação de um projeto a partir de uma informação central.

## Pontos de utilização da solução

- Como uma das principais formas de solução foi utilizado regex, utilizada para facilitar na validação de um texto.
- A implementação foi realizada através de utilização do BDD(Behavior Driven Development) que é um conjunto de práticas de engenharia de software projetado para construir e entregar mais rápidamente software e com qualidade.
- Utilizado Design patterns uma solução típicas para problemas comuns, como por exemplo Singleton(Que permite garantir que uma classe tem apenas uma instaância, tendo com validação um unico ponto de acesso).
- Spring boot a fim de garantir uma abordagem mais rapida na criação de API Web com padrão arquitetural REST.

Build do Projeto
----------------------
A premissa do build é que já tenha o ambiente com a lista de **Arquitetura do Projeto** já instalada;
OBS.: Os comandos podem sofrer uma pequena variação por conta do sistema operacional.

# Copiando o repositório
```shell
git clone https://github.com/viniciusbrazpereira/conductor.git
```

# Construindo aplicação utilizando maven
No diretório do projeto /conductor:
```shell
mvnw clean install
```

# Ou
```shell
sh mvnw clean install
```

# Variável de ambiente

No diretório do projeto /conductor:
```shell
export PROJETO_BACKEND=iti
export PROJETO_VERSAO=latest
```

# Criando e executando image docker
```shell
docker build -t "$PROJETO_BACKEND:$PROJETO_VERSAO" .
docker run -d -p 8080:8080 {IMAGE_ID} .
```
# Ou
```shell
docker build -t "iti:latest" .
docker run -d -p 8080:8080 {IMAGE_ID} .
```

OBS.: {IMAGE_ID} substitua pelo ID da imagem criada no docker.

# Execução da chamada de teste
```shell
curl http://localhost:8080/login?password=AbTp9!fok
```

# Executando aplicação utilizando maven

No diretório do projeto /conductor:
```shell
mvnw spring-boot:run
```



# Conductor - Desafio Técnico

Desenvolver os recursos em API Rest que realizam operações bancárias.

Arquitetura do Projeto
----------------------
* [Docker 19.03.2] A pesquisa anual de desenvolvedores do Stack Overflow é sempre amplamente antecipada. O Docker foi classificado como o número 1 em "Plataforma mais amada", o número 2 "Plataforma mais procurada" e o número 3 "Plataforma em uso".
* [Swagger 2.0 ] O Swagger auxilia no desenvolvimento em todo o ciclo de vida da API, desde o design e a documentação até o teste e a implantação.
* [Java 1.8.0_211] - O Java 8 é um lançamento revolucionário da plataforma de desenvolvimento nº 1 do mundo. Inclui uma grande atualização para o modelo de programação Java e uma evolução coordenada da JVM, linguagem Java e bibliotecas.
* [Spring Boot 2.1.7.RELEASE]  - O Spring Boot facilita a criação de aplicativos autônomos baseados em Spring e com grau de produção que você pode "simplesmente executar".
* [Maven 3.5.3] - O Apache Maven é uma ferramenta de gerenciamento e compreensão de projetos de software. Com base no conceito de um modelo de objeto de projeto (POM),
O Maven pode gerenciar a construção, os relatórios e a documentação de um projeto a partir de uma informação central. 
* [PostgreSQL 11] - O PostgreSQL é um poderoso banco de dados objeto-relacional de código aberto.


Build do Projeto
----------------------
Vou partir da premissa que já tenha o ambiente com a lista de **Arquitetura do Projeto** já instalada;

Primeiro, provisione o banco de dados de desenvolvimento local do PostgreSQL usando o Docker:

# Create container
```shell
docker run --name postgres \
  -e POSTGRES_USERNAME=postgres \
  -e POSTGRES_PASSWORD=12345678 \
  -e POSTGRES_DB=postgres \
  -p 5432:5432 \
  -v postgres-data:/var/lib/pgsql/10/data \
  -d postgres:11
```


# Execute Docker Postgres Script 
```shell
docker exec -it <container_name> bash
psql -U postgres
```

Depois execute o script **conductor_script.sql** dentro do terminal após executar o comando: **psql -U postgres**

# Exibir contêiner

```shell
docker container ls
```

# Registros de container logs
```shell
docker logs postgres  --follow
```

# Construindo utilizando  maven

No diretório do projeto /conductor:
```shell
mvn clean install
```

# Variável de ambiente

No diretório do projeto /conductor:
```shell
export PROJETO_BACKEND=conductor
export PROJETO_VERSAO=latest
```

# Criando e executando image docker 
```shell
docker build -t "$PROJETO_BACKEND:$PROJETO_VERSAO" .
docker run -d --env-file env.properties --env-file secret.properties -p 8080:8080 {IMAGE_ID} .
```

# Ou
```shell
docker run -it --network=host --env-file env.properties --env-file secret.properties -p 8080:8080 {IMAGE_ID}  .
```


# Documentação com Swagger IO 

Clique no link https://editor.swagger.io/ em **File -> import file** abra o arquivo openapi.yaml.




