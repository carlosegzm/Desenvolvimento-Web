# LojaFácil — Sistema de Pedidos para Loja de Roupas

## 1) Problema
Clientes de pequenas lojas de roupas têm dificuldade em saber quais produtos estão disponíveis no estoque.  
Isso causa frustração, perda de tempo e pedidos cancelados.  
O administrador também sofre com a falta de organização do estoque e com pedidos que se perdem.  
No início, o foco será clientes que desejam comprar roupas online e o administrador da loja, com o objetivo de organizar o catálogo e simplificar o processo de pedidos.

## 2) Atores e Decisores (quem usa / quem decide)
Usuários principais:  
- Cliente (faz pedidos e acompanha status)  
- Administrador (cadastra roupas, controla estoque, gerencia pedidos)  

Decisores/Apoiadores:  
- Dono da loja de roupas  

## 3) Casos de uso (de forma simples)
Todos: Logar/deslogar; manter dados cadastrais  

Cliente:  
- Visualizar catálogo de roupas disponíveis  
- Inserir novo pedido  
- Listar seus pedidos e ver status (pendente, confirmado, entregue)  

Administrador:  
- Manter (inserir, editar, remover, listar) produtos/estoque  
- Listar todos os pedidos  
- Atualizar status do pedido (pendente → confirmado → entregue)  

## 4) Limites e suposições
Limites: entrega final até o fim da disciplina (2025-11-30); rodar no navegador; uso de Spring Boot + Angular; sem serviços pagos.  
Suposições: internet no laboratório; GitHub acessível; banco de dados configurado (MySQL ou H2); tempo de teste em sala.  
Plano B: sem internet → rodar local com Angular + Spring Boot e banco H2 embutido; sem tempo do professor → testar com 3 colegas.  

## 5) Hipóteses + validação
H-Valor: Se o cliente visualizar roupas disponíveis em estoque, então terá mais confiança e concluirá pedidos sem precisar perguntar por WhatsApp.  
Validação (valor): teste com 5 clientes; sucesso se ≥4 conseguirem cadastrar e acompanhar pedidos sem ajuda.  

H-Viabilidade: Com Spring Boot + Angular, listar roupas disponíveis responde em até 1s.  
Validação (viabilidade): medir no protótipo com 30 requisições; meta: pelo menos 27 em 1s ou menos.  

## 6) Fluxo principal e primeira fatia
**Fluxo principal (curto):**  
1) Cliente faz login  
2) Escolhe roupas no catálogo  
3) Cria pedido  
4) Sistema salva e vincula ao estoque  
5) Admin atualiza status  
6) Cliente acompanha o pedido  

**Primeira fatia vertical (escopo mínimo):**  
Inclui:  
- Uma tela (catálogo de produtos)  
- Uma ação principal (cadastrar roupa)  
- Salvar (nome, tamanho, quantidade em estoque)  
- Mostrar (lista de roupas cadastradas)  

Critérios de aceite:  
- Criar produto → aparece na lista com nome e estoque  
- Atualizar estoque → lista reflete a mudança  

## 7) Esboços de algumas telas (wireframes)
- Tela de Login  
- Tela do Cliente (visualizar catálogo, fazer pedido, ver status)  
- Tela do Administrador (gerenciar produtos e estoque, visualizar pedidos)  

*(wireframes podem ser feitos no Figma ou desenhados no papel e adicionados como imagem aqui)*  

## 8) Tecnologias

### 8.1 Navegador
**Navegador:** Angular + Bootstrap  
**Armazenamento local (se usar):** —  
**Hospedagem:** GitHub Pages (front-end)  

### 8.2 Front-end (servidor de aplicação, se existir)
**Front-end (servidor):** Angular  
**Hospedagem:** GitHub Pages / Vercel  

### 8.3 Back-end (API/servidor, se existir)
**Back-end (API):** Java + Spring Boot  
**Banco de dados:** MySQL (produção) / H2 (teste)  
**Deploy do back-end:** Render / Railway  

## 9) Plano de Dados (Dia 0) — somente itens 1–3

### 9.1 Entidades
- **Usuário** — pessoa que acessa o sistema (cliente ou admin)  
- **Produto** — roupa cadastrada no catálogo  
- **Pedido** — compra realizada pelo cliente  
- **ItemPedido** — ligação entre pedido e produtos (com quantidade)  

### 9.2 Campos por entidade

#### Usuario
| Campo           | Tipo                          | Obrigatório | Exemplo             |
|-----------------|-------------------------------|-------------|---------------------|
| id              | número                        | sim         | 1                   |
| nome            | texto                         | sim         | "Ana Souza"         |
| email           | texto                         | sim (único) | "ana@exemplo.com"   |
| senha_hash      | texto                         | sim         | "$2a$10$..."        |
| papel           | número (0=cliente, 1=admin)   | sim         | 0                   |
| dataCriacao     | data/hora                     | sim         | 2025-08-21 14:30    |
| dataAtualizacao | data/hora                     | sim         | 2025-08-21 15:10    |

#### Produto
| Campo           | Tipo       | Obrigatório | Exemplo             |
|-----------------|------------|-------------|---------------------|
| id              | número     | sim         | 1                   |
| nome            | texto      | sim         | "Camiseta Básica"   |
| tamanho         | char       | sim         | "M"                 |
| preco           | número     | sim         | 49.90               |
| quantidadeEstoque | número   | sim         | 15                  |
| dataCriacao     | data/hora  | sim         | 2025-08-21 14:35    |
| dataAtualizacao | data/hora  | sim         | 2025-08-21 14:50    |

#### Pedido
| Campo           | Tipo       | Obrigatório | Exemplo             |
|-----------------|------------|-------------|---------------------|
| id              | número     | sim         | 10                  |
| usuario_id      | número (fk)| sim         | 1                   |
| dataCriacao     | data/hora  | sim         | 2025-08-21 14:40    |
| status          | char       | sim         | 'p' (pendente), 'c' (confirmado), 'e' (entregue) |
| dataAtualizacao | data/hora  | sim         | 2025-08-21 14:55    |

#### ItemPedido
| Campo           | Tipo       | Obrigatório | Exemplo             |
|-----------------|------------|-------------|---------------------|
| id              | número     | sim         | 100                 |
| pedido_id       | número (fk)| sim         | 10                  |
| produto_id      | número (fk)| sim         | 1                   |
| quantidade      | número     | sim         | 2                   |

### 9.3 Relações entre entidades
- Um Usuário tem muitos Pedidos (1→N).  
- Um Pedido pertence a um Usuário (N→1).  
- Um Pedido tem muitos ItensPedido (1→N).  
- Um Produto pode estar em muitos ItensPedido (N→N via ItemPedido).