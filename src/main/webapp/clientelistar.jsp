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
	<table style="width: 100%">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Edad</th>
		</tr>
		<tr>
			<% ArrayList<ClienteEntidad> lista = (ArrayList<ClienteEntidad>) request.getAttribute("lista"); %>
			
			<td>Alfreds Futterkiste</td>
			<td>Maria Anders</td>
			<td>Germany</td>
		</tr>

		<% for (ClienteEntidad item : lista) {
			
   %>

		<tr>
			<td>Centro comercial Moctezuma</td>
			<td>Francisco Chang</td>
			<td>Mexico</td>
		</tr>
	<% }  %>	
	</table>


</body>
</html>