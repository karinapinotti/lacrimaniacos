````markdown
# lacrimaniacos

Projeto desenvolvido como estudo de **Quarkus** na pós-graduação **UNIPDS - Java**.

API REST com foco em:
- Quarkus REST (endpoints)
- REST Client (consumo de APIs)
- OpenAPI / Swagger (documentação)
- Fault Tolerance (resiliência)
- Health Check (liveness / readiness)
- Observabilidade (OpenTelemetry + Micrometer)

---

## 🚀 Como rodar o projeto (passo a passo)

### 1. Pré-requisitos

- Java 21 (JDK obrigatório)
- Maven (ou usar o wrapper `mvnw`)
- Docker (para observabilidade com Jaeger)

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
* Ativa **live reload**
* Logs em tempo real
* Porta padrão: **8080**

---

## 🌐 Acessos locais

Após subir:

* Aplicação:

  ```
  http://localhost:8080
  ```

* Swagger:

  ```
  http://localhost:8080/q/swagger-ui
  ```

* Dev UI:

  ```
  http://localhost:8080/q/dev
  ```

* Health:

  ```
  http://localhost:8080/q/health
  ```

* Métricas (Micrometer):

  ```
  http://localhost:8080/q/metrics
  ```

---

## 🔍 Observabilidade

### 📌 OpenTelemetry (Tracing)

Responsável por rastrear requisições (**traces e spans**).

#### Subir Jaeger (visualização)

```bash
sudo docker run --name=jaeger -d \
-p 16686:16686 \
-p 4317:4317 \
-e COLLECTOR_OTLP_ENABLED=true \
jaegertracing/all-in-one:latest
```

Acessar UI:

```
http://localhost:16686
```

#### Configuração no Quarkus

```properties
quarkus.otel.exporter.otlp.endpoint=http://localhost:4317
quarkus.otel.exporter.otlp.protocol=grpc
```

✔ Cada requisição gera:

* 1 trace
* múltiplos spans (HTTP, banco, etc)

---

### 📌 Micrometer (Métricas)

Responsável por coletar dados numéricos da aplicação.

#### Exemplo no projeto

```java
@Counted("counted.getPessoa")
public List<Pessoa> getPessoa() {
    return Pessoa.listAll();
}
```

✔ Conta quantas vezes o endpoint foi chamado

---

### 📌 Integração

* OpenTelemetry → análise de fluxo (tracing)
* Micrometer → monitoramento (métricas)
* Jaeger → visualização de traces
* Prometheus → coleta de métricas

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

### Uber JAR

```bash
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

Rodar:

```bash
java -jar target/*-runner.jar
```

---

### Native

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

```bash
./mvnw quarkus:add-extension -Dextensions="quarkus-rest"
./mvnw quarkus:add-extension -Dextensions="quarkus-rest-client"
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-fault-tolerance"
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-health"
./mvnw quarkus:add-extension -Dextensions="quarkus-opentelemetry"
./mvnw quarkus:add-extension -Dextensions="quarkus-micrometer"
./mvnw quarkus:add-extension -Dextensions="quarkus-micrometer-registry-prometheus"
```

---

## 🧠 Conceitos aplicados

### Observabilidade

* **Traces** → caminho da requisição (OpenTelemetry)
* **Métricas** → comportamento do sistema (Micrometer)

### REST

* Endpoints HTTP
* GET, POST, PUT, DELETE

### Fault Tolerance

* Retry, timeout, fallback

### Health Check

* Liveness e Readiness

---

## 📊 Logs

```bash
./mvnw quarkus:dev
```

Configuração:

```properties
quarkus.log.level=DEBUG
quarkus.log.category."org.karinabp".level=DEBUG
```

---

## ⚠️ Problemas comuns (já resolvidos)

### Maven incompatível

✔ usar:

```bash
./mvnw
```

---

### Docker permission denied

✔ solução:

```bash
sudo usermod -aG docker $USER
newgrp docker
```

---

### Micrometer não reconhecido

✔ solução:

```bash
./mvnw clean install
```

---


## 📁 Estrutura básica

```
src/
 ├── main/java
 │    └── resources
 ├── main/resources
 │    └── application.properties
```

---

## 📚 Referência

[https://quarkus.io/](https://quarkus.io/)

```

Se quiser, o próximo passo é deixar isso com foco em portfólio (arquitetura + diagrama + stack).
```
