## Como Utilizar
PASSO A PASSO PARA ACESSO E EXECUÇÃO DO PROJETO NO WINDOWS (COM GIT E VS CODE)

## 1. Instalar o VS Code
O VS Code será usado para editar e visualizar o projeto.

Acesse: https://code.visualstudio.com/

* Clique em “Download for Windows” e instale normalmente.
* Após a instalação, recomendo instalar as extensões:
* Java Extension Pack
* Spring Boot Extension Pack
* PostgreSQL
* Maven for Java
* GitLens (opcional)

 ## 2. Clonar o Repositório com Git
É necessário ter o Git instalado. Se não tiver, baixe em: https://git-scm.com/

Comando:
bash
Copiar
Editar
git clone https://github.com/usuario/nome-do-repositorio.git
Substitua o link pelo do seu projeto.

## 3. Abrir o Projeto no VS Code
bash
Copiar
Editar
cd nome-do-repositorio
code .
O comando code . abre o VS Code na pasta atual (funciona se você selecionou "Add to PATH" na instalação do VS Code).

##  4. Instalar o Java JDK 17
Baixe de: AdoptOpenJDK

Instale com a opção “add to PATH” marcada.

 Verificar instalação:
bash
Copiar
Editar
java -version

## 5. Instalar o PostgreSQL
Baixe de: https://www.postgresql.org/download/windows/

Instale com o usuário padrão postgres e senha root (ou configure outro).

## 6. Criar o Banco de Dados
No pgAdmin ou terminal PostgreSQL, execute:

sql
Copiar
Editar
CREATE DATABASE asilo;
CREATE USER postgres WITH PASSWORD 'root';
GRANT ALL PRIVILEGES ON DATABASE asilo TO postgres;

## 7. Configurar o application.properties
No VS Code, abra:

plaintext
Copiar
Editar
src/main/resources/application.properties
E adicione:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/asilo
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver

## 8. Instalar o Maven
Baixe: https://maven.apache.org/download.cgi

Verificar instalação:
bash
Copiar
Editar
mvn -v
## 9. Compilar o Projeto
No terminal, dentro do diretório do projeto:

bash
Copiar
Editar
mvn clean install
## 10. Executar o Projeto
a) Rodar diretamente:
bash
Copiar
Editar
mvn spring-boot:run
b) Rodar o .jar gerado:
bash
Copiar
Editar
java -jar target/nome-do-seu-projeto.jar

## 11. Acessar a Aplicação
Abra no navegador:

arduino
Copiar
Editar
http://localhost:8080
Ou use o Postman para testar os endpoints.

 ## 12. Verificar as Tabelas no Banco
No terminal do PostgreSQL:

sql
Copiar
Editar
\dt
