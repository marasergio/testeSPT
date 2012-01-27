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
	<h1>Produtos</h1>
	<hr />

	<html:link action="home">Home</html:link>
	||
	<html:link action="/novoProduto">Cadastrar Produto</html:link>

	<br />
	<br />

	<c:if test="${empty produtos}">
		<p>Nenhum produto cadastrado!</p>
	</c:if>


	<c:if test="${not empty produtos}">
		<table border="0" style="margin-top: 10px" cellpadding="3">
			<tr>
				<th class="id">Id</th>
				<th class="nome">Nome Produto</th>
				<th class="valor">Valor</th>
				<th>Alterar</th>
				<th>Excluir</th>

			</tr>
			<c:forEach items="${produtos}" var="produto" varStatus="i">
				<c:if test="${i.count % 2 == 0 }">
					<tr bgcolor="#FFF">
				</c:if>
				<c:if test="${i.count % 2 != 0 }">
					<tr bgcolor="#E8E8E8">
				</c:if>
				<td class="id">${produto.id}</td>
				<td class="nome">${produto.nome}</td>
				<td>R$ ${produto.valor}</td>
				<td align="center"><a
					href="editarProduto.do?produto.id=${produto.id}&action=editar">
						edit</a>
				</td>
				<td align="center"><a
					href="removeProduto.do?produto.id=${produto.id}&action=remover">
						X</a>
				</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html:html>