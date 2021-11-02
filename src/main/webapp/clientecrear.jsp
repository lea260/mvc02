<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.*"%>
<%@page import="dto.ClienteEntidad"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>lista clientes</h1>
	<form action="${pageContext.request.contextPath}/cliente/nuevo"
		method="post">
		<table style="width: 100%; text-align: left;" border="0">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Edad</th>
			</tr>
			<%
			ClienteEntidad cliente = (ClienteEntidad) request.getAttribute("cli");
			%>
			<tr>
				<td><input type="text" value="" name="id"></td>
				<td><input type="text" value="" name="nombre"></td>
				<td><input type="text" value="" name="edad"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Crear Cliente"></td>
			</tr>
		</table>
	</form>
</body>
</html>