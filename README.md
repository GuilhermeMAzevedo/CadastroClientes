# Sistema de Cadastro de Clientes em Java
Sistema desenvolvido em Java utilizando os princípios de Programação Orientada a Objetos (POO) para realizar o cadastro, listagem, busca e remoção de clientes.
## Sobre o Projeto
### Objetivo
• Este projeto tem como objetivo aplicar os conceitos fundamentais de POO em Java, com foco em demonstrar a construção de um sistema modular e robusto, utilizando apenas Java puro e interface via console.
### Funcionalidades
• O sistema permite:

• Cadastrar novos clientes com validação de dados.

• Listar todos os clientes cadastrados.

• Buscar um cliente específico por ID.

• Remover um cliente existente.

• Atualizar os dados de um cliente.
### Tecnologias Utilizadas
• Java (versão 8 ou superior)

• Programação Orientada a Objetos

• Expressões Regulares (Regex)

• IDE IntelliJ
## Estrutura do Projeto

📦 CadastroClientes 

 ┣ 📂 src

 ┃ ┣ 📜 Main.java
 
 ┃ ┣ 📜 Customer.java
 
 ┃ ┣ 📜 Repository.java
 
 ┃ ┣ 📜 Service.java

 ┃ ┣ 📜 Validator.java 

 ┣ 📜 .gitignore

 ┣ 📜 LICENSE
 
 ┗ 📜 README.md
 

## Descrição das Classes

• Customer.java → Classe modelo que representa a entidade Cliente, com atributos encapsulados e validação de ID imutável.

• Repository.java → Implementa o padrão Repository, responsável por gerenciar a coleção de clientes em memória (ArrayList), garantindo a imutabilidade na recuperação de listas.

• Service.java → Contém as regras de negócio e validações complexas, orquestrando as operações CRUD e utilizando injeção de dependência do Repository.

• Validator.java → Classe utilitária estática para validação de entrada de dados (nome, email, telefone, ID) utilizando expressões regulares e constantes de limite.

• Main.java → Classe principal que fornece a interface de usuário via console, gerencia o fluxo do programa e trata as interações do usuário.

## Como Executar o Projeto
### 1️) Clonar o repositório
Abra o terminal local, copie e cole o comando abaixo:

git clone https://github.com/GuilhermeMAzevedo/CadastroClientes.git
### 2️) Abrir na IDE

Importe o projeto na sua IDE de preferência (Ex: IntelliJ IDEA).

### 3️) Compilar e executar

Navegue até a pasta raiz do projeto no terminal.
Compile o código-fonte:
javac src/*.java
Execute a aplicação:
java src/Main.java
Alternativamente, execute diretamente pela sua IDE.

## Exemplo de Uso

Ao executar o programa, o sistema exibirá um menu como:

### ==========MENU==========

### 1 - Cadastrar Cliente

### 2 - Listar Clientes

### 3 - Atualizar Dados de um Cliente

### 4 - Deletar Cliente

### 5 - Buscar Cliente por ID

### 0 - Sair

### ========================

### Digite a sua escolha:

Siga as instruções para interagir com o sistema, cadastrando, listando, atualizando, deletando ou buscando clientes.
## Conceitos de POO Aplicados

• Encapsulamento: Atributos das classes são privados e acessados/modificados por métodos públicos (getters e setters), protegendo o estado interno dos objetos. O id do Customer é final, garantindo a imutabilidade.

• Abstração: Separação clara das responsabilidades entre as camadas (Model, Repository, Service), onde cada classe expõe apenas o essencial para sua função.

• Responsabilidade Única (SRP): Cada classe possui uma única responsabilidade bem definida: Customer (dados), Repository (persistência em memória), Service (regras de negócio), Validator (validação de dados), Main (interface de usuário).

• Injeção de Dependência: O Service recebe uma instância de Repository via construtor, promovendo baixo acoplamento e facilitando testes. 

• Tratamento de Exceções: Uso de try-catch para gerenciar erros de entrada do usuário e validações, fornecendo feedback claro e mantendo a robustez do sistema.

• Padrões de Projetos: Implementação dos padrões Repository e Service para organizar a lógica de acesso a dados e regras de negócio. Validator como Utility Class.
## Melhorias Futuras

• Persistência de Dados: Implementar armazenamento em arquivo (CSV, JSON) ou banco de dados (SQL, NoSQL) para que os dados não sejam perdidos ao encerrar o programa.

• Interface Gráfica (GUI): Desenvolver uma interface de usuário mais amigável utilizando frameworks como Swing, JavaFX ou Spring Boot com web.

• Estruturas de Dados Avançadas: Explorar a aplicação de estruturas de dados como Listas Encadeadas ou Filas de Prioridade para otimizar operações específicas.

•Testes Unitários: Adicionar testes automatizados para garantir a correção e a robustez das funcionalidades do sistema.
## Autor

Guilherme Moreira Azevedo

LinkedIn: www.linkedin.com/in/guilhermemoreiraazevedo/

Email: guilhermemoreiraazevedo7@gmail.com

GitHub: https://github.com/GuilhermeMAzevedo
