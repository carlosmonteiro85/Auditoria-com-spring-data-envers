## Projeto
* Esse protótipo tem como finalidade de realizar um modelo de auditoria.

## Frameworks , linguagem e ferramentas

* O projeto foi desenvolvido com a linguagem Java na versão 11.
* Foi utilizado a framework "Spring boot" que facilita o desenvolvimento com java, pois possui todas as bibliotecas necessárias para desenvolver a aplicação de forma rápida e eficaz, visando a rapidez  nas configuração do projeto e ganhar tempo para o foco no desenvolvimento. 
* A segurança do projeto é feito pelo Spring Security. 
* Para a comparação de objetos, o projeto utiliza  o a interface Diffable<T> da biblioteca commons-lang3 de org.apache.commons.
* Para os testes unitarios foi utilizado o JUNIT 5.
* Para a auditoria o projeto utiliza o Spring data Envers da biblioteca spring-data-envers .

## Executando o projeto

### Execultar o projeto clonado pelo git

* Para  executar o projeto, após ser clonado o repositótio, é necessário executar o arquivo "AuditApplication.java", como "Java application".
* Ou executando o comando ./mvnw spring-boot:run na pasta raiz do projeto.

## Dependências utilizadas

### spring-boot-starter-data-jpa
* Por trazer a facilidade do projeto fazer o re-buid toda vez que é salvo algum arquivo fonte, desta forma não necessita finalizar o processo e recomeçá-lo.

### spring-boot-starter-web
* Biblioteca para realizar a comunicação com cliente via REST.

### h2database
* Banco de dados gerada em uma pasta chamada "data" na raiz do projeto.
* Para a carga inicial temos a classe de teste "CreateDataBD.java" que realiza uma carga com alguns dados que podem ser utilizados para fins de teste.

### projectlombok

### spring-boot-devtools
* biblioteca para realizar o auto reload no projeto

### spring-data-envers
* Biblioteca responsável pela auditoria do projeto.

### pring-boot-starter-security
* Dependência voltada para a segurança do projeto que utiliza.

### commons-lang3
* Dependência usada para realizar a comparação do estado antigo e novo do objeto, listando suas diferenças