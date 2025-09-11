-- Tabela: usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id                SERIAL PRIMARY KEY,
    nome              VARCHAR(100) NOT NULL,
    email             VARCHAR(200) NOT NULL UNIQUE,
    senha_hash        VARCHAR(255) NOT NULL,
    foto_perfil       VARCHAR(255)
);

-- Tabela: generos
CREATE TABLE IF NOT EXISTS generos (
    id     SERIAL PRIMARY KEY,
    nome   VARCHAR(50) NOT NULL UNIQUE
);

-- Tabela: filmes
CREATE TABLE IF NOT EXISTS filmes (
    id             SERIAL PRIMARY KEY,
    titulo         VARCHAR(255) NOT NULL UNIQUE,
    sinopse        VARCHAR(255),
    diretor        VARCHAR(100),
    ano_lancamento DATE,
    foto_filme     VARCHAR(255)
);

-- Tabela: avaliacoes
CREATE TABLE IF NOT EXISTS avaliacoes (
    id             SERIAL PRIMARY KEY,
    usuario_id     INTEGER NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    filme_id       INTEGER NOT NULL REFERENCES filmes(id) ON DELETE CASCADE,
    nota           NUMERIC(3,1) NOT NULL CHECK (nota >= 0.0 AND nota <= 10.0),
    comentario     VARCHAR(255),
    data_avaliacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabela: filme_genero (Junção N-N)
CREATE TABLE IF NOT EXISTS filme_genero (
    filme_id  INTEGER NOT NULL REFERENCES filmes(id) ON DELETE CASCADE,
    genero_id INTEGER NOT NULL REFERENCES generos(id) ON DELETE CASCADE,
    PRIMARY KEY (filme_id, genero_id)
);

-- Tabela: usuario_lista_filmes (Junção N-N)
CREATE TABLE IF NOT EXISTS usuario_lista_filmes (
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    filme_id   INTEGER NOT NULL REFERENCES filmes(id) ON DELETE CASCADE,
    PRIMARY KEY (usuario_id, filme_id)
);


-- -> Inserções de Teste

INSERT INTO usuarios (nome, email, senha_hash) VALUES
('Jordan Ebertz', 'rosana.ebertz@gmmail.com', '$2a$10$abcdef...'),
('Bruno Costa', 'bruno.costa@email.com', '$2a$10$ghijkl...');

INSERT INTO generos (nome) VALUES ('Ficção Científica'), ('Ação'), ('Drama');

INSERT INTO filmes (titulo, diretor, ano_lancamento) VALUES
('Interestelar', 'Christopher Nolan', '2014-11-06'),
('O Poderoso Chefão', 'Francis Ford Coppola', '1972-09-08');

INSERT INTO filme_genero (filme_id, genero_id) VALUES (1, 1), (1, 3), (2, 3);

INSERT INTO avaliacoes (usuario_id, filme_id, nota, comentario) VALUES
(1, 1, 9.8, 'Visualmente incrível e com uma história emocionante.'),
(2, 2, 10.0, 'Obra-prima do cinema.');

INSERT INTO usuario_lista_filmes (usuario_id, filme_id) VALUES
(1, 1), -- Jordan adicionou Interestelar à sua lista
(1, 2), -- Jordan adicionou O Poderoso Chefão à sua lista
(2, 1); -- Bruno adicionou Interestelar à sua lista

-- -> Consultas de Teste

-- 1. Retorna todos os filmes e seus diretores.
SELECT titulo, diretor FROM filmes;

-- 2. Retorna os gêneros do filme 'Interestelar'.
SELECT g.nome FROM generos g JOIN filme_genero fg ON g.id = fg.genero_id JOIN filmes f ON f.id = fg.filme_id WHERE f.titulo = 'Interestelar';

-- 3. Retorna todas as avaliações com o nome do usuário e o título do filme.
SELECT u.nome AS usuario, f.titulo AS filme, a.nota, a.comentario FROM avaliacoes a JOIN usuarios u ON a.usuario_id = u.id JOIN filmes f ON a.filme_id = f.id;

-- 4. Retorna a nota média do filme 'Interestelar'.
SELECT AVG(nota) AS nota_media_interestelar FROM avaliacoes WHERE filme_id = (SELECT id FROM filmes WHERE titulo = 'Interestelar');

-- 5. Retorna os filmes na lista pessoal do usuário 'Jordan Ebertz'.
SELECT f.titulo FROM filmes f JOIN usuario_lista_filmes ulf ON f.id = ulf.filme_id JOIN usuarios u ON u.id = ulf.usuario_id WHERE u.nome = 'Jordan Ebertz';