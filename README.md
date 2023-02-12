
# Tinnova Veículos API
Este projeto foi criado com o objetivo de realizar uma avaliação técnica para a empresa Tinnova. É uma Aplicação em forma de api feita em java com framework Spring Boot.

# Documentação
A documentação esta disponivel neste [link](https://documenter.getpostman.com/view/9169158/2s935uGLc8)

# Versões
Java - 17
Spring boot - 3.0.2

# Servidor de desenvolvimento
Execute a aplicação por sua IDE de preferencia, após executar a aplicação ficara disponivel no endereço http://localhost:4200/.

O projeto esta configurado com [Flyway](https://flywaydb.org/documentation/) e gera a tabela e os dados iniciais no banco, então assim que iniciar o spring as tabelas são criadas automaticamente.

Para executar os teste basta executar o comanda `mvn test` ou executar por sua IDE de preferencia.

# Compilação
Execute o comando `mvn install` para compilar o projeto. Os artefatos da compilação serão armazenados no diretório `target`.
