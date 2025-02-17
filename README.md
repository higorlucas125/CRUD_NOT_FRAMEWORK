# CRUD_NOT_FRAMEWORK

Using jdbc without using framework

## Desafio criar um ORM, fazendo o basico. CRUD

* C : create
* R : reaload
* U : update
* D : delete

Esse desafio tem por objetivo, aprender como realmente o JPA funciona e incrementar algumas annotations igual ao do
Spring boot.

Isso é somente para fins de melhorar o conhecimento na linguagem java, e aprofundar nos uso mais hold skull da
programação.

NÃO É RECOMENDADO UTILIZAR ESSE TIPO DE ORM QUE ESTOU FAZENDO, É SOMENTE PARA VALIDAR ALGUNS CONHECIMENTO E MELHORIAS
NOS CODIGOS.

## Objetivo do projeto

Objetivo é criar um ORM, fazendo integração com o nosso banco de dados predileto, pode ser qualquer um esse ORM está
preparado, porém, tem que configurar o resources/config.properties

Criei duas classes User e Product, eles possuem uma ligação de um para muitos, depois num futuro não tão longe vou
implementar one to one e many to many.

Vou descrever cada passo que faço e o motivo de utilizar cada classe e quais padrões vou utilizar.

## Divisão de arquitetura

Não tem uma arquitetura de fato, porém vou utilizar o MVC( model view controller ), quero mais pra frente colocar as
chamadas via HTTP, utilizando REST-FULL, com os 3 niveis do REST e descrevendo cada ponto

(Modelo de maturidade de Richardson)
0. POX
1. Resource - Oriented API
2. Verbos HTTP
3. HATEOAS
