 CREATE DATABASE spt;
 USE spt;
 
 CREATE TABLE tb_vendedor(
 	vend_id BIGINT NOT NULL AUTO_INCREMENT,
 	vend_nome VARCHAR(150),
 	PRIMARY KEY (vend_id)
 );
 
 CREATE TABLE tb_produto(
 	prod_id BIGINT NOT NULL AUTO_INCREMENT,
 	prod_nome VARCHAR(50),
 	prod_valor DECIMAL(8,2),
 	PRIMARY KEY(prod_id)
 );
 
 CREATE TABLE tb_orcamento(
 	orca_id BIGINT NOT NULL AUTO_INCREMENT,
 	orca_cliente VARCHAR(150),
 	orca_data DATE,
 	orca_situacao VARCHAR(50),
 	orca_total_orcamento DECIMAL(8,2),
 	orca_vend_id BIGINT, --  FOREIGN KEY id_vendedor
 	PRIMARY KEY (orca_id)
 );
 
 CREATE TABLE tb_item(
 	item_id BIGINT NOT NULL AUTO_INCREMENT,
 	item_desconto DECIMAL(8,4),
 	item_valor DECIMAL(8,2),
 	item_orca_id BIGINT, -- FOREIGN KEY id_orcamento
 	item_prod_id BIGINT, -- FOREIGN KEY id_produto
 	PRIMARY KEY (item_id)
 );
   
 --  FOREIGN KEY id_vendedor
 ALTER TABLE tb_orcamento
 ADD CONSTRAINT id_vendedor
 FOREIGN KEY(orca_vend_id)
 REFERENCES tb_vendedor(vend_id);
 
 -- FOREIGN KEY id_orcamento
 ALTER TABLE tb_item
 ADD CONSTRAINT id_orcamento
 FOREIGN KEY (item_orca_id)
 REFERENCES tb_orcamento(orca_id),
 -- FOREIGN KEY id_produto
 ADD CONSTRAINT id_produto
 FOREIGN KEY (item_prod_id)
 REFERENCES tb_produto(prod_id);
 