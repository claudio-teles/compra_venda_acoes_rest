/* ========================================================= Inicializar valores para teste ========================================================= */


/* =================================================================== Clientes =================================================================== */

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (1, 'nome_01', 'senha_01');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (2, 'nome_02', 'senha_02');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (3, 'nome_03', 'senha_03');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (4, 'nome_04', 'senha_04');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (5, 'nome_05', 'senha_05');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (6, 'nome_06', 'senha_06');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (7, 'nome_07', 'senha_07');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (8, 'nome_08', 'senha_08');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (9, 'nome_09', 'senha_09');

INSERT INTO public.cliente(
	id_cliente, nome, senha)
	VALUES (10, 'nome_10', 'senha_10');


/* =================================================================== Empresa =================================================================== */

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (11, 'empresa_01', 5, 12, 1000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (12, 'empresa_02', 5000, 7000, 10000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (13, 'empresa_03', 1000, 3000, 20000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (14, 'empresa_04', 500, 1000, 20000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (15, 'empresa_05', 5000, 7000, 10000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (16, 'empresa_06', 7, 14, 10590);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (17, 'empresa_07', 15000, 18000, 30000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (18, 'empresa_08', 90, 120, 3700);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (19, 'empresa_09', 7000, 8000, 15000);

INSERT INTO public.empresa(
	id_empresa, nome, preco_compra_acao, preco_venda_acao, totao_em_acoes)
	VALUES (20, 'empresa_20', 3, 6, 1000);

/* ================================================================= Monitoramento ================================================================= */

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (21, 3, 10, 11);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (22, 5500, 6500, 12);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (23, 800, 3200, 13);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (24, 100, 700, 14);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (25, 1000, 8000, 15);

/* -- */

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (26, 5, 20, 16);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (27, 5500, 6500, 17);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (28, 11000, 15000, 18);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (29, 7100, 8150.90, 19);

INSERT INTO public.monitoramento(
	id_monitoramento, preco_compra, preco_venda, empresa_id_empresa)
	VALUES (30, 1.5, 5.1, 20);




	