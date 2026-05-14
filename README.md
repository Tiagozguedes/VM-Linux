<img width="648" height="442" alt="image" src="https://github.com/user-attachments/assets/c76dbd54-7a6c-49b8-94d4-6767f610599b" />

# portalweb

Projeto Spring Boot para CRUD de alunos (tabela `t_aluno`) conectado ao MySQL, com frontend e entrega via webhook.

## Stack

- Java 17 + Spring Boot 3.2.5
- MySQL 8.0
- Docker + Docker Compose

## Como executar

```bash
docker compose up --build
```

- Frontend: `http://20.151.50.19:8080`
- API: `http://20.151.50.19:8080/alunos`

O webhook pode ser sobrescrito pela variável `APP_WEBHOOK_URL`.
Configuração do banco em `src/main/resources/application.properties`.

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | `/` | Tela visual de gestão de alunos |
| GET | `/alunos` | Lista todos os alunos |
| GET | `/alunos/{rmAluno}` | Busca aluno por RM |
| POST | `/alunos` | Cria novo aluno |
| PUT | `/alunos/{rmAluno}` | Atualiza aluno |
| DELETE | `/alunos/{rmAluno}` | Remove aluno |
| POST | `/entregas` | Envia entrega final ao webhook |

## Testar no Postman

### 1. GET — Listar todos os alunos

```
http://20.151.50.19:8080/alunos
```

### 2. GET — Buscar aluno por RM

```
http://20.151.50.19:8080/alunos/564731
```

### 3. POST — Criar novo aluno

URL: `http://20.151.50.19:8080/alunos`

Header: `Content-Type: application/json`

Body (raw / JSON):

```json
{
  "rmAluno": "564731",
  "nmAluno": "Tiago Guedes",
  "dsTurma": "2TDSPW",
  "dsEmail": "tiago`fiap.com.br"
}
```

### 4. PUT — Atualizar aluno

URL: `http://20.151.50.19:8080/alunos/564731`

Header: `Content-Type: application/json`

Body (raw / JSON):

```json
{
  "rmAluno": "564731",
  "nmAluno": "Tiago Zaccaria Guedes",
  "dsTurma": "2TDSPW",
  "dsEmail": "tiago.guedes`fiap.com.br"
}
```

### 5. DELETE — Remover aluno

```
http://20.151.50.19:8080/alunos/564731
```

### 6. POST — Enviar entrega final ao webhook

URL: `http://20.151.50.19:8080/entregas`

Header: `Content-Type: application/json`

Body (raw / JSON):

```json
{
  "nome": "Tiago Guedes",
  "rm": "564731",
  "turma": "2TDSPW"
}
```

### 7. Frontend (navegador)

```
http://20.151.50.19:8080/
```
