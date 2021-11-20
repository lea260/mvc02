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
	<table style="width: 100%; text-align: left;" border="1">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Editar</th>
		</tr>

		<%
		ArrayList<ClienteEntidad> lista = (ArrayList<ClienteEntidad>) request.getAttribute("lista");
		HttpSession session02 = request.getSession();
		String param02 = (String) session02.getAttribute("usuario");
		for (ClienteEntidad item : lista) {
		%>
		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getNombre()%></td>
			<td><%=item.getEdad()%></td>
			<td>
				<%
				String url = request.getContextPath() + "/cliente/ver?id=" + item.getId();
				
				%>
				<button>
					<a href="<%=url%>">ver cliente</a>
				</button>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	
	<a href="${pageContext.request.contextPath}/cliente/crear">Crear Cliente</a>

	<p>
		Usuario:
		<%=param02%>
	</p>

</body>
</html>