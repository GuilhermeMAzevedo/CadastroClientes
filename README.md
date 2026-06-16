# Sistema de Cadastro de Clientes em Java

## 1. Introdução

Este projeto consiste em um sistema robusto de gerenciamento de clientes desenvolvido em Java, com foco primordial nos pilares da Programação Orientada a Objetos (POO) e na modularidade de código. A aplicação foi desenhada para oferecer uma experiência de console fluida, garantindo a integridade dos dados através de camadas rigorosas de validação e uma arquitetura que separa claramente as responsabilidades de negócio, armazenamento e interface.

O diferencial técnico do sistema está na sua camada de persistência em memória, construída sobre uma **lista duplamente encadeada implementada do zero**, sem recorrer às coleções prontas da biblioteca padrão do Java.

## 2. Objetivos do Projeto

O desenvolvimento deste sistema visou consolidar conhecimentos avançados em engenharia de software, focando nos seguintes pontos:

- Implementação de uma estrutura de dados personalizada para gestão eficiente de memória e controle total sobre a manipulação dos nós.
- Aplicação de uma arquitetura em camadas para garantir a escalabilidade e a manutenibilidade do sistema.
- Criação de uma interface de linha de comando (CLI) resiliente a falhas de entrada do usuário.
- Garantia de unicidade de registros e integridade das informações cadastrais.
- Atenção à complexidade algorítmica (Big O) das operações sobre a estrutura de dados.

## 3. Tecnologias Utilizadas

- **Linguagem:** Java JDK 17+
- **Estrutura de Dados:** Lista Duplamente Encadeada Customizada (implementação própria, sem `java.util.List`)
- **Processamento de Texto:** Expressões Regulares (Regex) para validações de formato
- **Iteração:** Interfaces `Iterable` e `Iterator` da `java.util`, para suporte a `for-each` sobre a estrutura própria
- **Paradigma:** Programação Orientada a Objetos (POO)

## 4. Estrutura do Projeto

```
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
```

## 5. Descrição das Classes

### 5.1. Customer.java

Classe de modelo (POJO) que representa a entidade Cliente. Possui os atributos `id`, `name`, `email` e `phone`. O campo `id` é definido como `final`, assegurando a imutabilidade da identidade do objeto após sua criação no sistema.

### 5.2. LinkedList.java

Uma implementação autoral de **lista duplamente encadeada genérica**. Cada nó mantém referências para o anterior (`prev`) e o próximo (`next`), e a lista guarda ponteiros para o início (`head`) e o fim (`tail`), permitindo inserção e remoção nas extremidades em tempo constante. O acesso e a remoção por índice utilizam **travessia bidirecional otimizada**: a busca inicia pela extremidade mais próxima do índice solicitado, reduzindo o percurso pela metade no pior caso. A classe implementa a interface `Iterable`, habilitando o uso de laços `for-each` e garantindo controle total sobre a manipulação dos nós.

### 5.3. Repository.java

Atua como a camada de persistência em memória. Gerencia a instância da `LinkedList`, isolando as operações de baixo nível (salvamento, busca, atualização e deleção) das regras de negócio da aplicação.

### 5.4. Service.java

Concentra a inteligência do sistema. É responsável pela geração automática e sequencial de IDs, pelo controle do fluxo de operações e pela aplicação de regras de negócio críticas, como a proibição de e-mails duplicados durante a criação ou atualização de registros.

### 5.5. Validator.java

Classe utilitária que utiliza Regex e constantes predefinidas para validar a integridade dos dados. Define limites de caracteres e formatos específicos para nomes, e-mails, telefones e IDs, impedindo a entrada de dados inconsistentes no sistema.

### 5.6. Main.java

Ponto de entrada da aplicação. Gerencia a interface CLI e utiliza blocos `try-catch` extensivos, com laços de re-tentativa, para tratar exceções e garantir que erros de entrada não interrompam a execução do programa.

## 6. Operações e Complexidade

O sistema implementa um **CRUD completo** (Create, Read, Update, Delete) sobre a estrutura de dados própria:

| Operação | Descrição |
|----------|-----------|
| **Create** | Cadastro de novo cliente com validação e ID sequencial |
| **Read** | Listagem de todos os clientes e busca por ID |
| **Update** | Atualização individual de nome, e-mail ou celular |
| **Delete** | Remoção de cliente por ID |

Complexidade das operações da `LinkedList`:

| Operação | Complexidade |
|----------|-------------|
| `addFirst` / `addLast` | O(1) |
| `removeFirst` / `removeLast` | O(1) |
| `get(index)` / `add(index)` / `remove(index)` | O(n), com constante reduzida pela travessia bidirecional |
| `search` / `contains` | O(n) |

## 7. Conceitos de POO Aplicados

- **Encapsulamento:** atributos privados com acesso controlado via métodos públicos.
- **Abstração:** a complexidade da estrutura de dados fica oculta por trás de interfaces simples, como `addLast`, `findById` e `remove`.
- **Generics:** a `LinkedList<T>` é parametrizada por tipo, podendo armazenar qualquer objeto, não apenas `Customer`.
- **SRP (Single Responsibility Principle):** cada classe possui uma única razão para mudar — validação, persistência, regra de negócio e interface estão separadas.
- **Injeção de Dependência:** o `Service` recebe o `Repository` via construtor, facilitando testes e manutenção.
- **Tratamento de Exceções:** uso estratégico de `IllegalArgumentException` e `IllegalStateException` para sinalizar violações de regras de negócio e estados inválidos.

## 8. Melhorias Futuras

- **Persistência de Dados:** implementação de salvamento em arquivos CSV ou banco de dados SQL, substituindo o armazenamento em memória por uma persistência durável.
- **Interface Gráfica (GUI / Front-end):** desenvolvimento de uma camada visual utilizando JavaFX ou Swing, ou ainda a evolução para uma aplicação web com front-end dedicado.
- **Exposição via API REST:** transformação da camada de serviço em uma API (por exemplo, com Spring Boot), permitindo que o CRUD seja consumido por diferentes clientes.
- **Busca Avançada:** implementação de busca por nome ou por parte do e-mail, além da busca por ID.
- **Testes Automatizados:** cobertura com JUnit, especialmente para os casos de borda da `LinkedList` (lista vazia, único elemento, inserção e remoção no meio).

## Autor

**Guilherme Moreira Azevedo**

- LinkedIn: [www.linkedin.com/in/guilhermemoreiraazevedo](https://www.linkedin.com/in/guilhermemoreiraazevedo/)
- Email: guilhermemoreiraazevedo7@gmail.com
- GitHub: [github.com/GuilhermeMAzevedo](https://github.com/GuilhermeMAzevedo)