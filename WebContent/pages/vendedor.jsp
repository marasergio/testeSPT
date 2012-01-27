<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>

<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo" /></title>
<link rel="StyleSheet" href="./css/style.css" type="text/css" />
</head>
<body>
	<h1>Vendedor</h1>
	<hr/>
	<p><html:link action="/vendedores">[voltar]</html:link></p>
	
	<h3>O vendedor foi salvo com sucesso.</h3>
	
	<p>
		<strong>ID:</strong> <bean:write name="vendedorForm" property="vendedor.id"/><br/>
		<strong>Nome:</strong> <bean:write name="vendedorForm" property="vendedor.nome"/>
	</p>

</body>
</html:html>