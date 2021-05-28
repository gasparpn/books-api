## Relatório do desafio

### Objetivo

O objetivo desse documento é descrever o que pensei durante o processo de desenvolvimento e o motivo de algumas decisões


### Ferramentas

Decidi usar Java com Spring Boot e gradle, pois são as ferramentas que utilizo atualmente. Poderia ser usado Django sem problemas.
Para o banco resolvi usar MySql.

### Dados iniciais

Ao executar a aplicação o banco será populado com algumas informações para teste.

### TDD

Decidi não usar TDD. Os testes serão escritos após as funcionalidades serem implementadas.


### Problemas

  
- Como não fiz nenhum sistema de login para identificar o usuário logado, decidi alterar o endpoint de reserva de livro
para receber o id do cliente que está solicitando a reserva.
  
- Não entendi bem o que deveria ser feita na apresentação da informação de multa dos livros.


### Campos para melhora no projeto

- Alterar o domínio de client para user e usar algum tipo de sistema de role. Assim, pode-se pensar em um
esquema de administrador e usuário cliente.
  
- Dividir as configs em profiles para facilitar deploy.
