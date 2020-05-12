<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div class="container">
			<h3 class="text-center">Sus Telefonos Disponibles</h3>
			<hr>
			<div class="container text-left">
			<form action="<%=request.getContextPath()%>/new?correo=<c:out value='${correo}' />" method="get">
			
			<tr>
				<td>Numero</td>
				<td><input type="text" name="numero"></td>
				<td><input type="hidden" name="correo" value='${correo}'></td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td><input type="text" name="tipo"></td>
			</tr>
			<tr>
			<tr>
				<td>Operadora</td>
				<td><input type="text" name="operadora"></td>
			</tr>
				<td><input type="hidden" name="parametro" value="sesion"></td>
				<td><input type="submit" value="Nuevo"  ></td>
			</tr>
		</form>
			
			<a href="<%=request.getContextPath()%>/new?correo=<c:out value='${correo}' />" class="btn btn-success">Nuevo_telefono
            </a>

			</div>
			<br>
			<table class="customers">
				<thead>
					<tr>
						<th>ID</th>
						<th>NUMERO</th>
						<th>TIPO</th>
						<th>OPERADOR</th>
						<th>Operaciones</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:set var = "p1" value = "${requestScope['telefonos']}" />
					<c:forEach var="telefono" items="${telefonos}">

						<tr>
							<td><c:out value="${telefono.id}" /></td>
							<td><c:out value="${telefono.numero}" /></td>
							<td><c:out value="${telefono.tipo}" /></td>
							<td><c:out value="${telefono.operadora}" /></td>
							<td><a href="edit?id=<c:out value='${telefono.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${telefono.id}' />">Elimnar</a>
							</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>

</body>
</html>