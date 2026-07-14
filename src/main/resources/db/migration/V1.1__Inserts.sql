INSERT INTO public.tipo_usuario (descricao) VALUES
('CLIENTE'),
('DONO DE RESTAURANTE');

INSERT INTO public.usuario (nome, sobrenome, id_tipousuario) VALUES
('GUSTAVO', 'CORREA', 2),
('ROBERTO', 'LOCATELLI', 2),
('EDUARDO', 'GERMANO', 2),
('CAROL', 'OLIVEIRA', 1),
('DEYVID', 'SANTOS', 1);

INSERT INTO public.restaurante (id_usuario, nome, endereco, tipocozinha, hora_abertura, hora_fechamento) VALUES
(1, 'SABOR DA CASA', 'RUA CENTRAL, 120', 'ITALIANA', '11:00', '22:00'),
(2, 'BELLA MASSA', 'AV. PAULISTA, 450', 'BRASILEIRA', '18:00', '23:30'),
(3, 'SUSHI PRIME', 'RUA JAPÃO, 88', 'JAPONESA', '12:00', '22:30');

INSERT INTO public.cardapio (id_restaurante, nome, descricao, preco, consumo_local, foto) VALUES
(1, 'FEIJOADA COMPLETA', 'FEIJOADA COM ARROZ E COUVE', 39.90, TRUE, 'https://meusite.com/images/cardapios/feijoada.png'),
(1, 'BIFE ACEBOLADO', 'BIFE COM ARROZ E FRITAS', 32.50, TRUE, 'https://meusite.com/images/cardapios/bife.png'),
(2, 'LASANHA BOLOGNESA', 'LASANHA TRADICIONAL ITALIANA', 44.90, TRUE, 'https://meusite.com/images/cardapios/lasanha.png'),
(3, 'COMBO SUSHI 20', '20 PEÇAS VARIADAS', 59.90, FALSE, 'https://meusite.com/images/cardapios/combo20.png'),
(3, 'TEMAKI SALMÃO', 'TEMAKI DE SALMÃO COM CREAM CHEESE', 28.90, FALSE, 'https://meusite.com/images/cardapios/temaki.png');