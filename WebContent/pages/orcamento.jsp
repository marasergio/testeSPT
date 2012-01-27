<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo" />
</title>
<link rel="StyleSheet" href="./css/style.css" type="text/css" />
</head>
<body>
	<h1>Orçamento</h1>
	<hr />

	<p>
		<html:link action="/orcamentos">[voltar]</html:link>
	</p>

	Nº do orçamento:
	<bean:write name="orcamentoForm" property="orcamento.id" />
	</br> Cliente:
	<bean:write name="orcamentoForm" property="orcamento.cliente" />
	<br /> Vendedor:
	<bean:write name="orcamentoForm" property="orcamento.vendedor.nome" />
	<br /> Situação:
	<bean:write name="orcamentoForm" property="orcamento.situacao" />
	<br /> Data da venda:
	<bean:write name="orcamentoForm" property="orcamento.dataVenda" />

	<h3>Produtos do Orçamento</h3>

	<c:if test="${empty itens}">
		<p>Nenhum produto foi adicionado.</p>
	</c:if>

	<c:if test="${not empty itens}">

		<table border="0" cellpadding="3">
			<tr>
				<th style="text-align: left; width: 180px">Produto</th>
				<th width="50px">Desconto</th>
				<th width="100px">Valor Total</th>
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
			</tr>
			</c:forEach>
			<tr bgcolor="green">
				<td colspan="4" style="text-align: right; color: #FFF">Total R$
					<bean:write name="orcamentoForm" property="orcamento.totalOrcamento" /></td>
			</tr>
		</table>

	</c:if>
</body>
</html:html>