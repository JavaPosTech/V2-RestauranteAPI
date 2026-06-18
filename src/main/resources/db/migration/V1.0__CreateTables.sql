CREATE TABLE IF NOT EXISTS public.tipo_usuario (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.tipo_cozinha (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    id_tipousuario INTEGER NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_tipousuario) REFERENCES public.tipo_usuario(id)
);

CREATE TABLE IF NOT EXISTS public.restaurante (
    id SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    id_tipocozinha INTEGER NOT NULL,
    hora_abertura TIME NOT NULL,
    hora_fechamento TIME NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES public.usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_tipocozinha) REFERENCES public.tipo_cozinha(id)
);

CREATE TABLE IF NOT EXISTS public.cardapio (
    id SERIAL PRIMARY KEY,
    id_restaurante INTEGER NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    consumo_local BOOLEAN NOT NULL DEFAULT FALSE,
    foto VARCHAR(255),
    FOREIGN KEY (id_restaurante) REFERENCES public.restaurante(id) ON DELETE CASCADE
);