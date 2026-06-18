INSERT INTO public.tipo_usuario (descricao) VALUES
('Cliente'),
('Dono de Restaurante');

INSERT INTO public.tipo_cozinha (descricao) VALUES
('Italiana'),
('Japonesa'),
('Mexicana'),
('Brasileira');

INSERT INTO public.usuario (nome, sobrenome, id_tipousuario) VALUES
('Gustavo', 'Correa', 2),
('Roberto', 'Locatelli', 2),
('Eduardo', 'Germano', 1),
('Carol', 'Oliveira', 1),
('Deyvid', 'Santos', 1);

INSERT INTO public.restaurante (id_usuario, nome, endereco, id_tipocozinha, hora_abertura, hora_fechamento) VALUES
(1, 'Sabor da Casa', 'Rua Central, 120', 4, '11:00', '22:00'),
(2, 'Bella Massa', 'Av. Paulista, 450', 1, '18:00', '23:30'),
(2, 'Sushi Prime', 'Rua Japão, 88', 2, '12:00', '22:30');

INSERT INTO public.restaurante_cardapio (id_restaurante, nome, descricao, preco, consumo_local, foto) VALUES
(1, 'Feijoada Completa', 'Feijoada com arroz e couve', 39.90, TRUE, 'feijoada.jpg'),
(1, 'Bife Acebolado', 'Bife com arroz e fritas', 32.50, TRUE, 'bife.jpg'),
(2, 'Lasanha Bolonhesa', 'Lasanha tradicional italiana', 44.90, TRUE, 'lasanha.jpg'),
(3, 'Combo Sushi 20', '20 peças variadas', 59.90, FALSE, 'combo20.jpg'),
(3, 'Temaki Salmão', 'Temaki de salmão com cream cheese', 28.90, FALSE, 'temaki.jpg');