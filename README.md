# 🚗 Projeto Veículos

Uma API RESTful desenvolvida em **Java com Spring Boot** para gerenciar informações de veículos (carros). O projeto implementa operações de **CRUD** (Create, Read, Update, Delete), utilizando banco de dados em memória **H2**, com suporte a testes automatizados usando **JUnit** e **MockMvc**.

---

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco H2
- Lombok
- Maven
- JUnit 5
- MockMvc

---

## 🔍 Funcionalidades

- ✅ Criar um novo carro
- ✅ Listar todos os carros
- ✅ Buscar carro por **placa**
- ✅ Atualizar carro por **placa**
- ✅ Deletar carro por **placa**

---

# Acessar a aplicação
API: http://localhost:8080/api/carros

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (deixe em branco)

---

📌 Exemplo de Requisição POST (JSON)
{
  "marca": "Toyota",
  "modelo": "Corolla",
  "anoFabricacao": 2020,
  "placa": "ABC-1234",
  "tipo": "Sedan",
  "valorMercado": 85000.00
}

---

✅ Testes
Os testes automatizados estão localizados em src/test/java.

Rodar os testes:
mvn test
