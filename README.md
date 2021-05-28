# Desafio backend Agriness

## Requirements
  - OpenJDK 11
  - Docker
  - Docker-composer (Desenvolvimento)
  - Gradlew

## Swagger/OpenApi


### Codigo-fonte
```
src/main/java/br/com/ftd/lti/ltiapi/v1
├── Api
│   └── v1
├── BooksApplication.java
├── books
│   ├── dto
│   └── entity
|   └── service
├── users
│   ├── dto
│   └── entity
|   └── service
```

* `API`: Arquivos relacionados a endpoints
* `configuration`: Arquivos e pacotes relacionados a configurações da aplicação, como beans que precisam ser iniciados.

Dentro da estrutura do projeto, as resposabilidades serão isoladas por domínio, que podem ser chamadados de app, cada app terá uma estrutura para administrar os objetos dentro desse domínio. Por exemplo, a pasta books contém arquivo que é necessário para gerencias as regras relacionadas a livros.
Dentro de cada app pode existir os seguintes arquivos:
```
│   ├── dto
│   └── entity
|   └── service
```
* `dto`: Classes responsáveis pela camada de apresentação/transmissão dos dados.
* `entity`: Mapeamento das entidades do banco de dados
* `service`: Classes que implementam as regras de negocio

## Development

### Local
Rodando a aplicação localmente:
Suba o banco local:
```
$: docker-compose up -d
```
Ao final, para subir a aplicação:
```
$: make run
```

Para verificar o status da aplicação utilize o seguinte endpoint:

```
http://localhost:8080/actuator/health
```

### Build
Para fazer Build do Projeto
```
$: make build-gradle
```

### Tests
Para executar os testes:

```
$: make tests
```
