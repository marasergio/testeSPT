<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<!DOCTYPE html>
<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo" />
</title>
<link rel="StyleSheet" href="./css/style.css" type="text/css" />
<script language="javascript" type="text/javascript"
	src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var check = false;

		$("#desconto").hide();

		$('#checkbox').click(function() {
			if (check == false) {
				$("#desconto").show();
				check = true;
			} else {
				$("#desconto").hide();
				document.getElementById("descontoItem").value = 0.0;
				check = false;
			}
			setValorTotal();
		});

		$("#produto").click(function() {
			setValorTotal();
		});

	});

	function setValorTotal() {
		var valor = document.getElementById("produto").value;
		document.getElementById("valorTotal").value = getValorProduto(valor)
				.toFixed(2);
	}
	function calcValor() {

		var aux = document.getElementById("descontoItem").value;
		
		if(aux == ""){
			aux = "0";
		}
		var DESCONTO = parseFloat(aux);
		
		var PRODUTO = document.getElementById("produto").value;

		var valorProduto = getValorProduto(PRODUTO);

		var TOTAL = parseFloat(valorProduto - (DESCONTO / 100 * valorProduto));
		document.getElementById("valorTotal").value = TOTAL.toFixed(2);

	}

	function getValorProduto(valor) {
		var valorProduto = "0";

		for ( var i = 0; i < valor.length; i++) {
			var c = valor.charAt(i);
			if (c == '-') {
				i += 1;
				while (i < valor.length) {
					c = valor.charAt(i);
					valorProduto += c;
					i++;
				}
			}
		}
		return parseFloat(valorProduto);
	}
</script>
</head>
<body>
	<h1>Novo Orçamento</h1>
	<hr />
	<p>
		<html:link action="/orcamentos">[voltar]</html:link>
	</p>

	<html:form action="/adicionarItem">

		<table>
			<tr>
				<td>Cliente:</td>
				<td><html:text property="orcamento.cliente" /></td>
			</tr>
			<tr>
				<td>Vendedor:</td>
				<td><html:select property="idVendedor">
						<html:option value="0">selecione</html:option>
						<c:forEach var="vendedor" items="${vendedores}">
							<html:option value="${vendedor.id}">${vendedor.nome}</html:option>
						</c:forEach>
					</html:select></td>
			</tr>
			<tr>
				<td>Situação</td>
				<td><html:select property="orcamento.situacao">
						<html:option value="0">selecione</html:option>
						<html:option value="prospecção">Prospecção</html:option>
						<html:option value="elaboração de proposta">Elaboração de Propostas</html:option>
						<html:option value="aprovação">Aprovação</html:option>
						<html:option value="aprovado">Aprovado</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td>Data da Venda:</td>
				<td><html:text property="dataVenda" /> dd/mm/aaaa<br /></td>
			</tr>
		</table>
		<!-- SELECIONAR PRODUTO-->
		<h3>Selecione o Produto</h3>

		
			Produto:
			<html:select property="idProduto" styleId="produto">
			<html:option value="0">selecione</html:option>
			<c:forEach var="produto" items="${produtos}">
				<html:option value="${produto.id}-${produto.valor}">${produto.nome}</html:option>
			</c:forEach>
		</html:select>
		<br /> Desconto:
			<html:checkbox property="checkDesconto" styleId="checkbox" />
		<span id="desconto"> <html:text property="item.desconto"
				styleId="descontoItem" style="width:30px;" onkeyup="calcValor()" />%
		</span>
		<br />
			Total R$ <html:text property="item.valor" styleId="valorTotal"
			readonly="true" />

		<html:submit property="action">adicionar</html:submit>
		
		<!-- PRODUTOS ADICIONADOS -->
		<h3>Produtos do Orçamento</h3>
		
		<c:if test="${empty itens}">
			Nenhum produto adicionado.
		</c:if>
		
		<c:if test="${not empty itens}">
			
			<table border="0" cellpadding="3" width="450px">
				<tr>
					<th style="text-align: left; width: 180px">Produto</th>
					<th style="width: 50px">Desconto</th>
					<th>Valor Total</th>
					<th>Remover</th>
				</tr>
				<c:forEach items="${itens}" var="itemAdd" varStatus="i">
					<c:if test="${i.count % 2 == 0 }">
						<tr bgcolor="#FFF">
					</c:if>
					<c:if test="${i.count % 2 != 0 }">
						<tr bgcolor="#E8E8E8">
					</c:if>
					<td>${itemAdd.produto.nome}</td>
					<td style="text-align: center">${itemAdd.desconto} %</td>
					<td>R$ ${itemAdd.valor}</td>
					<td style="text-align: center"><a
						href="adicionarItem.do?action=remover&removeItem=${i.count}">
							X</a></td>
					</tr>
				</c:forEach>
				<tr bgcolor="green">
					<td colspan="4" style="text-align: right; color: #FFF">Total
						R$ <bean:write name="orcamentoForm" property="totalOrcamento" />
					</td>
				</tr>
			</table>
		</c:if>
		
		<div style="width:450px; text-align: center; background-color:#E8E8E8; margin-top:20px">
			<html:submit property="action">Salvar</html:submit>
		</div>
		

	</html:form>
</body>
</html:html>