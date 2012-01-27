<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html:html xhtml="true" lang="true">
<head>
<title><bean:message key="site.titulo"/></title>
<link rel="StyleSheet" href="./css/style.css" type="text/css"/>
</head>
<body>
	<h1>Produtos</h1>
	<hr/>
	<p><html:link action="/produtos">[voltar]</html:link></p>

	<h3>Os dados do produto foram salvos com sucesso</h3>
	
	
	<p>
	Id: <bean:write name="produtoForm" property="produto.id"/><br/>
	Nome: <bean:write name="produtoForm" property="produto.nome"/><br/>
	Valor R$ <bean:write name="produtoForm" property="produto.valor"/>
	</p>
</body>
</html:html>