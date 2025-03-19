# Configuração do PostgreSQL no Spring Boot

Este guia fornece um passo a passo para configurar o PostgreSQL no Spring Boot e resolver possíveis problemas com a criação automática de tabelas.

## 1. Instalar o PostgreSQL (Ubuntu)

```sh
sudo apt update
sudo apt install postgresql postgresql-contrib
```

## 2. Iniciar o serviço do PostgreSQL

```sh
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

## 3. Criar um banco de dados e usuário para a aplicação

```sh
sudo -u postgres psql
```

Dentro do PostgreSQL:

```sql
CREATE DATABASE todo_db;
CREATE USER jovmdG WITH PASSWORD '1269!';
ALTER ROLE jovmd SET client_encoding TO 'utf8';
ALTER ROLE jovmd SET default_transaction_isolation TO 'read committed';
ALTER ROLE jovmd SET timezone TO 'UTC';
GRANT ALL PRIVILEGES ON DATABASE todo_db TO jovmd;
\q
```

## 4. Configurar o `application.properties` no Spring Boot

No arquivo `src/main/resources/application.properties`, adicione:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=jovmd
spring.datasource.password=1991PG$#@
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 5. Verificar se a tabela foi criada

Acesse o PostgreSQL e selecione o banco de dados:

```sh
sudo -u postgres psql
\c todo_db
```

Para listar as tabelas:

```sql
\dt
```

Se a tabela `task` não existir, pode ser necessário revisar a classe de entidade no Spring Boot:

```java
import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private boolean completed;

    // Getters e Setters
}
```

Caso precise recriar as tabelas, use:

```sql
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
```

## 6. Rodar a aplicação

Execute o projeto:

```sh
mvn spring-boot:run
```

Agora o Spring Boot deve criar a tabela corretamente! 🚀
