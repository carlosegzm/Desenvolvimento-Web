# Filmix — Gerenciador de Filmes e Séries 🎬

## 1) Problema
Muitas pessoas assistem filmes e séries, mas acabam esquecendo quais já viram, quais ainda querem assistir e qual nota dariam para cada obra.  
Isso gera desorganização, repetições indesejadas e dificuldade em recomendar conteúdos para amigos.  
O foco inicial é no **usuário individual**, com o objetivo de permitir que ele registre, organize e atribua notas (0 a 10) às produções assistidas.

## 2) Atores e Decisores (quem usa / quem decide)
**Usuários principais:** Pessoas que desejam organizar seus filmes e séries assistidos.  
**Decisores/Apoiadores:** Professor da disciplina (avaliador do projeto).

## 3) Casos de uso (de forma simples)
Todos: Logar/deslogar do sistema; Manter dados cadastrais.  
Usuário:  
- Manter (inserir, mostrar, editar, remover) filmes/séries.  
- Marcar filmes/séries como vistos ou não vistos.  
- Atribuir nota de 0 a 10 para cada filme/série.  
- Filtrar lista por status (vistos / não vistos).

## 4) Limites e suposições
**Limites:** prazo final da disciplina; rodar no navegador; sem serviços pagos.  
**Suposições:** acesso à internet, navegador atualizado, GitHub para deploy, tempo do professor para avaliação.  
**Plano B:** se não houver internet → rodar local com banco H2 no Spring Boot; se não houver tempo do professor → testar com colegas.

## 5) Hipóteses + validação
**H-Valor:** Se o usuário puder registrar e avaliar seus filmes, então terá mais controle sobre seu histórico de entretenimento, melhorando sua organização.  
**Validação (valor):** teste com 5 usuários; sucesso se ≥4 conseguirem cadastrar, marcar como visto e avaliar sem ajuda.  

**H-Viabilidade:** Com Angular + Spring Boot + SQLite/Postgres, cadastrar e listar filmes responde em até 1 segundo.  
**Validação (viabilidade):** medir no protótipo com 30 ações; meta: pelo menos 27 de 30 ações em ≤1s.

## 6) Fluxo principal e primeira fatia
**Fluxo principal (curto):**  
1) Usuário faz login  
2) Adiciona filme/série  
3) Sistema salva no banco (Spring Boot + DB)  
4) Angular exibe o filme na lista com status e nota  

**Primeira fatia vertical (escopo mínimo):**  
Inclui: login simples, cadastrar filme, listar filmes em ordem, marcar como visto.  
**Critérios de aceite:**  
- Criar filme → aparece na lista com status e nota.  
- Marcar como visto → muda o status para ✔ Visto.

## 7) Esboços de algumas telas (wireframes)
### Tela de Login
![Wireframe - Login](Wireframes/1.png)

### Tela de Cadastro
![Wireframe - Cadastro](Wireframes/2.png)

### Tela de Lista de Filmes
![Wireframe - Lista de Filmes](Wireframes/3.png)

### Tela de Adicionar/Editar Filme
![Wireframe - Adicionar Filme](Wireframes/4.png)

## 8) Tecnologias
### 8.1 Navegador
**Navegador:** Chrome/Firefox/Edge (compatível com Angular)  
**Hospedagem Front-end:** GitHub Pages ou Vercel  

### 8.2 Front-end (Angular)
**Framework:** Angular  
**Estilização:** Angular Material / Bootstrap  
**Comunicação com API:** HTTPClient (REST API)  
**Hospedagem:** Vercel / Netlify  

### 8.3 Back-end (Spring Boot)
**Framework:** Spring Boot (Java 17+)  
**Banco de dados:** PostgreSQL (produção) / H2 (desenvolvimento)  
**Segurança:** Spring Security + JWT (autenticação), proteção CSRF habilitada  
**Deploy:** Railway / Render  

## 9) Plano de Dados (Dia 0) — somente itens 1–3
### 9.1 Entidades
- Usuario — pessoa que usa o sistema.  
- Filme — produção cadastrada pelo usuário.  

### 9.2 Campos por entidade
#### Usuario
| Campo           | Tipo      | Obrigatório | Exemplo            |
|-----------------|-----------|-------------|--------------------|
| id              | número    | sim         | 1                  |
| nome            | texto     | sim         | "Ana Souza"        |
| email           | texto     | sim (único) | "ana@exemplo.com"  |
| senha_hash      | texto     | sim         | "$2a$10$..."       |
| dataCriacao     | data/hora | sim         | 2025-08-20 14:30   |
| dataAtualizacao | data/hora | sim         | 2025-08-20 15:10   |

#### Filme
| Campo           | Tipo      | Obrigatório | Exemplo                 |
|-----------------|-----------|-------------|-------------------------|
| id              | número    | sim         | 2                       |
| usuario_id      | número fk | sim         | 1                       |
| nome            | texto     | sim         | "Matrix"                |
| genero          | texto     | sim         | "Ficção"                |
| status          | booleano  | sim         | true (= visto)          |
| nota            | número    | sim         | 9                       |
| dataCriacao     | data/hora | sim         | 2025-08-20 14:35        |
| dataAtualizacao | data/hora | sim         | 2025-08-20 14:50        |

### 9.3 Relações entre entidades
- Um **Usuario** tem muitos **Filmes** (1→N).  
- Um **Filme** pertence a um **Usuario** (N→1).  
