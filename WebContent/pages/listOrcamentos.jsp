<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo" /></title>
<link rel="StyleSheet" href="./css/style.css" type="text/css" />
</head>
<body>
	<h1>Orçamentos</h1>
	<hr />
	<p>
		<html:link action="/home">Home</html:link> || 
		<html:link action="/novoOrcamento">Novo Orçamento</html:link>
	</p>

	<c:if test="${empty listOrcamentos}">Nenhum Orçamento Cadastrado.</c:if>

	<c:if test="${not empty listOrcamentos}">

		<table border="0" cellpadding="3" id="orcamentos">
			<tr>
				<th>Nº</th>
				<th width="120px">Cliente</th>
				<th width="120px">Vendedor</th>
				<th width="160px">Situação</th>
				<th width="80px">Data</th>
				<th width="80px">Total</th>
			</tr>
			
			<c:forEach var="orcamento" items="${listOrcamentos}" varStatus="i">
				<c:if test="${i.count % 2 == 0 }">
					<tr bgcolor="#FFF">
				</c:if>
				<c:if test="${i.count % 2 != 0 }">
					<tr bgcolor="#E8E8E8">
				</c:if>
					<td>${orcamento.id}</td>
					<td>${orcamento.cliente}</td>
					<td>${orcamento.vendedor.nome}</td>
					<td>${orcamento.situacao}</td>
					<td>${orcamento.dataVenda}</td>
					<td>R$ ${orcamento.totalOrcamento}</td>
					<td><a href="./abrirOrcamento.do?action=abrir&id=${orcamento.id}">abrir</a></td>
				</tr>
			</c:forEach>
		</table>


	</c:if>
</body>
</html:html>