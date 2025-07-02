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
git clone https://github.com/ICEI-PUC-Minas-PCO-SI/2025-1-p5-tias-2025-1-tias-t2-grupo-02.git

## 3. Abrir o Projeto no VS Code
bash
Copiar
Editar
cd nome-do-repositorio
code .
O comando code . abre o VS Code na pasta atual (funciona se você selecionou "Add to PATH" na instalação do VS Code).

# Passo a Passo para Rodar a Aplicação no Windows (Sem Docker e Sem Node.js)

## 1. Extrair o Código Fonte
- O código fonte foi extraído corretamente, e a pasta do projeto contém os arquivos necessários.

## 2. Instalar o Java Development Kit (JDK)
- Baixe e instale o JDK 17. Certifique-se de adicionar o JDK ao PATH do sistema.
- Verifique a instalação com o comando: `java -version`.

## 3. Instalar o Maven
- Baixe e instale o Apache Maven. Extraia o arquivo para um diretório e adicione ao PATH do sistema.
- Verifique a instalação com o comando: `mvn -version`.

## 4. Instalar o PostgreSQL
- Baixe e instale o PostgreSQL. Durante a instalação, configure o banco de dados com as credenciais:
  - **Database Name**: asilo
  - **User**: postgres
  - **Password**: root
  - **Port**: 5432.
- Após a instalação, inicie o PostgreSQL e teste a conexão com o comando: `psql -h localhost -U postgres -d asilo`.

## 5. Configurar o Backend
- Acesse a pasta do backend no código.
- Configure o arquivo `application.properties` com as credenciais do banco.
- Compile e rode o backend com os comandos:
  ```bash
  mvn clean install
  mvn spring-boot:run
  ```
- O servidor backend estará disponível em `http://localhost:8080`.

## 6. Configurar o Frontend
- Navegue até a pasta `src/front` e encontre o arquivo `listagem_pacientes.html`.
- Dê um duplo clique no arquivo HTML para abri-lo diretamente no navegador.

## 7. Acessar a Página de Listagem de Pacientes
- Após configurar o backend, o frontend será exibido diretamente no navegador.

