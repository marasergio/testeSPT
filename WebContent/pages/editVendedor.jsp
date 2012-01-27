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
	<h1>Editar Vendedor</h1>
	<hr/>
	
	<p><html:link action="/vendedores">[voltar]</html:link></p>
	
	<html:form action="/salvarVendedor" method="GET">
		<html:hidden property="vendedor.id"/>
		Nome: <html:text property="vendedor.nome"/>
		<html:submit property="action">Salvar</html:submit>
	</html:form>
	
</body>
</html:html>