# Desafio backend Agriness

## Requirements
  - OpenJDK 11
  - Docker
  - Docker-composer (Desenvolvimento)
  - Gradlew

## Swagger/OpenApi

## Development

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

Dentro da estrutura do projeto, tentamos isolar responsabilidades de dominio por pacotes que vamos chamar de apps, como por exemplo o contas: que será o pacote/app que é responsável por todas as funcionalidades de gerenciamento das contas com o canvas.
Dentro de cada app pode existir os seguintes arquivos:
```
│   ├── dto
│   └── entity
|   └── service
```
* `dto`: Classes responsáveis pela camada de apresentação/transmissão dos dados.
* `entity`: Mapeamento das entidades do banco de dados
* `service`: Classes que implementam as regras de negocio

### Local

### Build

### Tests
