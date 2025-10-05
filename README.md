---

## 📘 Estudo de Spring Batch com Java 21

Este repositório contém um estudo prático sobre o uso do [Spring Batch](https://spring.io/projects/spring-batch) com a linguagem de programação Java versão 21. O objetivo é explorar os principais conceitos, componentes e padrões utilizados em aplicações de processamento em lote.

---

### 🧰 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Batch**
- **Maven**
- **H2 Database (para testes)**
- **SpringToolSuite4**

---

### 🎯 Objetivos do Estudo

- Compreender os conceitos fundamentais do Spring Batch.
- Implementar jobs simples e complexos com steps, readers, processors e writers.
- Utilizar banco de dados para persistência de metadados de execução.
- Explorar estratégias de particionamento e paralelismo.
- Integrar com arquivos CSV e JSON.

---

### 📂 Estrutura do Projeto

```bash
spring-batch-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/albeneto/spring_batch_app/
│   │   │       ├── config/       # Configurações gerais do Spring Batch e beans
│   │   │       ├── job/          # Definições de jobs e suas sequências
│   │   │       ├── step/         # Steps que compõem os jobs
│   │   │       ├── tasklet/      # Implementações de Tasklets personalizados
│   │   │       └── SpringBatchApp.java  # Classe principal da aplicação
│   ├── resources/
│   │   ├── application.yml       # Configurações da aplicação
│   │   └── data/                 # Arquivos de entrada para processamento
│   │       └── input.csv
├── logs/
│   └── app.log                   # Arquivo de log gerado pela aplicação
├── pom.xml                       # Gerenciador de dependências Maven
└── README.md                     # Documentação do projeto
```
---

### 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/spring-batch-java21.git
   cd spring-batch-java21
   ```

2. Compile e execute:
   ```bash
   mvn clean spring-boot:run
   ```

3. Acompanhe os logs no console para verificar a execução dos jobs.

---

### 📚 Conteúdo Estudado

- `JobBuilderFactory` e `StepBuilderFactory`
- `ItemReader`, `ItemProcessor`, `ItemWriter`
- `FlatFileItemReader` para leitura de arquivos CSV
- Persistência de metadados com `JdbcJobRepository`
- Estratégias de chunk e tasklet
- Tratamento de falhas e reprocessamento

---

### 📝 Referências

- [Documentação oficial do Spring Batch](https://docs.spring.io/spring-batch/docs/current/reference/html/)
- [Guia Spring Batch com Spring Boot](https://spring.io/guides/gs/batch-processing/)
- [Java 21 Release Notes](https://openjdk.org/projects/jdk/21/)

---
