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
</head>
<body>
	<h1>Novo Orçamento</h1>
	<hr/>
	
	Cliente: <bean:write name="orcamentoForm" property="orcamento.cliente"/><br/>
	Vendedor: <bean:write name="orcamentoForm" property="orcamento.vendedor.nome"/><br/>
	Situação: <bean:write name="orcamentoForm" property="orcamento.situacao"/><br/>
	Data venda: <bean:write name="orcamentoForm" property="dataVenda"/>
	
	<p>Produtos</p>
	
</body>
</html:html>