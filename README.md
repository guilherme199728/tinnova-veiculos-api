# Tinnova Veículos API
Este projeto foi criado com o objetivo de realizar uma avaliação técnica para a empresa Tinnova. É uma Aplicação em forma de api feita em java com framework Spring Boot.
# Documentação
A documentação com os endpoints está disponível neste [link](https://documenter.getpostman.com/view/9169158/2s935uGLc8).
# Versões
Java - 17  
Spring boot - 3.0.2
PostgresSQL - 15
# Servidor de desenvolvimento
Crie um schema no postgres com o nome `tinnova-vehicles-bd` a porta do banco configurarda é a padrao 5432, caso deseje alterar os dados de acesso ao banco basta ir ate o `application.properties`.O projeto está configurado com [Flyway](https://flywaydb.org/documentation/) e gera automaticamente as tabelas e os dados iniciais.
Execute a aplicação através da sua IDE preferida, a aplicação ficará disponível no endereço [http://localhost:4200/](http://localhost:4200/).
# Ambiente de testes
Quando executado os teste uma instancia do spring é subida com o banco de dados H2, onde é possivel inserir dados no banco em memoria facilitando o desenvolvimento dos testes.
Para executar os teste basta executar o comanda `mvn test` ou executar por sua IDE de preferencia.
# Exercícios de logica
Para executar os exercicios de logica basta executar a classe `MainExercises.java` ela executara os 4 exercicios.
# Compilação
Execute o comando `mvn install` para compilar o projeto. Os artefatos da compilação serão armazenados na pasta `target`.
