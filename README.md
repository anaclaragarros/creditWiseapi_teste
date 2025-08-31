# Gerenciamento de Limite de Crédito

Este projeto é um serviço de backend para gerenciar limites de crédito de clientes. Ele oferece uma API REST para consulta, atualização e histórico de alterações, com regras de negócio bem definidas e validações de segurança.

## 🚀 Tecnologias Utilizadas

* **Java 21**: A versão mais recente do Java para desenvolvimento robusto e seguro.
* **Spring Boot 3.5.5**: Framework para construção de aplicações Spring de forma rápida e com menos configuração.
* **Gradle (Kotlin DSL)**: Ferramenta de build para gerenciar dependências e a estrutura do projeto.
* **Lombok**: Biblioteca que reduz a verbosidade do código Java, gerando getters, setters, construtores e outros métodos automaticamente.
* **Insomnia**: Ferramenta para testar e documentar os endpoints da API.
* **MySQL**: Banco de dados relacional para persistir os dados de clientes, limites e histórico.

---

## ✨ Funcionalidades da API

O sistema oferece os seguintes endpoints:

* **Consultar Limite de Crédito:**
    * EX: `GET /api/v1/clientes/{id}/limite`
    * Retorna o limite de crédito atual de um cliente específico pelo seu ID.

* **Atualizar Limite de Crédito:**
    * EX: `PUT /api/v1/clientes/{id}/limite`
    * Atualiza o limite de crédito de um cliente. A requisição deve conter o novo valor.

* **Histórico de Alterações:**
    * `GET /api/v1/historico`
    * Retorna um registro de todas as alterações de limite de crédito, incluindo quem realizou a mudança e a data/hora.

---

## 🔒 Regras de Negócio e Segurança

As seguintes regras são aplicadas para garantir a integridade dos dados e a segurança do sistema:

* **Validação de Limite**: Limites de crédito não podem ser valores negativos.
* **Controle de Acesso**: Apenas usuários com a role `CREDIT_LIMIT_ADMIN` têm permissão para atualizar os limites de crédito.
* **Clientes VIP**: Clientes marcados como `isVip` têm um limite mínimo obrigatório, que é validado durante a atualização.

---

## 🛠️ Como Executar o Projeto

1.  **Pré-requisitos**: Certifique-se de ter o **JDK 21** e o **MySQL** instalados.
2.  **Configuração do Banco de Dados**:
    * Crie um banco de dados no MySQL.
    * Atualize as credenciais de acesso no arquivo de configuração do Spring Boot.
3.  **Executar a Aplicação**:
    * Abra o projeto na sua IDE (IntelliJ IDEA, VS Code, etc.).
    * Sincronize as dependências do Gradle.
    * Execute a classe principal da aplicação Spring Boot para iniciar o serviço.

## 🤝 Contribuições

Sinta-se à vontade para abrir **pull requests** ou **issues** para melhorias, novas funcionalidades ou correções de bugs.
