# 🎵 Lacrimaniacos API

API REST desenvolvida com **Java + Quarkus**, focada em microsserviços modernos, observabilidade e boas práticas de backend.

Projeto criado para estudos avançados de:
- Microsserviços
- APIs REST
- Observabilidade
- Logging e métricas
- REST Client
- Panache ORM
- Arquitetura moderna com Quarkus

---

# 🚀 Tecnologias

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-4695EB?style=for-the-badge&logo=quarkus&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST_API-000000?style=for-the-badge)
![Microservices](https://img.shields.io/badge/Microservices-1F1F1F?style=for-the-badge)
![Observability](https://img.shields.io/badge/Observability-6A5ACD?style=for-the-badge)

---

# 📚 Conceitos aplicados

- Estruturação de APIs REST
- Arquitetura em camadas
- DTOs
- Injeção de dependência
- Tratamento de exceções
- Microsserviços com Quarkus
- REST Client
- Panache ORM
- Observabilidade
- Health Check
- Logging
- Métricas
- Configuração via application.properties

---

# ⚙️ Tecnologias e recursos do Quarkus

## 🔹 RESTEasy Reactive / Web

Criação de endpoints REST performáticos utilizando Quarkus.

Exemplo:

```java
@Path("/bands")
@GET
public List<Band> getAll() {
    return Band.listAll();
}
```

---

## 🔹 Panache ORM

Simplificação da camada de persistência com Hibernate Panache.

Exemplo:

```java
Band.findById(id);
Band.listAll();
```

Reduz bastante código boilerplate comparado ao JPA tradicional.

---

## 🔹 REST Client

Comunicação entre microsserviços e APIs externas utilizando REST Client do Quarkus.

Exemplo:

```java
@RegisterRestClient
public interface ExternalServiceClient {
}
```

---

## 🔹 Observabilidade

Monitoramento da aplicação com:

- Health Check
- Métricas
- Logs estruturados

Endpoints:

```bash
/q/health
/q/metrics
```

---

# 📂 Estrutura do projeto

```bash
src
 ├── main
 │    ├── java
 │    │     └── br/com/pinotti
 │    └── resources
 │
 └── test
```

---

# ⚙️ Como executar

## Clonar projeto

```bash
git clone https://github.com/karinapinotti/lacrimaniacos.git
```

---

## Entrar na branch

```bash
git checkout feature/aula9_observability
```

---

## Executar aplicação

```bash
./mvnw quarkus:dev
```

Aplicação sobe em:

```bash
http://localhost:8080
```

---

# 🧠 Objetivo do projeto

Projeto desenvolvido para prática de:
- Quarkus
- Microsserviços
- REST APIs
- REST Client
- Panache ORM
- Backend Java moderno
- Observabilidade
- Monitoramento de aplicações

---

# 👩‍💻 Autora

Karina Pinotti

💼 Software Engineer | Data Engineer  
☁️ Java • Quarkus • Spring Boot • Cloud • Data Engineering

🔗 GitHub:
https://github.com/karinapinotti

🔗 LinkedIn:
https://www.linkedin.com/in/karina-bruschi-pinotti/

---

# 📌 Status

🚧 Projeto em evolução para estudos e aprimoramento técnico.
