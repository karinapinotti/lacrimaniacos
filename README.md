````markdown
# lacrimaniacos

Projeto desenvolvido como estudo de **Quarkus** na pós-graduação **UNIPDS - Java**.

API REST com foco em:
- Quarkus REST (endpoints)
- REST Client (consumo de APIs)
- OpenAPI / Swagger (documentação)
- Fault Tolerance (resiliência)
- Health Check (liveness / readiness)

---

## 🚀 Como rodar o projeto (passo a passo)

### 1. Pré-requisitos

- Java 21 (JDK obrigatório)
- Maven (ou usar o wrapper `mvnw`)

Verificar instalação:
```bash
java -version
javac -version
````

Se não tiver `javac`:

```bash
sudo apt install openjdk-21-jdk
```

---

### 2. Rodar em modo desenvolvimento (RECOMENDADO)

```bash
./mvnw quarkus:dev
```

✔ O que acontece:

* Sobe servidor local
* Ativa **live reload** (alterou código → atualiza sozinho)
* Mostra logs em tempo real
* Porta padrão: **8080**

---

## 🌐 Acessos locais

Após subir:

* Aplicação:

  ```
  http://localhost:8080
  ```

* Swagger (testar API):

  ```
  http://localhost:8080/q/swagger-ui
  ```

* Dev UI (apenas dev mode):

  ```
  http://localhost:8080/q/dev
  ```

* Health Check:

  ```
  http://localhost:8080/q/health
  ```

---

## 📦 Build e execução

### Build padrão

```bash
./mvnw clean package
```

Rodar:

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

---

### Uber JAR (tudo em um arquivo)

```bash
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

Rodar:

```bash
java -jar target/*-runner.jar
```

---

### Native (opcional)

```bash
./mvnw package -Dnative
```

Sem GraalVM:

```bash
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Executar:

```bash
./target/lacrimaniacos-1.0.0-SNAPSHOT-runner
```

---

## ⚙️ Extensões usadas

Adicionar extensão:

```bash
mvn quarkus:add-extension -Dextensions="nome-da-extensao"
```

Usadas no projeto:

```bash
mvn quarkus:add-extension -Dextensions="quarkus-rest"
mvn quarkus:add-extension -Dextensions="quarkus-rest-client"
mvn quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
mvn quarkus:add-extension -Dextensions="quarkus-smallrye-fault-tolerance"
mvn quarkus:add-extension -Dextensions="quarkus-smallrye-health"
```

---

## 🧠 Conceitos aplicados

### REST

* API baseada em HTTP
* Endpoints = URLs
* Métodos: GET, POST, PUT, DELETE

### Quarkus Dev Mode

* Live reload automático
* Logs em tempo real
* Dev UI integrada

### Fault Tolerance

* Resiliência a falhas
* Retry, fallback, timeout

### Health Check

* **Liveness** → app está viva (se falhar, reinicia)
* **Readiness** → app pronta (se falhar, não recebe tráfego)

---

## 📊 Logs

Logs aparecem direto ao rodar:

```bash
./mvnw quarkus:dev
```

Para detalhar mais:

```properties
quarkus.log.level=DEBUG
```

Por pacote:

```properties
quarkus.log.category."org.karinabp".level=DEBUG
```

---

## ⚠️ Problemas comuns (já resolvidos)

### Erro Maven versão

Quarkus exige Maven ≥ 3.9
✔ Solução: usar `./mvnw`

---

### Erro "release version not supported"

Causa: JDK incompatível ou só JRE

✔ Solução:

```bash
sudo apt install openjdk-21-jdk
```

---

### Erro SSH GitHub (Permission denied publickey)

✔ Gerar chave:

```bash
ssh-keygen -t ed25519 -C "seuemail"
```

✔ Copiar:

```bash
cat ~/.ssh/id_ed25519.pub
```

✔ Adicionar no GitHub

---

## 📁 Estrutura básica

```
src/
 ├── main/java
 │    └── resources (endpoints REST)
 ├── main/resources
 │    └── application.properties
```

---

## 📚 Referência

[https://quarkus.io/](https://quarkus.io/)

```

Se quiser depois eu deixo isso com cara de projeto profissional (README para recrutador).
```
