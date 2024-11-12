
# API para Gerenciamento de Alunos e Cursos

Este projeto é uma API REST para gerenciamento de alunos e cursos, desenvolvida em Java utilizando Spring MVC, Hibernate e H2 Database.


## Como executar a aplicação:


- Clone o repositório:

```bash
  git clone https://github.com/matheus-singh/desafio-java-academia-sap
```

 
- Importe o projeto em sua IDE favorita (ex: Eclipse, IntelliJ)

- Configure o banco de dados H2

- Execute a aplicação




## Endpoints da API

#### Alunos:

Para cadastra um novo aluno:

```http
  POST /alunos
```

Exemplo de body:

```json
{
  "nome": "João Silva",
  "email": "joao.silva@example.com"
}
```

Para listar os alunos:

```http
  GET /alunos
```

Para listar todos os cursos em que um aluno está inscrito:

```http
  GET /alunos/{alunoId}/cursos
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `alusnoId` | `Long` | Chave para identificar o aluno. |



#### Cursos:

Cadastrar um novo curso:

```http
  POST /cursos
```

Exemplo de body:

```json
{
	"nome": "frances",
	"descricao": "Curso de frances"
}
```

Lista todos os cursos:

```http
  GET /cursos: 
```

Lista todos os alunos inscritos em um curso:

```http
  GET /cursos/{cursoId}/alunos
  ```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `cursoId` | `Long` | Chave para identificar o curso. |


#### Inscrições:

Inscreve um aluno em um curso: (com body JSON)

```http
  POST /inscricoes
```
Exemplo de body:

```json
{
	"alunoId":1,
	"cursoId":1
}
```

Inscreve um aluno em um curso: (com parâmetros na URL)

```http
  POST /inscricoes/aluno/{alunoId}/curso/{cursoId}
  ```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `alunoId` | `Long` | Chave para identificar o aluno. |
| `cursoId` | `Long` | Chave para identificar o curso. |
