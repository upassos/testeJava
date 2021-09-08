# testeJava
Teste de conhecimento / desenvolvimento de API em JAVA com Spring MVC

# Dados para o application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/APIData

spring.datasource.username=postgres

spring.datasource.password=153227

#Arquivo POM.XML

O arquivo está configurado para ignorar os testes durante a compilação

#Considerações finais

O tipo Date no postGreSQL não armazena data e hora, eu teria que usar outro tipo, mas para manter o que foi pedido no desafio, usei o date.

Usei o verbo put no lugar do verbo patch pelo fato de eu permitir que todos os campos (exceto email e data_cadastro) sejam alterados.
