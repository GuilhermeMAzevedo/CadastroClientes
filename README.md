# Sistema de Cadastro de Clientes em Java


## 1. Introdução
Este projeto consiste em um sistema robusto de gerenciamento de clientes desenvolvido em Java, com foco primordial nos pilares da Programação Orientada a Objetos (POO) e na modularidade de código. A aplicação foi desenhada para oferecer uma experiência de console fluida, garantindo a integridade dos dados através de camadas rigorosas de validação e uma arquitetura que separa claramente as responsabilidades de negócio, armazenamento e interface.
## 2. Objetivos do Projeto
O desenvolvimento deste sistema visou consolidar conhecimentos avançados em engenharia de software, focando nos seguintes pontos:

1. Implementação de Estruturas de Dados Personalizadas para gestão eficiente de memória.

2. Aplicação de padrões de projeto para garantir a escalabilidade do sistema.

3. Criação de uma interface de linha de comando (CLI) resiliente a falhas de entrada do usuário.

4. Garantia de unicidade de registros e integridade de informações cadastrais.

## 3.Tecnologias Utilizadas
• Linguagem: Java JDK 17+

• Estrutura de Dados: LinkedList Customizada (Implementação Própria)

• Processamento de Texto: Expressões Regulares (Regex) para validações complexas

• Gerenciamento de Fluxo: Java Collections Framework (Iterator)

• Paradigma: Programação Orientada a Objetos (POO)

## 4. Estrutura do Projeto

    📦 CadastroClientes
     ┣ 📂 src
     ┃ ┗ 📂 com
     ┃   ┗ 📂 cadastroclientes
     ┃     ┣ 📂 datastructures
     ┃     ┃ ┗ 📜 LinkedList.java
     ┃     ┣ 📂 main
     ┃     ┃ ┗ 📜 Main.java
     ┃     ┣ 📂 model
     ┃     ┃ ┗ 📜 Customer.java
     ┃     ┣ 📂 repository
     ┃     ┃ ┗ 📜 Repository.java
     ┃     ┣ 📂 service
     ┃     ┃ ┗ 📜 Service.java
     ┃     ┗ 📂 util
     ┃       ┗ 📜 Validator.java
     ┣ 📜 .gitignore
     ┣ 📜 LICENSE
     ┗ 📜 README.md
 

## 5. Descrição das Classes

### 5.1. Customer.java

Classe de modelo (POJO) que representa a entidade Cliente. Possui os atributos id, name, email e phone. O campo id é definido como final, assegurando a imutabilidade da identidade do objeto após sua criação no sistema.

### 5.2. LinkedList.java

Uma implementação autoral de lista encadeada simples. Diferencia-se das coleções padrão do Java por ser otimizada para o contexto do projeto, incluindo suporte à interface Iterable, permitindo o uso de loops for-each e garantindo controle total sobre a manipulação dos nós.

### 5.3. Repository.java

Atua como a camada de persistência em memória. Gerencia a instância da LinkedList, isolando as operações de baixo nível (salvamento, busca e deleção) das regras de negócio da aplicação.

### 5.4. Service.java

Concentra a inteligência do sistema. É responsável pela geração automática de IDs, controle do fluxo de operações e aplicação de regras de negócio críticas, como a proibição de e-mails duplicados durante a criação ou atualização de registros.

### 5.5. Validator.java

Classe utilitária que utiliza Regex e constantes predefinidas para validar a integridade dos dados. Define limites de caracteres e formatos específicos para nomes, e-mails e telefones, impedindo a entrada de dados inconsistentes no sistema.

### 5.6. Main.java

Ponto de entrada da aplicação. Gerencia a interface CLI e utiliza blocos try-catch extensivos para tratar exceções, garantindo que erros de entrada não interrompam a execução do programa.

## 6. Conceitos de POO Aplicados

• Encapsulamento: Atributos privados com acesso controlado via métodos públicos.

• Abstração: Complexidade da estrutura de dados oculta por trás de interfaces simples.

• SRP (Single Responsibility Principle): Cada classe possui uma única razão para mudar.

• Injeção de Dependência: O Service recebe o Repository via construtor, facilitando testes e manutenção.

• Tratamento de Exceções: Uso estratégico de IllegalArgumentException para sinalizar violações de regras de negócio.

## 7. Melhorias Futuras

1. Persistência de Dados: Implementação de salvamento em arquivos CSV ou banco de dados SQL.

2. Interface Gráfica (GUI): Desenvolvimento de uma camada visual utilizando JavaFX ou Swing.

3. Busca Avançada: Implementação de algoritmos de busca por nome ou parte do e-mail.

## Autor

Guilherme Moreira Azevedo

LinkedIn: www.linkedin.com/in/guilhermemoreiraazevedo/

Email: guilhermemoreiraazevedo7@gmail.com

GitHub: https://github.com/GuilhermeMAzevedo
