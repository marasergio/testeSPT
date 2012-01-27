<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>

<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo" /></title>

<link rel="StyleSheet" href="./css/style.css" type="text/css"/>
</head>
<body>
	<h1><bean:message key="site.titulo" /></h1>
	<hr/>
	
	<ul>
		<li><html:link action="/produtos">Produtos</html:link></li>
		<li><html:link action="/vendedores">Vendedores</html:link></li>
		<li><html:link action="/orcamentos">Orçamentos</html:link></li>
		<li><html:link action="/relatorio">Relatório de Orçamentos</html:link></li>
	</ul>

</body>
</html:html>