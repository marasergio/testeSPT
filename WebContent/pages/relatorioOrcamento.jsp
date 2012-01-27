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
	<h1>Relatório de Orçamentos</h1>
	<hr />
	
	<p><html:link action="/home">[voltar]</html:link></p>

	<c:forEach items="${relatorioOrcamentos}" var="relatorio">
		<div style="border: 1px solid #999; margin-top:20px; width:400px">
		<table border="0" cellpadding="3" width="400px">
			<tr>
				<td colspan="2" bgcolor="#E8E8E8">${relatorio.vendedor.nome}</td>
			</tr>
			<tr>
				<td><b>Situação</b></td>
				<td class="quantidade"><b>Quantidade</b></td>
			</tr>
			<tr>
				<td>Prospecção</td>
				<td class="quantidade">${relatorio.qtdProspeccao}</td>
			</tr>
			<tr>
				<td>Elaboração de Proposta</td>
				<td class="quantidade">${relatorio.qtdElaboracao}</td>
			</tr>
			<tr>
				<td>Aprovação</td>
				<td class="quantidade">${relatorio.qtdAprovacao}</td>
			</tr>
			<tr>
				<td>Aprovado</td>
				<td class="quantidade">${relatorio.qtdAprovado}</td>
			</tr>
		</table>
		</div>
	</c:forEach>
</body>
</html:html>