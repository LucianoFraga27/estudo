-- Inserts para a tabela ENDERECO
INSERT INTO LOGOS.ENDERECO (CEP, LOGRADOURO, LOCALIDADE, UF, BAIRRO, DDD) VALUES 
('01000-000', 'Rua Exemplo', 'São Paulo', 'SP', 'Centro', '11'),
('02000-000', 'Avenida Teste', 'São Paulo', 'SP', 'Vila Teste', '11'),
('03000-000', 'Rua Principal', 'Rio de Janeiro', 'RJ', 'Centro', '21'),
('04000-000', 'Avenida Central', 'Rio de Janeiro', 'RJ', 'Copacabana', '21'),
('05000-000', 'Rua das Flores', 'Belo Horizonte', 'MG', 'Centro', '31'),
('06000-000', 'Avenida dos Bandeirantes', 'Belo Horizonte', 'MG', 'Savassi', '31'),
('07000-000', 'Rua da Paz', 'Porto Alegre', 'RS', 'Centro', '51'),
('08000-000', 'Avenida Brasil', 'Porto Alegre', 'RS', 'Moinhos de Vento', '51'),
('09000-000', 'Rua das Árvores', 'Curitiba', 'PR', 'Centro Cívico', '41'),
('10000-000', 'Avenida das Palmeiras', 'Curitiba', 'PR', 'Batel', '41');

-- Inserts para a tabela PESSOA_ENDERECO
INSERT INTO LOGOS.PESSOA_ENDERECO (PESSOA_ID, CEP, NUMERO, COMPLEMENTO, PRINCIPAL) VALUES 
(1, '01000-000', 100, 'Apto 101', true),
(1, '02000-000', 200, NULL, false),
(2, '03000-000', 300, 'Casa', true),
(2, '04000-000', 400, NULL, false),
(3, '05000-000', 500, 'Sala 1', true),
(3, '06000-000', 600, NULL, false),
(4, '07000-000', 700, 'Loja 1', true),
(4, '08000-000', 800, NULL, false),
(5, '09000-000', 900, 'Conjunto 101', true),
(5, '10000-000', 1000, NULL, false);
