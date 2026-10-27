# Passo a Passo: Criando a Primeira API com Spring Boot

Este documento apresenta as etapas iniciais para desenvolver uma API utilizando Java e Spring Boot, abordando a configuração do projeto, a preparação do ambiente e a criação das primeiras rotas HTTP.

---

## 1. Fundamentos do Spring e Java

- **Spring:** Ecossistema Java que facilita o desenvolvimento de aplicações robustas e organizadas.
- **Spring Boot:** Simplifica a configuração do Spring, oferecendo dependências prontas e servidores embutidos para agilizar o desenvolvimento.
- **Verbosidade do Java:** Apesar de exigir mais código em algumas situações, o Java oferece tipagem forte, organização e facilidade de manutenção em sistemas de grande porte.

---

## 2. Criando o Projeto com Spring Initializr

A ferramenta [Spring Initializr]([https://start.spring.io/](<https://start.spring.io/>)) permite gerar a estrutura inicial da aplicação.

1. **Build:** Maven, responsável pelo gerenciamento das dependências e pela configuração do projeto no arquivo `pom.xml`.
2. **Metadados:**
   - `Group`: `com.exemplo`
   - `Artifact`: `minhaprimeiraapi`
   - `Packaging`: `Jar`
3. **Java:** Selecionar uma versão compatível com o JDK instalado e com o Spring Boot.
4. **Dependências:**
   - **Spring Web:** Permite criar endpoints e trabalhar com requisições HTTP.
   - **Spring Data MongoDB:** Prepara o projeto para integração com um banco de dados NoSQL.

---

## 3. Configurando o IntelliJ IDEA

Depois de baixar e extrair o projeto, é necessário importá-lo na IDE.

- Abrir a pasta principal do projeto.
- Verificar se o JDK e o nível da linguagem Java estão configurados corretamente.
- Sincronizar as dependências pelo Maven, utilizando a opção `Reload All Maven Projects`, caso necessário.

---

## 4. Servidor Web Embutido

O Spring Boot inclui o Apache Tomcat como servidor web padrão, dispensando uma instalação separada para executar a aplicação.

Ao iniciar a classe principal, identificada pela anotação `@SpringBootApplication`, o servidor é iniciado automaticamente, normalmente na porta `8080`.

---

## 5. Criando o Controller e as Rotas HTTP

Para disponibilizar os primeiros endpoints, cria-se uma classe responsável por receber as requisições.

- **Pacote `controllers`:** Organiza as classes responsáveis pelas rotas da API.
- **`@RestController`:** Indica que a classe atua como controladora REST e retorna dados no corpo da resposta HTTP.
- **`@RequestMapping("/api/estudantes")`:** Define o caminho inicial dos endpoints.
- **`@GetMapping`:** Mapeia requisições de consulta.
- **`@RequestParam`:** Obtém parâmetros enviados na query string.
- **`@PathVariable`:** Recupera valores presentes diretamente no caminho da URL.
- **`@PostMapping`, `@PutMapping` e `@DeleteMapping`:** Mapeiam requisições utilizadas, respectivamente, para criação, atualização e exclusão de recursos.

Os testes podem ser realizados pelo Insomnia, enviando requisições para `[http://localhost:8080/api/estudantes`](<http://localhost:8080/api/estudantes`>) e verificando as respostas da aplicação.

---

##  Código Completo

```java
package com.example.minha_primeira_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudantes")
public class Estudante {

@GetMapping
public String hello() {
return "Hello, world!";
}

@GetMapping("/id")
public String helloParam(@RequestParam int id) {
return "Hello, world! " + id;
}

// Ajustado para aceitar o ID na URL: /api/estudantes/123
@PostMapping("/{id}")
public String asd(@PathVariable int id) {
return "POST - Hello, world! " + id;
}

// Ajustado para aceitar o ID na URL: /api/estudantes/123
@PutMapping("/{id}")
public String dsdsd(@PathVariable int id) {
return "PUT - Hello, world! " + id;
}

// Ajustado para aceitar o ID na URL: /api/estudantes/123
@DeleteMapping("/{id}")
public String dsdd(@PathVariable int id) {
return "DELETE - Hello, world! " + id;
}
}
```

---

## 6. Resumo das Rotas

| Método HTTP | Anotação | URL de exemplo | Finalidade |
|---|---|---|---|
| GET | `@GetMapping` | `/api/estudantes` | Retornar uma mensagem inicial |
| GET | `@GetMapping("/id")` | `/api/estudantes/id?id=10` | Receber um ID via parâmetro de consulta |
| POST | `@PostMapping("/{id}")` | `/api/estudantes/123` | Simular uma operação de criação |
| PUT | `@PutMapping("/{id}")` | `/api/estudantes/123` | Simular uma atualização |
| DELETE | `@DeleteMapping("/{id}")` | `/api/estudantes/123` | Simular uma exclusão |

Para testar, basta iniciar a aplicação e enviar as requisições pelo Insomnia, utilizando o método HTTP e a URL correspondentes.

**Observação:** O código apresentado demonstra o mapeamento das rotas e o recebimento de parâmetros. As operações de POST, PUT e DELETE ainda não manipulam dados reais em um banco de dados.