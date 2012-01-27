<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo"/></title>
<link rel="StyleSheet" href="./css/style.css" type="text/css"/>
</head>
<body>


	<h1>Editar Produto</h1>
	<hr />
	<html:link action="/produtos">[voltar]</html:link>

	<div style="margin-top:20px;">
		<html:form action="/salvarProduto" method="GET">
			<html:hidden property="produto.id" />
			<table cellpadding="3">
				<tr>
					<td>Nome:</td>
					<td><html:text property="produto.nome" /></td>
				</tr>
				<tr>
					<td>Valor R$:</td>
					<td><html:text property="produto.valor" /></td>
				</tr>
				<tr align="right" >
					<td colspan="2"><html:submit property="action">Salvar</html:submit></td>
				</tr>
			</table>
		</html:form>
	</div>
</body>
</html:html>