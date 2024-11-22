# Quiz Educativo: Gamificação para Conscientização sobre Energia

Este projeto promove a conscientização sobre energia sustentável por meio de um sistema de quiz interativo.

## Funcionalidades
- Cadastro de usuários com e-mail único.
- Sistema de pontuação.
- Apresentação de perguntas que ajude na Conscientização sobre Energia.

## Tecnologias
- Java 11
- Spring Boot
- H2 Database

## Como Rodar
1. Instale Java 11+.
2. Execute:
   ```bash
   mvn spring-boot:run
   ```

## Estrutura
- `model/`: Entidades do sistema.
- `repository/`: Repositórios Spring Data JPA.
- `service/`: Lógica de negócios.
- `controller/`: Endpoints REST.

## Endpoints
- `POST /api/user/register`: Registra um usuário.
- `GET /api/quiz/questions`: Lista perguntas.
- `GET /api/quiz/random-question`: Pergunta aleatória.
- `POST /api/quiz/submit-answer`: Submissão de resposta.

---

## Objetivo
Promover aprendizado sobre energia sustentável usando gamificação.