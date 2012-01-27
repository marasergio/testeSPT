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
	<h1>Vendedores</h1>
	<hr />

	<html:link action="/home">Home</html:link>
	||
	<html:link action="/novoVendedor">Cadastrar Vendedor</html:link>

	<c:if test="${empty listVendedores}">
		<p>Nenhum vendedor cadastrado!</p>
	</c:if>


	<table border="0" style="margin-top: 20px" cellpadding="3">
		<tr>
			<th class="id">ID</th>
			<th class="nome">Nome do Vendedor</th>
			<th>Alterar</th>
		</tr>
		<c:forEach items="${listVendedores}" var="vendedor" varStatus="i">

			<c:if test="${i.count % 2 == 0 }">
				<tr bgcolor="#FFF">
			</c:if>
			<c:if test="${i.count % 2 != 0 }">
				<tr bgcolor="#E8E8E8">
			</c:if>

			<td class="id">${vendedor.id}</td>
			<td>${vendedor.nome}</td>
			<td style="text-align:center"><a
				href="editarVendedor.do?vendedor.id=${vendedor.id}&action=editar">
					<!-- img src="./images/editar.jpg" width="30px" height="30px"
					border="0" alt="editar" / --> edit</a></td>
			</tr>

		</c:forEach>
	</table>


</body>
</html:html>