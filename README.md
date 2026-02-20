# Sistema de Cadastro de Clientes (Java POO)
Sistema desenvolvido em Java utilizando os princípios de Programação Orientada a Objetos (POO) para realizar o cadastro, listagem, busca e remoção de clientes.
## Sobre o Projeto
### Este projeto tem como objetivo aplicar os conceitos fundamentais de POO em Java, como:

• Classes e Objetos

• Encapsulamento

• Construtores

• Métodos

• Coleções (ArrayList, etc.)


### O sistema permite:

• Cadastrar clientes

• Listar clientes cadastrados

• Buscar cliente por ID

• Remover cliente

• Atualizar dados

## Tecnologias Utilizadas

• Java (versão 8 ou superior)

• Programação Orientada a Objetos

• IDE IntelliJ

## Estrutura do Projeto

📦 CadastroClientes 

 ┣ 📂 src
 
 ┃ ┣ 📜 Model.java
 
 ┃ ┣ 📜 Repository.java
 
 ┃ ┣ 📜 Service.java
 
 ┃ ┣ 📜 Main.java
 
 ┣ 📜 .gitignore

 ┣ 📜 LICENSE
 
 ┗ 📜 README.md
 

## Descrição das Classes

• Model.java → Classe modelo que representa a entidade Cliente.

• Service.java → Classe responsável pelas regras de negócio.

• Repository.java → Classe responsável por armazenar os dados dos clientes.

• Main.java → Classe principal que executa o sistema.

## Como Executar o Projeto
### 1️) Clonar o repositório
git clone https://github.com/GuilhermeMAzevedo/CadastroClientes.git
### 2️) Abrir na IDE

Importe o projeto na sua IDE de preferência.

### 3️) Compilar e executar

Se estiver usando terminal:

javac Main.java

java Main

Exemplo de Uso

Ao executar o programa, o sistema exibirá um menu como:

1 - Cadastrar

2 - Listar

3 - Atualizar

4 - Deletar

5 - Buscar por ID

0 - Sair

## Conceitos de POO Aplicados

• Encapsulamento: atributos privados com getters e setters.

• Abstração: separação entre modelo e regra de negócio.

• Responsabilidade Única: cada classe possui uma função específica.

## Melhorias Futuras

• Persistência em arquivo ou banco de dados

• Interface gráfica

• Validação de dados

• Tratamento de exceções mais robusto

## Autor

Guilherme Moreira Azevedo

LinkedIn: www.linkedin.com/in/guilhermemoreiraazevedo/

Email: guilhermemoreiraazevedo7@gmail.com
