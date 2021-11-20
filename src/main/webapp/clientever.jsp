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
	<form action="${pageContext.request.contextPath}/cliente/modificar"
		method="post">
		<table style="width: 100%; text-align: left;" border="0">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Edad</th>
			</tr>
			<%
			ClienteEntidad cliente = (ClienteEntidad) request.getAttribute("cli");
			String param = (String) request.getAttribute("clave");
			HttpSession session02 = request.getSession();
			String param02 = (String) session02.getAttribute("usuario");
			%>
			<tr>
				<td><input type="text" value="<%=cliente.getId()%>" name="id"></td>
				<td><input type="text" value="<%=cliente.getNombre()%>"
					name="nombre"></td>
				<td><input type="text" value="<%=cliente.getEdad()%>"
					name="edad"></td>
			</tr>
			<%
			String url = request.getContextPath() + "/cliente/eliminar?id=" + cliente.getId();
			%>
			<tr>
				<td><button>
						<a href="<%=url%>">eliminar cliente</a>
					</button></td>
				<td><input type="submit" value="Modificar"></td>
			</tr>
		</table>

	</form>
	<p>
		Usuario:
		<%=param02%>
	</p>
</body>
</html>